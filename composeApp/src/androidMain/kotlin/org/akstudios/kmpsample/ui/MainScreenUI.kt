package org.akstudios.kmpsample.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.akstudios.kmpsample.domain.model.UserItem

/**
 * Created by Arun Kumar on 23/01/25.
 */
@Composable
fun MainScreenUI(userList: List<UserItem>) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn {
            items(userList) { item ->
                UserListItem(
                    item = item,
                    onClick = {
                        //    onItemClick(item)
                    }
                )
            }
        }
    }
}

@Composable
fun UserListItem(
    item: UserItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            /*Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = item.header,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
            )*/
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Name: ${item.name}"
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Email: ${item.email}",
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Role: ${item.role}"
                )
            }
        }
    }
}

