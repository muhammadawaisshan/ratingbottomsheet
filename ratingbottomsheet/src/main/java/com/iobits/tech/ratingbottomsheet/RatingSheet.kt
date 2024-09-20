package com.iobits.tech.ratingbottomsheet

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * A builder class for creating and displaying a customizable Rating Bottom Sheet.
 * This class allows you to set various properties such as background color, text color,
 * and icon resources before displaying the bottom sheet to the user.
 */
object RatingBottomSheetBuilder {
    private var backgroundColor: Int? = null
    private var textColor: Int? = null
    private var filledIcon: Int? = null
    private var unfilledIcon: Int? = null
    private var ratingOneEmoji: Int? = null
    private var ratingTwoEmoji: Int? = null
    private var ratingThreeEmoji: Int? = null
    private var ratingFourEmoji: Int? = null
    private var ratingFiveEmoji: Int? = null

    /**
     * Sets the background color for the bottom sheet using a color resource ID.
     * @param color The color resource ID to be applied.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setBackgroundColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.backgroundColor = color
        return this
    }

    /**
     * Sets the text color for the labels in the bottom sheet.
     * @param color The color resource ID to be applied.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setTextColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.textColor = color
        return this
    }

    /**
     * Sets the drawable resource ID for the emoji representing a rating of 1 star.
     * @param resId The drawable resource ID to be applied for the 1-star rating.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setRatingOneEmoji(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.ratingOneEmoji = resId
        return this
    }

    /**
     * Sets the drawable resource ID for the emoji representing a rating of 2 stars.
     * @param resId The drawable resource ID to be applied for the 2-star rating.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setRatingTwoEmoji(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.ratingTwoEmoji = resId
        return this
    }

    /**
     * Sets the drawable resource ID for the emoji representing a rating of 3 stars.
     * @param resId The drawable resource ID to be applied for the 3-star rating.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setRatingThreeEmoji(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.ratingThreeEmoji = resId
        return this
    }

    /**
     * Sets the drawable resource ID for the emoji representing a rating of 4 stars.
     * @param resId The drawable resource ID to be applied for the 4-star rating.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setRatingFourEmoji(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.ratingFourEmoji = resId
        return this
    }

    /**
     * Sets the drawable resource ID for the emoji representing a rating of 5 stars.
     * @param resId The drawable resource ID to be applied for the 5-star rating.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setRatingFiveEmoji(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.ratingFiveEmoji = resId
        return this
    }

    /**
     * Sets the resource ID for the filled icon using a drawable resource ID.
     * @param resId The drawable resource ID of the filled icon to be used.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setFilledIcon(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.filledIcon = resId
        return this
    }

    /**
     * Sets the resource ID for the unfilled icon using a drawable resource ID.
     * @param resId The drawable resource ID of the unfilled icon to be used.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setUnfilledIcon(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.unfilledIcon = resId
        return this
    }

    /**
     * Displays the bottom sheet with the configured settings.
     * @param activity The activity in which the bottom sheet should be shown.
     * @param onSubmitClicked The callback to be invoked when the submit button is clicked, providing the rating and the dialog instance.
     */
    fun show(
        activity: FragmentActivity, onSubmitClicked: ((Int, BottomSheetDialogFragment) -> Unit)
    ) {
        val fragment = RatingBottomSheetFragment(onSubmitClicked)

        backgroundColor?.let {
            fragment.setBackgroundColor(it)
        }

        textColor?.let {
            fragment.setTextColor(it)
        }

        filledIcon?.let {
            fragment.setFilledIcon(it)
        }

        unfilledIcon?.let {
            fragment.setUnfilledIcon(it)
        }
        ratingOneEmoji?.let {
            fragment.setRatingOneEmoji(it)
        }
        ratingTwoEmoji?.let {
            fragment.setRatingTwoEmoji(it)
        }
        ratingThreeEmoji?.let {
            fragment.setRatingThreeEmoji(it)
        }
        ratingFourEmoji?.let {
            fragment.setRatingFourEmoji(it)
        }
        ratingFiveEmoji?.let {
            fragment.setRatingFiveEmoji(it)
        }

        fragment.openBottomSheet(activity)
    }
}

// Extension function to open a BottomSheetDialogFragment
private fun BottomSheetDialogFragment.openBottomSheet(activity: FragmentActivity?) {
    if (this.isAdded) {
        this.dismiss()
    }
    activity?.supportFragmentManager?.let { fragmentManager ->
        if (activity.lifecycle.currentState.isAtLeast(Lifecycle.State.RESUMED)) {
            this.show(fragmentManager, this.tag)
        }
    }
}