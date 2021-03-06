package com.joshuacerdenia.android.nicefeed.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.joshuacerdenia.android.nicefeed.data.local.database.dao.CombinedDao
import com.joshuacerdenia.android.nicefeed.data.model.entry.Entry
import com.joshuacerdenia.android.nicefeed.data.model.feed.Feed
import com.joshuacerdenia.android.nicefeed.data.model.cross.FeedEntryCrossRef

@Database(
    entities = [
        Feed::class,
        Entry::class,
        FeedEntryCrossRef::class
    ],
    version = 1
)
@TypeConverters(DateConverters::class)
abstract class NiceFeedDatabase : RoomDatabase() {

    abstract fun combinedDao(): CombinedDao

    companion object {

        private const val NAME = "database"

        fun build(context: Context): NiceFeedDatabase {
            return Room
                .databaseBuilder(context, NiceFeedDatabase::class.java, NAME)
                .build()
        }
    }
}