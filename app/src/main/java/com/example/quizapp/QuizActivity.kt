package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.quiz_activity.*

class QuizActivity : AppCompatActivity() {
    var quest : String = ""
    var answera : String = ""
    var answerb : String = ""
    var answerc : String = ""
    var answerd : String = ""
    var correctanswer : String = ""

   // val dbhelper = DataBaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        val dbhelper = DataBaseHelper(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_activity)

//        print(dbhelper.showData)
    }

    fun showDialog(title:String, Message:String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clear(){
        QuestionTextView.setText("")
        AnswerABtn.setText("")
        AnswerBBtn.setText("")
        AnswerCBtn.setText("")
        AnswerDBtn.setText("")
    }
}