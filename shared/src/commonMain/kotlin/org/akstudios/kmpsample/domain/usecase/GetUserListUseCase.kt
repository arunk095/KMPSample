package org.akstudios.kmpsample.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.akstudios.kmpsample.domain.model.UserItem
import org.akstudios.kmpsample.domain.repository.UserRepository
import org.akstudios.kmpsample.util.Resource

/**
 * Created by Arun Kumar on 23/01/25.
 */

class GetUserListUseCase(private val repository: UserRepository) {
    suspend fun execute(): Flow<Resource<List<UserItem>>> = repository.getUserItems()
}