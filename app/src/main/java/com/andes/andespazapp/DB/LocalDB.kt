package com.andes.andespazapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.Model.Person

@Database(entities = [BlogItem::class, Person::class], version = 5)
abstract class LocalDB : RoomDatabase() {
    abstract fun blogItems():BlogItemDAO
    abstract fun persons():PersonDAO

    companion object{
        @Volatile
        private var INSTANCE: LocalDB? = null

        fun getDatabase(context: Context):LocalDB{
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDB::class.java,
                    "App"
                ).build()
                INSTANCE = instance

                return instance
            }

        }
    }
}