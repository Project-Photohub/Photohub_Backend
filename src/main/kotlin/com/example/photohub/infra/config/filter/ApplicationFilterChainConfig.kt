package com.example.photohub.infra.config.filter

import com.example.photohub.infra.editor.request.ResponseEditorFactory
import com.example.photohub.infra.exception.ErrorLogResponseFilter
import com.example.photohub.infra.exception.ExceptionConvertFilter
import com.example.photohub.infra.exception.ExceptionResolverFilterChain
import com.example.photohub.infra.exception.ExceptionResolverFilterChainProxy
import com.example.photohub.infra.threadlocal.ThreadLocalRemoveFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationFilterChainConfig(
    private val applicationContext: ApplicationContext,
    private val responseEditorFactory: ResponseEditorFactory
) {

    @Bean
    fun threadLocalRemover(): FilterRegistrationBean<ThreadLocalRemoveFilter> {
        val registration = FilterRegistrationBean(
            ThreadLocalRemoveFilter(
                applicationContext
            )
        )

        registration.order = -2_100_000_001
        return registration
    }

    @Bean
    fun exceptionResolverFilterChain(): FilterRegistrationBean<ExceptionResolverFilterChainProxy> {
        val filterChainProxy = ExceptionResolverFilterChainProxy(
            ExceptionResolverFilterChain(
                listOf(
                    ErrorLogResponseFilter(responseEditorFactory),
                    ExceptionConvertFilter()
                )
            )
        )

        val registration = FilterRegistrationBean(filterChainProxy)

        registration.order = -2_100_000_000
        return registration
    }
}