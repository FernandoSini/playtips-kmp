package br.com.playtips.services

import br.com.playtips.routes.HttpRoutes
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.serialization.json.Json

interface AuthService:RequestsService {
    open suspend fun fetchUserData(body: Map<String,String>?):Any?{
        return try {
            if(body.isNullOrEmpty()){
             val url = HttpRoutes.DEFAULT_URL + "auth/login"
                var response = post(url,null)
                if(response.status.value >= 200 && response.status.value <= 299){
                    return Json.decodeFromString(response.body())
                }else{
                    return Json.decodeFromString(response.body())
                }
            }else{
                val url = HttpRoutes.DEFAULT_URL + "auth/login"
                var response = post(url,body)
                if(response.status.value >= 200 && response.status.value <= 299){
                    return Json.decodeFromString(response.body())
            }else{
                    return Json.decodeFromString(response.body())
                }
            }

        }   catch (e: RedirectResponseException) {
            return e.response
        } catch (e: ClientRequestException) {
            return e.response
        } catch (e: ServerResponseException) {
            print("server response: ${e.message} +${e.response.status}")
            return e.response
        } catch (e: Exception) {
            println("Error Exception: ${e.message}")
            //   throw e
            return e
        }
    }
    open suspend fun login(body: Map<String,String>?):Any?{
        return try {
            if(body.isNullOrEmpty()){
             val url = HttpRoutes.DEFAULT_URL + "auth/login"
                var response = post(url,null)
                if(response.status.value >= 200 && response.status.value <= 299){
                    return Json.decodeFromString(response.body())
                }else{
                    return Json.decodeFromString(response.body())
                }
            }else{
                val url = HttpRoutes.DEFAULT_URL + "auth/login"
                var response = post(url,body)
                if(response.status.value >= 200 && response.status.value <= 299){
                    return Json.decodeFromString(response.body())
            }else{
                    return Json.decodeFromString(response.body())
                }
            }

        }   catch (e: RedirectResponseException) {
            return e.response
        } catch (e: ClientRequestException) {
            return e.response
        } catch (e: ServerResponseException) {
            print("server response: ${e.message} +${e.response.status}")
            return e.response
        } catch (e: Exception) {
            println("Error Exception: ${e.message}")
            //   throw e
            return e
        }
    }
}