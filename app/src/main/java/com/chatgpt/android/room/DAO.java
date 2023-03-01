package com.chatgpt.android.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.chatgpt.android.ChatModel;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DAO {

    @Insert
    void insertRecord(ChatModel model);

    @Query("SELECT * FROM ChatModel")
    List<ChatModel> getRecord();
}
