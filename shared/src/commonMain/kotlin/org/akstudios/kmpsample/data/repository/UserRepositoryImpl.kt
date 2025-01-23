package org.akstudios.kmpsample.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import org.akstudios.kmpsample.data.remote.KtorService
import org.akstudios.kmpsample.domain.model.UserItem
import org.akstudios.kmpsample.domain.repository.UserRepository
import org.akstudios.kmpsample.util.Resource

/**
 * Created by Arun Kumar on 23/01/25.
 */
class UserRepositoryImpl(private val ktorService: KtorService): UserRepository {

    override suspend fun getUserItems(): Flow<Resource<List<UserItem>>> = flow {
        emit(Resource.Loading())
        try {
            val response = withContext(Dispatchers.IO) { ktorService.getUserItems() }
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error("Failed to fetch inventory: ${e.message}"))
        }
    }
}