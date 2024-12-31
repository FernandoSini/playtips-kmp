package br.com.playtips

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform