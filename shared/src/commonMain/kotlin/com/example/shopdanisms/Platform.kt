package com.example.shopdanisms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform