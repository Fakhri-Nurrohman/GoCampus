package com.fakhrinurrohman.gocampus.presentation.update_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakhrinurrohman.gocampus.presentation.MainViewModel
import com.fakhrinurrohman.gocampus.presentation.common.taskTextStyle
import com.fakhrinurrohman.gocampus.presentation.common.topAppBarTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateScreen(
    id: Int,
    mainViewModel: MainViewModel,
    onBack: () -> Unit,
) {
//    var task by remember { mutableStateOf("") }
//    var isImportant by remember { mutableStateOf(false) }

    val task = mainViewModel.todo.task
    val isImportant = mainViewModel.todo.isImportant

    LaunchedEffect(key1 = true, block = {
        mainViewModel.getTodoById(id = id)
//        Assuming 'mainViewModel.todo' is now populated
//        task = mainViewModel.todo.task
//        isImportant = mainViewModel.todo.isImportant

    })

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Update Todo",
                style = topAppBarTextStyle,
            )
        }, navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = null
                )
            }
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.size(16.dp))

            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = task,
                onValueChange = {
                    mainViewModel.updateTask(newValue = task)
                },
                modifier = Modifier
                    .fillMaxWidth(.9f),
                label = {
                    Text(
                        text = "Task",
                        fontFamily = FontFamily.Monospace
                    )
                },
                shape = RectangleShape,
                keyboardOptions = KeyboardOptions(
                    KeyboardCapitalization.Sentences,
                ),
                textStyle = taskTextStyle
            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Important",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 18.sp,
                )

                Spacer(modifier = Modifier.size(8.dp))

                Checkbox(checked = isImportant, onCheckedChange = {
                    mainViewModel.updateIsImportant(newValue = isImportant)
                })
            }

            Spacer(modifier = Modifier.size(8.dp))
            Button(onClick = {
                mainViewModel.updateTodo(mainViewModel.todo)
                onBack()
            }) {
                Text(
                    text = "Save Task",
                    fontSize = 16.sp,
                )
            }
        }
    }
}