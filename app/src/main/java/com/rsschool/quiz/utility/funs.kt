package com.rsschool.quiz.utility

import android.widget.Toast
import com.rsschool.quiz.R

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_SHORT).show()
}

fun getAnswerUser(numQuestion: Int, key: Int): String {
    var answer = ""
    when (numQuestion) {
        1 -> {
            when (key) {
                1 -> {
                    answer = APP_ACTIVITY.getString(R.string.one_answer_a)
                }
                2 -> {
                    answer = APP_ACTIVITY.getString(R.string.one_answer_b)
                }
                3 -> {
                    answer = APP_ACTIVITY.getString(R.string.one_answer_c)
                }
                4 -> {
                    answer = APP_ACTIVITY.getString(R.string.one_answer_d)
                }
                5 -> {
                    answer = APP_ACTIVITY.getString(R.string.one_answer_e)
                }
            }
        }
        2 -> {
            when (key) {
                1 -> {
                    answer = APP_ACTIVITY.getString(R.string.two_answer_a)
                }
                2 -> {
                    answer = APP_ACTIVITY.getString(R.string.two_answer_b)
                }
                3 -> {
                    answer = APP_ACTIVITY.getString(R.string.two_answer_c)
                }
                4 -> {
                    answer = APP_ACTIVITY.getString(R.string.two_answer_d)
                }
                5 -> {
                    answer = APP_ACTIVITY.getString(R.string.two_answer_e)
                }
            }
        }
        3 -> {
            when (key) {
                1 -> {
                    answer = APP_ACTIVITY.getString(R.string.three_answer_e)
                }
                2 -> {
                    answer = APP_ACTIVITY.getString(R.string.three_answer_b)
                }
                3 -> {
                    answer = APP_ACTIVITY.getString(R.string.three_answer_c)
                }
                4 -> {
                    answer = APP_ACTIVITY.getString(R.string.three_answer_d)
                }
                5 -> {
                    answer = APP_ACTIVITY.getString(R.string.three_answer_e)
                }
            }
        }
        4 -> {
            when (key) {
                1 -> {
                    answer = APP_ACTIVITY.getString(R.string.four_answer_e)
                }
                2 -> {
                    answer = APP_ACTIVITY.getString(R.string.four_answer_b)
                }
                3 -> {
                    answer = APP_ACTIVITY.getString(R.string.four_answer_c)
                }
                4 -> {
                    answer = APP_ACTIVITY.getString(R.string.four_answer_d)
                }
                5 -> {
                    answer = APP_ACTIVITY.getString(R.string.four_answer_e)
                }
            }
        }
        5 -> {
            when (key) {
                1 -> {
                    answer = APP_ACTIVITY.getString(R.string.five_answer_a)
                }
                2 -> {
                    answer = APP_ACTIVITY.getString(R.string.five_answer_b)
                }
                3 -> {
                    answer = APP_ACTIVITY.getString(R.string.five_answer_c)
                }
                4 -> {
                    answer = APP_ACTIVITY.getString(R.string.five_answer_d)
                }
                5 -> {
                    answer = APP_ACTIVITY.getString(R.string.five_answer_e)
                }
            }
        }
    }
    return answer
}
