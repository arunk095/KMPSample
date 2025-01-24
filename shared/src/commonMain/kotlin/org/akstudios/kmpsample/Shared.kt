package org.akstudios.kmpsample

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.akstudios.kmpsample.domain.model.UserItem
import org.akstudios.kmpsample.domain.usecase.GetUserListUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Arun Kumar on 23/01/25.
 */
class SharedLogic : KoinComponent {
    private val getUsersUseCase: GetUserListUseCase by inject()
    private val scope = MainScope()

    fun fetchUsers(callback: (List<UserItem>) -> Unit) {
        scope.launch {
            getUsersUseCase.execute().collect { users ->
                callback(users.data ?: emptyList())
            }
        }
    }
}