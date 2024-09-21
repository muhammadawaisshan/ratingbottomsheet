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
    private val onSubmitClicked: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit = { _, _ -> },
    private var onRatingChangeListener: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit = { _, _ -> }
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
    private var backgroundColor: Int? = null
    private var titleTextColor: Int? = null
    private var descriptionTextColor: Int? = null
    private var filledIcon: Int? = null
    private var unfilledIcon: Int? = null
    private var titleText: String? = null
    private var descriptionTextString: String? = null
    private var confirmButtonTextString: String? = null
    private var confirmButtonTextColor: Int? = null
    private var confirmButtonBackgroundColor: Int? = null
    private var innerCardTextColorUnselected: Int? = null
    private var innerCardTextColorSelected: Int? = null
    private var innerCardBackgroundColorUnselected: Int? = null
    private var innerCardBackgroundColorSelected: Int? = null
    private var crossIcon: Int? = null

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
            backgroundColor?.let {
                materialCardView15.setCardBackgroundColor(it)
            }
            crossIcon?.let {
                closeBtn.setImageResource(it)
            }
            titleTextColor?.let {
                titleTextView.setTextColor(ContextCompat.getColor(requireContext(), it))
            }

            descriptionTextColor?.let {
                descriptionText.setTextColor(ContextCompat.getColor(requireContext(), it))
            }
            filledIcon?.let {
                simpleRatingBar.setFilledDrawableRes(it)

            }
            unfilledIcon?.let {
                simpleRatingBar.setEmptyDrawableRes(it)

            }
            titleText?.let {
                binding.titleTextView.text = it

            }
            descriptionTextString?.let {
                binding.descriptionText.text = it
            }
            confirmButtonTextString?.let {
                binding.confirmButtonText.text = it
            }
            confirmButtonTextColor?.let {
                binding.confirmButtonText.setTextColor(ContextCompat.getColor(requireContext(), it))
            }
            confirmButtonBackgroundColor?.let {
                binding.submit.setCardBackgroundColor(it)
            }

            setupCardViews()
            closeBtn.setOnClickListener {
                dismiss()
            }
            simpleRatingBar.setOnRatingChangeListener { _, rating, fromUser ->
                onRatingChangeListener.invoke(
                    rating.toInt(), this@RatingBottomSheetFragment
                )
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
                                ratingFiveEmoji

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
                innerCardBackgroundColorSelected?.let {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(), it
                        )
                    )
                } ?: run {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(), R.color.selectedCardRatingSheet
                        )
                    )

                }
                innerCardTextColorSelected?.let {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), it))
                } ?: run {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                }
            } else {
                innerCardBackgroundColorUnselected?.let {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(), it
                        )
                    )
                } ?: run {
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            requireContext(), android.R.color.transparent
                        )
                    )
                }
                innerCardTextColorUnselected?.let {
                    textView.setTextColor(ContextCompat.getColor(requireContext(), it))
                } ?: run {
                    textView.setTextColor(
                        ContextCompat.getColor(
                            requireContext(), R.color.textInner
                        )
                    )
                }
            }
        }
    }

    private fun setInnerCardTextColorUnselected(color: Int) {
        binding.apply {
            tv1.setTextColor(ContextCompat.getColor(requireContext(), color))
            tv3.setTextColor(ContextCompat.getColor(requireContext(), color))
            tv2.setTextColor(ContextCompat.getColor(requireContext(), color))
            tv4.setTextColor(ContextCompat.getColor(requireContext(), color))
            tv5.setTextColor(ContextCompat.getColor(requireContext(), color))
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
        this.backgroundColor = color
    }

    fun setUnselectedColorInnerCards(color: Int) {
        this.innerCardTextColorUnselected = color
    }

    fun setSelectedColorInnerCards(color: Int) {
        this.innerCardTextColorSelected = color
    }

    fun setTitleTextColor(color: Int) {
        this.titleTextColor = color

    }

    fun setCancelIcon(resId: Int) {
        this.crossIcon = resId

    }

    fun setDescriptionTextColor(color: Int) {
        this.descriptionTextColor = color
    }
    fun setInnerCardBackgroundColorUnselected(color: Int) {
        this.innerCardBackgroundColorUnselected = color
    }
    fun setInnerCardBackgroundColorSelected(color: Int) {
        this.innerCardBackgroundColorSelected = color
    }

    fun setFilledIcon(resId: Int) {
        this.filledIcon = resId

    }

    fun setUnfilledIcon(resId: Int) {
        this.unfilledIcon = resId
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

    fun setTitleText(text: String) {
        this.titleText = text
    }

    fun setDescriptionText(text: String) {
        this.descriptionTextString = text

    }

    fun setConfirmButtonText(text: String) {
        this.confirmButtonTextString = text
    }

    fun setConfirmButtonTextColor(color: Int) {
        this.confirmButtonTextColor = color
    }

    fun setConfirmButtonBackgroundColor(color: Int) {
        this.confirmButtonBackgroundColor = color
    }

    override fun onResume() {
        super.onResume()
        innerCardTextColorUnselected?.let {
            setInnerCardTextColorUnselected(it)
        }
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
