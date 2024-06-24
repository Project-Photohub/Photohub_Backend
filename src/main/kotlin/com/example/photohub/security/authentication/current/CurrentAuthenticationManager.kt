package com.example.photohub.security.authentication.current

import org.springframework.security.core.Authentication

/**
 * [SecurityContextHolder][org.springframework.security.core.context.SecurityContextHolder]에 대한 접근을 추상화하여 초기화 이후 재설정 불가능하도록 제어
 *
 * @since 24-06-2024
 * @author Daybreak312
 */
interface CurrentAuthenticationManager {

    /**
     * [SecurityContext][org.springframework.security.core.context.SecurityContext]에 [Authentication] 객체 삽입
     *
     * @throws com.example.photohub.usecase.exception.StatusCodeException [isInitialed]가 `true`일 경우
     */
    fun initial(authentication: Authentication?)

    /**
     * [SecurityContextHolder][org.springframework.security.core.context.SecurityContextHolder]가 초기화 되었는지 확인
     *
     * 임의의 [Authentication] 객체가 삽입되어 있거나 [initial]이 한 번이라도 호출되었을 경우 `true`로 설정됨
     *
     * @return 초기화 여부
     */
    fun isInitialed(): Boolean

    /**
     * 현재 [SecurityContext][org.springframework.security.core.context.SecurityContext]의 [Authentication] 객체를 반환
     *
     * @return [Authentication] 객체, 만약 [Authentication] 객체가 [AnonymousAuthenticationToken][org.springframework.security.authentication.AnonymousAuthenticationToken]이거나 `null`인 경우 `null` 반환
     */
    fun getCurrentOrNullIfAnonymous(): Authentication?

    /**
     * 현재 [SecurityContext][org.springframework.security.core.context.SecurityContext]의 [Authentication] 객체를 반환
     *
     * @return [Authentication] 객체, 만약 `null`인 경우 `null` 반환
     */
    fun getCurrent(): Authentication?
}