package org.akstudios.kmpsample.domain.model

import kotlinx.serialization.Serializable

/**
 * Created by Arun Kumar on 23/01/25.
 */
@Serializable
data class UserItem(
    val id: Int = 0,
    val name: String = "",
    val email: String = "",
    val avatar: String = "",
    val role: String = ""
)