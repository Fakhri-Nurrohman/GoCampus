package com.fakhrinurrohman.gocampus.data.repository

import com.fakhrinurrohman.gocampus.data.local.TodoDao
import com.fakhrinurrohman.gocampus.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val dao: TodoDao
) {
    suspend fun insertTodo(todo: Todo): Unit = dao.insertTodo(todo = todo)

    suspend fun updateTodo(todo: Todo): Unit = dao.updateTodo(todo = todo)

    suspend fun deleteTodo(todo: Todo): Unit = dao.deleteTodo(todo = todo)

    suspend fun getTodoById(id: Int): Todo = dao.getTodoById(id = id)

    fun getAllTodos(): Flow<List<Todo>> = dao.getAllTodos()
}