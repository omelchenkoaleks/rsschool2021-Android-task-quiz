package com.rsschool.quiz.ui.questions

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.rsschool.quiz.MainActivity
import com.rsschool.quiz.R
import com.rsschool.quiz.data.result
import com.rsschool.quiz.data.tryAgainOne
import com.rsschool.quiz.databinding.FragmentQuestionOneBinding
import com.rsschool.quiz.utility.APP_ACTIVITY
import com.rsschool.quiz.utility.AppPreference
import com.rsschool.quiz.utility.KEY_ONE_RADIOBUTTON_INDEX
import com.rsschool.quiz.utility.showToast

class QuestionOneFragment : Fragment() {

    private var _binding: FragmentQuestionOneBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color.parseColor("#cb9b8c")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.radioGroup.setOnCheckedChangeListener { _, checkId ->
            binding.nextButton.isEnabled = true
            when (checkId) {
                binding.optionOne.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX, 1)
                    if (tryAgainOne) {
                        result--
                        tryAgainOne = false
                    }
                }
                binding.optionTwo.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX, 2)
                    if (!tryAgainOne) { // right answer
                        result++
                        tryAgainOne = true
                    }
                }
                binding.optionThree.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX, 3)
                    if (tryAgainOne) {
                        result--
                        tryAgainOne = false
                    }
                }
                binding.optionFour.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX, 4)
                    if (tryAgainOne) {
                        result--
                        tryAgainOne = false
                    }
                }
                binding.optionFive.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX, 5)
                    if (tryAgainOne) {
                        result--
                        tryAgainOne = false
                    }
                }
            }
        }

        binding.nextButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionOneFragment_to_questionTwoFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        loadPreviousChoice()
    }

    private fun loadPreviousChoice() {
        val number = AppPreference.loadChoiceQuestionPref(KEY_ONE_RADIOBUTTON_INDEX)
        if (number != 0) {
            when (number) {
                1 -> {
                    binding.optionOne.isChecked = true
                }
                2 -> {
                    binding.optionTwo.isChecked = true
                }
                3 -> {
                    binding.optionThree.isChecked = true
                }
                4 -> {
                    binding.optionFour.isChecked = true
                }
                5 -> {
                    binding.optionFive.isChecked = true
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}