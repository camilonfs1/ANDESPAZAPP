package com.andes.andespazapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andes.andespazapp.Model.BlogItem

@Database(entities = [BlogItem::class], version = 30)
abstract class App : RoomDatabase() {
    abstract fun blogItems():BlogItemDAO

    companion object{
        @Volatile
        private var INSTANCE: App? = null

        fun getDatabase(context: Context):App{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    App::class.java,
                    "App"
                ).build()
                INSTANCE = instance

                return instance
            }

        }
    }
}