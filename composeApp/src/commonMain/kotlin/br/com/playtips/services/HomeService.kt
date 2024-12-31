package br.com.playtips.services

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException


interface HomeService : RequestsService {
    open suspend fun fetchData(url: String): Any? {


        return try {

            return null;
        } catch (e: RedirectResponseException) {

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

    open suspend fun postData(url: String, body: Map<String, String>?): Any? {
        return try {

            return null;
        } catch (e: RedirectResponseException) {

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