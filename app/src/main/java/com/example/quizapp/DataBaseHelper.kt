package com.example.quizapp

import android.content.Context

import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object{
        val DATABASE_NAME = "quiz.db"
        val TABLE_NAME = "question_table"
        val QUESTION = "QUESTION"
        val ANSWERA = "ANSWERA"
        val ANSWERB = "ANSWERB"
        val ANSWERC = "ANSWERC"
        val ANSWERD = "ANSWERD"
        val CORRECTANSWER = "CORRECTANSWER"
        val DIFFICULTY = "DIFFICULTY"
    }

    override fun onCreate(SQLiteDatabase){
        db.execSQL("CREATE TABLE $TABLE_NAME")
    }
}