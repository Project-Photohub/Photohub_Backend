package com.example.photohub.infra.threadlocal

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import org.springframework.context.ApplicationContext
import org.springframework.web.filter.GenericFilterBean

class ThreadLocalRemoveFilter(
    private val applicationContext: ApplicationContext,
) : GenericFilterBean() {

    private lateinit var threadLocalUserBeans: List<ThreadLocalUser>

    private var initialized = false

    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain
    ) {
        try {
            chain.doFilter(request, response)
        } finally {
            if (!initialized) {
                threadLocalUserBeans = applicationContext.getBeansOfType(ThreadLocalUser::class.java).values.toList()
                initialized = true
            }

            threadLocalUserBeans.forEach {
                it.removeAll()
            }
        }
    }
}