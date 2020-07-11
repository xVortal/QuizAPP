package com.example.quizapp

class QuestionContract {
    var question : String = "";
    var answerA : String = "";
    var answerB : String = "";
    var answerC : String = "";
    var answerD : String = "";
    var correctAnswer : String = "";
    var difficulty : Int = 0;

    constructor(
        question: String,
        answerA: String,
        answerB: String,
        answerC: String,
        answerD: String,
        correctAnswer: String,
        difficulty: Int
    ) {
        this.question = question
        this.answerA = answerA
        this.answerB = answerB
        this.answerC = answerC
        this.answerD = answerD
        this.correctAnswer = correctAnswer
        this.difficulty = difficulty
    }


}