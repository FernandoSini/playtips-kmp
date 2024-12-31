package br.com.playtips.services

import br.com.playtips.ktor.KtorClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.headers
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

interface RequestsService {

    suspend fun get(url:String):HttpResponse{

        val response = KtorClient.httpClient.get(url){
            headers{
                append("x-custom-header", "value")
            }
            contentType(ContentType.Application.Json)
        }
        return response
    }

    suspend fun post(url:String, body:Map<String,String>?):HttpResponse{
        val response = KtorClient.httpClient.post(url){
            if(!body.isNullOrEmpty()){
                setBody(Json.encodeToString(body))
            }
            headers{
                append("x-custom-header", "value")
            }
            contentType(ContentType.Application.Json)
        }
        return response
    }
}