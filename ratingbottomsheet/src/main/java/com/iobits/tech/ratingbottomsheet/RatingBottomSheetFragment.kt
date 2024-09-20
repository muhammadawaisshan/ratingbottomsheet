package com.iobits.tech.ratingbottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.card.MaterialCardView
import com.iobits.tech.ratingbottomsheet.databinding.RatingBottomSheetBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class RatingBottomSheetFragment(
    private val onSubmitClicked: (Int, BottomSheetDialogFragment) -> Unit = { _, _ -> },

    ) : BottomSheetDialogFragment() {
    private val binding by lazy {
        RatingBottomSheetBinding.inflate(layoutInflater)
    }
    private val cardViewStates = mutableMapOf<MaterialCardView, Pair<TextView, Boolean>>()
    private var ratingOneEmoji = R.drawable.onestaremoji
    private var ratingTwoEmoji = R.drawable.twostaremoji
    private var ratingThreeEmoji = R.drawable.threestaremoji
    private var ratingFourEmoji = R.drawable.fourstaremoji
    private var ratingFiveEmoji = R.drawable.fivestaremoji

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        lifecycleScope.launch {
            binding.apply {
                delay(500)
                animateStarsToRating(5)
                emojiImage.setImageResource(ratingFiveEmoji)
            }
        }
        binding.apply {
            setupCardViews()
            closeBtn.setOnClickListener {
                dismiss()
            }
            simpleRatingBar.setOnRatingChangeListener { _, rating, fromUser ->
                if (fromUser) {
                    animateStarsToRating(rating.toInt())
                    emojiImage.setImageResource(
                        when (rating.toInt()) {
                            1 -> {
                                ratingOneEmoji
                            }

                            2 -> {
                                ratingTwoEmoji

                            }

                            3 -> {
                                ratingThreeEmoji

                            }

                            4 -> {
                                ratingFourEmoji

                            }

                            5 -> {
                                ratingFourEmoji

                            }

                            else -> {
                                ratingOneEmoji

                            }
                        }
                    )
                }
            }
            submit.setOnClickListener {
                onSubmitClicked.invoke(
                    simpleRatingBar.rating.toInt(), this@RatingBottomSheetFragment
                )

            }

        }
        return binding.root
    }

    private fun setupCardView(cardView: MaterialCardView, textView: TextView) {
        cardView.setOnClickListener {
            val isSelected = cardViewStates[cardView]?.second ?: false
            val newIsSelected = !isSelected

            cardViewStates[cardView] = textView to newIsSelected

            if (newIsSelected) {
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.selectedCardRatingSheet
                    )
                )
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            } else {
                cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(), android.R.color.transparent
                    )
                )
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.textInner))
            }
        }
    }

    private fun setupCardViews() {
        binding.apply {
            cardViewStates[materialCardView16] = tv1 to false
            cardViewStates[materialCardView17] = tv2 to false
            cardViewStates[materialCardView18] = tv4 to false
            cardViewStates[materialCardView19] = tv3 to false
            cardViewStates[materialCardView20] = tv5 to false

            setupCardView(materialCardView16, tv1)
            setupCardView(materialCardView17, tv2)
            setupCardView(materialCardView18, tv4)
            setupCardView(materialCardView19, tv3)
            setupCardView(materialCardView20, tv5)
        }
    }

    private fun animateStarsToRating(targetRating: Int) {
        lifecycleScope.launch {
            for (i in 1..targetRating) {
                binding.simpleRatingBar.rating = i.toFloat()
                delay(170)
            }
        }
    }

    fun setBackgroundColor(color: Int) {
        binding.apply {
            materialCardView15.setCardBackgroundColor(color)
        }
    }

    fun setTextColor(color: Int) {
        binding.apply {
            titleTextView.setTextColor(color)

        }
    }

    fun setFilledIcon(resId: Int) {
        binding.apply {
            simpleRatingBar.setFilledDrawableRes(resId)
        }
    }

    fun setUnfilledIcon(resId: Int) {
        binding.apply {
            simpleRatingBar.setEmptyDrawableRes(resId)
        }
    }

    fun setRatingOneEmoji(@DrawableRes resId: Int) {
        this.ratingOneEmoji = resId
    }

    fun setRatingTwoEmoji(@DrawableRes resId: Int) {
        this.ratingTwoEmoji = resId
    }

    fun setRatingThreeEmoji(@DrawableRes resId: Int) {
        this.ratingThreeEmoji = resId
    }

    fun setRatingFourEmoji(@DrawableRes resId: Int) {
        this.ratingFourEmoji = resId
    }

    fun setRatingFiveEmoji(@DrawableRes resId: Int) {
        this.ratingFiveEmoji = resId
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetLayout = binding.mainLayout
        val behavior = (dialog as BottomSheetDialog).behavior
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.isDraggable = false
        val layoutParams = bottomSheetLayout.layoutParams
        bottomSheetLayout.layoutParams = layoutParams
    }

}
