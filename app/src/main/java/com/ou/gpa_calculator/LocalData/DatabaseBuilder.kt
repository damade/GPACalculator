package com.ou.gpa_calculator.LocalData

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.Util.ioThread
import java.util.*

object DatabaseBuilder {

    val PREPOPULATE_DATA = listOf(User("u/17/cs/0123", "okafor", "Student", Date()),
                                  User("u/17/cs/0205", "williams","Student", Date()),
                                  User("u/17/cs/0011", "olashina","Student", Date()),
                                  User("u/17/cs/0187", "adewale","Student", Date()),
                                  User("u/17/cs/0056", "adisa","Student", Date()),
                                  User("u/17/cs/0131", "stone","Student", Date()),
                                  User("u/17/cs/0067", "martins","Student", Date()),
                                  User("u/17/cs/0126", "steven","Student", Date()),
                                  User("Oluwatobi", "ayilara","Lecturer", Date()),
                                  User("PrinceWill", "akpojotor","Lecturer", Date()))

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "ou-cgpa-calculator"
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    // insert the data on the IO Thread
                     ioThread {
                        getInstance(context).userDao().insertAllUsers(PREPOPULATE_DATA)
                    }
                }
            }
            )
            .build()
}
