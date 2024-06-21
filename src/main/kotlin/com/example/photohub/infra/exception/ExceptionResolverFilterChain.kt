package com.example.photohub.infra.exception

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse

class ExceptionResolverFilterChain(
    val filters: List<Filter>,
) : FilterChain {

    init {
        if (filters.isEmpty()) {
            throw IllegalArgumentException("There is no filters registered!")
        }
    }

    private val currentIndex: ThreadLocal<Int?> = ThreadLocal.withInitial { null }

    override fun doFilter(request: ServletRequest, response: ServletResponse) {
        if (currentIndex.get() == null) {
            currentIndex.set(0)
        }

        if (currentIndex.get()!! >= filters.size) {
            currentIndex.set(null)
            return
        }

        filters[
            currentIndex.get()!!.also { currentIndex.set(it + 1) }
        ].doFilter(request, response, this)
    }
}