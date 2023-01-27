package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {


    private var mCurrentPosition:Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_1.setOnClickListener(this)
        tv_option_2.setOnClickListener(this)
        tv_option_3.setOnClickListener(this)
        tv_option_4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "Terminer le quiz"
        }
        else{
            btn_submit.text = "Prochaine question"
        }


        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progressBar.max

        tv_question_id.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_1.text = question.optionUn
        tv_option_2.text = question.optionDeux
        tv_option_3.text = question.optionTrois
        tv_option_4.text = question.optionQuatre

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_1)
        options.add(1, tv_option_2)
        options.add(2, tv_option_3)
        options.add(3, tv_option_4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_borfer_bg
            )

        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_1 ->{
                selectedOptionView(tv_option_1,1 )
            }
            R.id.tv_option_2 ->{
                selectedOptionView(tv_option_2, 2)
            }
            R.id.tv_option_3 ->{
                selectedOptionView(tv_option_3, 3)
            }
            R.id.tv_option_4 ->{
                selectedOptionView(tv_option_4, 4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            Toast.makeText(this, "Felicitations !", Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.bonneReponse != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.incorrect_option_borfer_bg)
                    }
                    answerView(question.bonneReponse, R.drawable.correct_option_borfer_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text = "Terminer le quiz"
                    }else{
                        btn_submit.text = "Prochaine question"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1->{
                tv_option_1.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2->{
                tv_option_2.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3->{
                tv_option_3.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4->{
                tv_option_4.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum


        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_borfer_bg
        )
    }
}