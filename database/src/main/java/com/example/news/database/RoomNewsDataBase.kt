package com.example.news.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.news.database.dao.ArticleDao
import com.example.news.database.models.ArticleDBO
import com.example.news.database.utils.Converters

class NewsDataBase internal constructor(private val dataBase: RoomNewsDataBase) {
    val articleDao: ArticleDao
        get() = dataBase.articleDao()
}

@Database(entities = [ArticleDBO::class], version = 1)
@TypeConverters(Converters::class)
internal abstract class RoomNewsDataBase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}

fun newsDatabase(applicationContext: Context): NewsDataBase {
    val roomNewsDataBase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        RoomNewsDataBase::class.java, "news"
    ).build()
    return NewsDataBase(roomNewsDataBase)
}
