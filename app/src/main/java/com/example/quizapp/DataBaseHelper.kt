package com.example.quizapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object{
        val DATABASE_NAME = "quiz.db"
        val TABLE_NAME = "question_table"
        val QUESTION_ID = "ID"
        val QUESTION = "QUESTION"
        val ANSWERA = "ANSWERA"
        val ANSWERB = "ANSWERB"
        val ANSWERC = "ANSWERC"
        val ANSWERD = "ANSWERD"
        val CORRECTANSWER = "CORRECTANSWER"
        val DIFFICULTY = "DIFFICULTY"
    }

    override fun onCreate(db: SQLiteDatabase){
        db.execSQL("CREATE TABLE $TABLE_NAME(ID INTEGER PRIMARY KEY "+"AUTOINCREMENT,QUESTION TEXT, ANSWERA TEXT," +
                "ANSWERB TEXT,ANSWERC TEXT,ANSWERD TEXT,CORRECTANSWER TEXT,DIFFICULTY INTEGER,)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME)
    }

    fun insertDATA(question:String, answera:String, answerb:String, answerc:String, answerd:String, correctanswer:String, difficulty:Int){
        val db = this.writableDatabase
        val contentvalues = ContentValues()
        contentvalues.put(QUESTION,question)
        contentvalues.put(ANSWERA,answera)
        contentvalues.put(ANSWERB,answerb)
        contentvalues.put(ANSWERC,answerc)
        contentvalues.put(ANSWERD,answerd)
        contentvalues.put(CORRECTANSWER,correctanswer)
        contentvalues.put(DIFFICULTY,difficulty)
        db.insert(TABLE_NAME, null, contentvalues)
    }

    fun updateDATA(id:String, question:String, answera:String, answerb:String, answerc:String, answerd:String, correctanswer:String, difficulty:Int){
        val db = this.writableDatabase
        val contentvalues = ContentValues()
        contentvalues.put(QUESTION_ID,id)
        contentvalues.put(QUESTION,question)
        contentvalues.put(ANSWERA,answera)
        contentvalues.put(ANSWERB,answerb)
        contentvalues.put(ANSWERC,answerc)
        contentvalues.put(ANSWERD,answerd)
        contentvalues.put(CORRECTANSWER,correctanswer)
        contentvalues.put(DIFFICULTY,difficulty)
        db.update(TABLE_NAME, contentvalues, "QUESTION_ID=?", arrayOf(id))
    }

    fun deleteDATA(id:String):Int{
        val db=this.writableDatabase
        return db.delete(TABLE_NAME, "ID=?", arrayOf(id))
    }

    val showData:Cursor
    get(){
        val db=this.writableDatabase
        val result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
        return result
    }
}