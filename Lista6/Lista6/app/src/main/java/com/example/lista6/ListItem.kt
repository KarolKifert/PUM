package com.example.lista6

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lista6.model.User

@Composable
fun ListItem(
    user: User,
    onItemClick: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .clickable { onItemClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "${user.first_name} ${user.last_name}",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Username: ${user.username}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Email: ${user.email}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "id: ${user.id}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = null)
        }
    }
}
