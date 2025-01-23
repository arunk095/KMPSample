package org.akstudios.kmpsample.domain.repository

import kotlinx.coroutines.flow.Flow
import org.akstudios.kmpsample.domain.model.UserItem
import org.akstudios.kmpsample.util.Resource

/**
 * Created by Arun Kumar on 23/01/25.
 */
interface UserRepository {

    suspend fun getUserItems(): Flow<Resource<List<UserItem>>>

}