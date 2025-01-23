package org.akstudios.kmpsample.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.akstudios.kmpsample.domain.model.UserItem

/**
 * Created by Arun Kumar on 23/01/25.
 */
class KtorService(private val client: HttpClient) {

    // Base URL for your backend API
    private val baseUrl = "https://api.escuelajs.co/api/v1/users"

    suspend fun getUserItems(): List<UserItem> {
        return client.get(baseUrl).body()
    }
}