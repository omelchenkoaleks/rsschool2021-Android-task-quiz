package com.rsschool.quiz.ui.questions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R
import com.rsschool.quiz.data.result
import com.rsschool.quiz.data.tryAgainTwo
import com.rsschool.quiz.databinding.FragmentQuestionTwoBinding
import com.rsschool.quiz.utility.APP_ACTIVITY
import com.rsschool.quiz.utility.AppPreference
import com.rsschool.quiz.utility.KEY_TWO_RADIOBUTTON_INDEX

class QuestionTwoFragment : Fragment() {

    private var _binding: FragmentQuestionTwoBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        APP_ACTIVITY.updateStatusBarColor("#cbc693")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, checkId ->
            binding.nextButton.isEnabled = true
            when (checkId) {
                binding.optionOne.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX, 1)
                    if (tryAgainTwo) {
                        result--
                        tryAgainTwo = false
                    }
                }
                binding.optionTwo.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX, 2)
                    if (tryAgainTwo) {
                        result--
                        tryAgainTwo = false
                    }
                }
                binding.optionThree.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX, 3)
                    if (!tryAgainTwo) { // right answer
                        result++
                        tryAgainTwo = true
                    }
                }
                binding.optionFour.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX, 4)
                    if (tryAgainTwo) {
                        result--
                        tryAgainTwo = false
                    }
                }
                binding.optionFive.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX, 5)
                    if (tryAgainTwo) {
                        result--
                        tryAgainTwo = false
                    }
                }
            }
        }

        binding.previousButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionTwoFragment_to_questionOneFragment)
        }

        binding.nextButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionTwoFragment_to_questionThreeFragment)
        }

        binding.toolbar.setNavigationOnClickListener {
            APP_ACTIVITY.onBackPressed()
            APP_ACTIVITY.updateStatusBarColor("#cb9b8c")
        }
    }

    override fun onStart() {
        super.onStart()
        loadPreviousChoice()
    }

    private fun loadPreviousChoice() {
        val number = AppPreference.loadChoiceQuestionPref(KEY_TWO_RADIOBUTTON_INDEX)
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