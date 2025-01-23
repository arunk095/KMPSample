package org.akstudios.kmpsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import org.akstudios.kmpsample.presentation.UserListViewModel
import org.akstudios.kmpsample.ui.MainScreenUI
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Arun Kumar on 23/01/25.
 */
class MainScreenActivity : ComponentActivity() {

    private val viewModel: UserListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userList = viewModel.userList.collectAsState().value
            MainScreenUI(userList)
        }
        viewModel.getUserList()
    }
}