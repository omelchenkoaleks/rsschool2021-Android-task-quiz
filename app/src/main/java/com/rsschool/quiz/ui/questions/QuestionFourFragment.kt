package com.rsschool.quiz.ui.questions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.R
import com.rsschool.quiz.data.result
import com.rsschool.quiz.data.tryAgainFour
import com.rsschool.quiz.databinding.FragmentQuestionFourBinding
import com.rsschool.quiz.utility.APP_ACTIVITY
import com.rsschool.quiz.utility.AppPreference
import com.rsschool.quiz.utility.KEY_FOUR_RADIOBUTTON_INDEX

class QuestionFourFragment : Fragment() {

    private var _binding: FragmentQuestionFourBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        APP_ACTIVITY.updateStatusBarColor("#81b9bf")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionFourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, checkId ->
            binding.nextButton.isEnabled = true
            when (checkId) {
                binding.optionOne.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX, 1)
                    if (tryAgainFour) {
                        result--
                        tryAgainFour = false
                    }
                }
                binding.optionTwo.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX, 2)
                    if (tryAgainFour) {
                        result--
                        tryAgainFour = false
                    }
                }
                binding.optionThree.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX, 3)
                    if (!tryAgainFour) { // right answer
                        result++
                        tryAgainFour = true
                    }
                }
                binding.optionFour.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX, 4)
                    if (tryAgainFour) {
                        result--
                        tryAgainFour = false
                    }
                }
                binding.optionFive.id -> {
                    AppPreference.saveChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX, 5)
                    if (tryAgainFour) {
                        result--
                        tryAgainFour = false
                    }
                }
            }
        }

        binding.previousButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionFourFragment_to_questionThreeFragment)
        }

        binding.nextButton.setOnClickListener {
            APP_ACTIVITY.navController.navigate(R.id.action_questionFourFragment_to_questionFiveFragment)
        }

        binding.toolbar.setNavigationOnClickListener {
            APP_ACTIVITY.onBackPressed()
            APP_ACTIVITY.updateStatusBarColor("#aabb97")
        }
    }

    override fun onStart() {
        super.onStart()
        val number = AppPreference.loadChoiceQuestionPref(KEY_FOUR_RADIOBUTTON_INDEX)
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