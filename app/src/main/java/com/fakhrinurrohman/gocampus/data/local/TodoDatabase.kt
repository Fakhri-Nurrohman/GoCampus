package com.fakhrinurrohman.gocampus.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fakhrinurrohman.gocampus.domain.model.Todo


@Database(entities = [Todo::class], version = 1, exportSchema = true)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}
