package com.rsschool.quiz.ui.questions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R
import com.rsschool.quiz.data.result
import com.rsschool.quiz.data.tryAgainFive
import com.rsschool.quiz.databinding.FragmentQuestionFiveBinding
import com.rsschool.quiz.utility.APP_ACTIVITY
import com.rsschool.quiz.utility.AppPreference
import com.rsschool.quiz.utility.KEY_FIVE_RADIOBUTTON_INDEX

class QuestionFiveFragment : Fragment() {

    private var _binding: FragmentQuestionFiveBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        APP_ACTIVITY.updateStatusBarColor("#a094b7")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionFiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, checkId ->
            binding.submit.isEnabled = true
            when (checkId) {
                binding.optionOne.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX, 1)
                    if (tryAgainFive) {
                        result--
                        tryAgainFive = false
                    }
                }
                binding.optionTwo.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX, 2)
                    if (tryAgainFive) {
                        result--
                        tryAgainFive = false
                    }
                }
                binding.optionThree.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX, 3)
                    if (tryAgainFive) {
                        result--
                        tryAgainFive = false
                    }
                }
                binding.optionFour.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX, 4)
                    if (tryAgainFive) {
                        result--
                        tryAgainFive = false
                    }
                }
                binding.optionFive.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX, 5)
                    if (!tryAgainFive) { // right answer
                        result++
                        tryAgainFive = true
                    }
                }
            }
        }

        binding.previousButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionFiveFragment_to_questionFourFragment)
        }

        binding.submit.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionFiveFragment_to_resultFragment)
        }

        binding.toolbar.setNavigationOnClickListener {
            APP_ACTIVITY.onBackPressed()
            APP_ACTIVITY.updateStatusBarColor("#81b9bf")
        }
    }

    override fun onStart() {
        super.onStart()
        val number = AppPreference.loadChoiceQuestionPref(KEY_FIVE_RADIOBUTTON_INDEX)
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