package br.com.playtips.controllers

import br.com.playtips.services.impl.AuthServiceImpl

class AuthController(private val authServiceImpl: AuthServiceImpl) {

    suspend fun fetchUserData(body: Map<String, String>?): Any? {
        val result = authServiceImpl.fetchUserData(body)
        return result?.fold(
            onSuccess = { value -> value as Set<*> },
            onFailure = { exception: Throwable -> exception.message })
    }

    suspend fun login(body: Map<String, String>?): Any? {
        return authServiceImpl.login(body)
    }
}