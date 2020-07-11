package com.example.quizapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    companion object{
        val DATABASE_NAME = "quiz.db"
        val TABLE_NAME = "questions"
        val QUESTION_ID = "ID"
        val QUESTION = "QUESTION"
        val ANSWERA = "ANSWERA"
        val ANSWERB = "ANSWERB"
        val ANSWERC = "ANSWERC"
        val ANSWERD = "ANSWERD"
        val CORRECTANSWER = "CORRECTANSWER"
        val DIFFICULTY = "DIFFICULTY"
    }

   /* val frageTabelle = ("CREATE TABLE " +
            TABLE_NAME + "(" +
            QUESTION_ID + " INTEGER PRIMARY KEY," +
            ANSWERA + " TEXT," +
            ANSWERB + " TEXT," +
            ANSWERC + " TEXT," +
            ANSWERD + " TEXT," +
            CORRECTANSWER + " TEXT," +
            DIFFICULTY + " TEXT," + ")")*/

            //+( id INTEGER PRIMARY KEY AUTOINCREMENT, answera TEXT, answerb TEXT, answerc TEXT, answerd TEXT, correctanswer TEXT, difficulty TEXT)")

    override fun onCreate(db: SQLiteDatabase){
        val frageTabelle = ("CREATE TABLE " +
                TABLE_NAME + "(" +
                QUESTION_ID + " INTEGER PRIMARY KEY," +
                ANSWERA + " TEXT," +
                ANSWERB + " TEXT," +
                ANSWERC + " TEXT," +
                ANSWERD + " TEXT," +
                CORRECTANSWER + " TEXT," +
                DIFFICULTY + " TEXT," + ")")
        db.execSQL(frageTabelle)
        //db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        //db.execSQL("CREATE TABLE haar (braun text);")
        //db.execSQL("CREATE TABLE TABLE_NAME(QUESTION_ID INTEGER PRIMARY KEY AUTOINCREMENT,QUESTION TEXT, ANSWERA TEXT," +
         //       "ANSWERB TEXT,ANSWERC TEXT,ANSWERD TEXT,CORRECTANSWER TEXT,DIFFICULTY TEXT);")
        Log.i("test","Tabelle neu angelegt")
     //   fillQuestionsTable()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
        Log.i("test", "Tabelle gelöscht und neu angelegt")
    }

    private fun fillQuestionsTable(){
        insertDATA("Mit welcher Funktion startet jedes Programm?", "func(...)","first(...)","main(...)","function(...)","main(...)","1");
        insertDATA("Was ünterstützt eine IDE nicht ?","Das bieten einer Codevervollständigung","Syntax-Fehler werden angezeigt","Semantik-Fehler werden angezeigt","schrittweise Durchlaufen des Programmcodes","Semantik-Fehler werden angezeigt","1")
    }

    private fun insertDATA(question:String, answera:String, answerb:String, answerc:String, answerd:String, correctanswer:String, difficulty:String){
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

    fun updateDATA(id:String, question:String, answera:String, answerb:String, answerc:String, answerd:String, correctanswer:String, difficulty:String){
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