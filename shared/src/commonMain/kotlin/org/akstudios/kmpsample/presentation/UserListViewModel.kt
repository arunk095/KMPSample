package org.akstudios.kmpsample.presentation

import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.akstudios.kmpsample.domain.model.UserItem
import org.akstudios.kmpsample.domain.usecase.GetUserListUseCase
import org.akstudios.kmpsample.util.Resource

/**
 * Created by Arun Kumar on 23/01/25.
 */
class UserListViewModel(
    private val getUserListUseCase: GetUserListUseCase
): ViewModel() {

    private val _userList = MutableStateFlow<List<UserItem>>(emptyList())
    val userList = _userList.asStateFlow()

    fun getUserList() {
        CoroutineScope(Dispatchers.IO).launch {
            getUserListUseCase.execute().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _userList.value = result.data ?: emptyList()
                    }

                    is Resource.Error -> {

                    }

                    is Resource.Loading -> {

                    }
                }
            }
        }
    }

}