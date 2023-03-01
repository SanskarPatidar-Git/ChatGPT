package com.chatgpt.android.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.chatgpt.android.AppConstants;
import com.chatgpt.android.ChatModel;

@Database(entities = {ChatModel.class},exportSchema = false,version = AppConstants.Database.ROOM_VERSION)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {

    public static RoomDatabase databaseReference;
    public static synchronized RoomDatabase getDatabaseReference(Context context){
        if(databaseReference==null){
            databaseReference = Room.databaseBuilder(context,RoomDatabase.class,AppConstants.Database.ROOM_DATABASE_FILE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return databaseReference;
    }
    public abstract DAO dao();
}
