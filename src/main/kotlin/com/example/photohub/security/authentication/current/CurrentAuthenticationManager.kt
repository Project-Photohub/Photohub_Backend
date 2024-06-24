package com.example.photohub.security.authentication.current

import com.example.photohub.security.authentication.vo.UserLazyLoadingAuthentication

/**
 * 한 요청을 생명 주기로 가지는, [사용자 인증 정보][UserLazyLoadingAuthentication] 저장소
 *
 * 한 번 초기화된 이후엔 재설정할 수 없음
 *
 * @since 24-06-2024
 * @author Daybreak312
 */
interface CurrentAuthenticationManager {

    /**
     * 이번 요청의 인증 정보 초기화
     *
     * @throws com.example.photohub.usecase.exception.StatusCodeException 이미 초기화되었을 경우 : [isInitialed]가 `true`일 경우
     */
    fun initial(authentication: UserLazyLoadingAuthentication?)

    /**
     * 인증 정보가 초기화되었는지 확인
     *
     * [initial]이 한 번이라도 호출되었을 경우 `true`로 설정됨
     *
     * @return 초기화 여부
     */
    fun isInitialed(): Boolean

    /**
     * 현재 설정된 [UserLazyLoadingAuthentication] 객체를 반환
     *
     * @return [UserLazyLoadingAuthentication] 객체, 만약 `null`인 경우 `null` 반환
     */
    fun getCurrent(): UserLazyLoadingAuthentication?
}