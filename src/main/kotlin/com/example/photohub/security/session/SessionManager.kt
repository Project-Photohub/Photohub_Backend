package com.example.photohub.security.session

/**
 * [Session][com.example.photohub.security.session.vo.Session]을 저장하고 관리하는 주체
 *
 * @since 24-06-2024
 * @author Daybreak312
 */
interface SessionManager {

    /**
     * [username][com.example.photohub.security.session.vo.Session.username]을 통해 [Session][com.example.photohub.security.session.vo.Session] 탐색
     *
     * 만약 [Session][com.example.photohub.security.session.vo.Session]이 만료되었을 경우 해당 [Session][com.example.photohub.security.session.vo.Session] 무효화.
     *
     * @return 찾은 [Session][com.example.photohub.security.session.vo.Session]의 [username][com.example.photohub.security.session.vo.Session.username]. 만료되었거나 존재하지 않을 경우 `null`
     */
    fun getUsernameById(sessionId: String): String?

    /**
     * 새로운 [Session][com.example.photohub.security.session.vo.Session] 생성
     *
     * 이전에 해당 [username]으로 만들어진 모든 [Session][com.example.photohub.security.session.vo.Session]을 무효화.
     * 이 과정에서 다른 만료된 [Session][com.example.photohub.security.session.vo.Session]들 또한 무효화
     *
     * @return 생성된 [Session][com.example.photohub.security.session.vo.Session]의 [sessionId][com.example.photohub.security.session.vo.Session.sessionId]
     */
    fun createSession(username: String): String
}