package org.akstudios.kmpsample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform