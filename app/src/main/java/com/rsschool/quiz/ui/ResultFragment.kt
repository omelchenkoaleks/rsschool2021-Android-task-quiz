package com.rsschool.quiz.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R
import com.rsschool.quiz.data.result
import com.rsschool.quiz.databinding.FragmentResultBinding
import com.rsschool.quiz.utility.*
import kotlin.system.exitProcess

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        APP_ACTIVITY.updateStatusBarColor("#cb9b8c")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareBtn.setOnClickListener {
            val message = generateText()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(intent)
        }

        binding.arrowBackBtn.setOnClickListener {
            AppPreference.clearSharedPref()
            result = 0
            APP_ACTIVITY.navController.navigate(R.id.action_resultFragment_to_questionOneFragment)
        }

        binding.closeBtn.setOnClickListener {
            exitProcess(0)
        }
    }

    override fun onStart() {
        super.onStart()
        showResult()
    }

    private fun generateText(): String {
        return getString(R.string.your_result) + " $result " + getString(R.string.from) +
                "\n\n" + "1) " + getString(R.string.question_one) + "\n" +
                getString(R.string.your_answer) + " " + getAnswerUser(
            1,
            AppPreference.loadChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX)
        ) +
                "\n\n" + "2) " + getString(R.string.question_two) + "\n" +
                getString(R.string.your_answer) + " " + getAnswerUser(
            2,
            AppPreference.loadChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX)
        ) +
                "\n\n" + "3) " + getString(R.string.question_three) + "\n" +
                getString(R.string.your_answer) + " " + getAnswerUser(
            3,
            AppPreference.loadChoiceQuestionPref(KEY_THREE_RADIOBUTTON_INDEX)
        ) +
                "\n\n" + "4) " + getString(R.string.question_four) + "\n" +
                getString(R.string.your_answer) + " " + getAnswerUser(
            4,
            AppPreference.loadChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX)
        ) +
                "\n\n" + "5) " + getString(R.string.question_five) + "\n" +
                getString(R.string.your_answer) + " " + getAnswerUser(
            5,
            AppPreference.loadChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX)
        )
    }

    @SuppressLint("SetTextI18n")
    fun showResult() {
        binding.resultTv.text =
            getString(R.string.your_result) + " $result " + getString(R.string.from)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}