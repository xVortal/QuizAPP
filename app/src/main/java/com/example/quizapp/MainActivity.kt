package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

   // internal var dbhelper = DataBaseHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testModusBtn = findViewById<Button>(R.id.Testmodusbtn)
        testModusBtn.setOnClickListener{
            val intent = Intent(this, WissenLevelAcitivity::class.java)
            startActivity(intent)
        }

        val lernModusBtn = findViewById<Button>(R.id.Lernmodusbtn)
        lernModusBtn.setOnClickListener{
            val intent = Intent(this, WissenLevelAcitivity::class.java)
            startActivity(intent)
        }
    }

   /* fun  showDialog(title:String, Message:String){
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun clear(){
        question_id.setText("")
        question.setText("")
        answera.setText("")
        answerb.setText("")
        answerc.setText("")
        answerd.setText("")
        correctanswer.setText("")
        difficulty.setText("")
    }

    fun insert(){
        Testmodusbtn.setOnClickListener(
            try {
                dbhelper.insertDATA(question.text.toString(), answera.text.toString(), answerb.text.toString(),
                    answerc.text.toString(), answerd.text.toString(), correctanswer.text.toString(), difficulty.text.toString())
                clear()
            }
            catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG.).show()
            }
        )
    }
    fun update(){

    }*/
}
