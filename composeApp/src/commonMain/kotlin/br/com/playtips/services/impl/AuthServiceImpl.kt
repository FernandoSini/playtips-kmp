package br.com.playtips.services.impl

import br.com.playtips.models.ErrorResponse
import br.com.playtips.services.AuthService

open class AuthServiceImpl :AuthService {
    override suspend fun fetchUserData(body: Map<String, String>?): Result<Any>? {
        var data = super.fetchUserData(body)
        return when (data) {
            is Set<*> -> return Result.success<Set<*>>(data.toSet() as Set<*>)
            is ErrorResponse -> return Result.failure<ErrorResponse>(Exception("${data.error.description}"))
            else -> return Result.failure(Exception("Conversion error, invalid json"))
        }
    }
    override suspend fun login(body: Map<String, String>?): Result<Any>? {
        var data = super.login(body)
        return when (data) {
            is Set<*> -> return Result.success<Set<*>>(data.toSet() as Set<*>)
            is ErrorResponse -> return Result.failure<ErrorResponse>(Exception("${data.error.description}"))
            else -> return Result.failure(Exception("Conversion error, invalid json"))
        }
    }
}