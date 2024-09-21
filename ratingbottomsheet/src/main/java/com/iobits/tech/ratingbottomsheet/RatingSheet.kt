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
    private var titleTextColor: Int? = null
    private var innerCardTextColorUnselected: Int? = null
    private var innerCardTextColorSelected: Int? = null
    private var crossIcon: Int? = null
    private var descriptionTextColor: Int? = null
    private var filledIcon: Int? = null
    private var unfilledIcon: Int? = null
    private var ratingOneEmoji: Int? = null
    private var ratingTwoEmoji: Int? = null
    private var ratingThreeEmoji: Int? = null
    private var ratingFourEmoji: Int? = null
    private var ratingFiveEmoji: Int? = null
    private var titleText: String? = null
    private var descriptionText: String? = null
    private var innerCardBackgroundColorUnselected: Int? = null
    private var innerCardBackgroundColorSelected: Int? = null
    private var confirmButtonText: String? = null
    private var confirmButtonTextColor: Int? = null
    private var confirmButtonBackgroundColor: Int? = null
    private var onRatingChangeListener: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit =
        { _, _ -> }


    /**
     * Sets a listener to be called whenever the rating changes in the rating bar.
     * @param listener A function that is called with the new rating and fragment instance when the rating changes.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setOnRatingChangeListener(listener: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit): RatingBottomSheetBuilder {
        this.onRatingChangeListener = listener
        return this
    }

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
     * Sets the background color for the inner card when it is unselected in the bottom sheet.
     * @param color The color resource ID to be applied for the unselected inner card background.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setInnerCardBackgroundColorUnselected(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.innerCardBackgroundColorUnselected = color
        return this
    }

    /**
     * Sets the background color for the inner card when it is selected in the bottom sheet.
     * @param color The color resource ID to be applied for the selected inner card background.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setInnerCardBackgroundColorSelected(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.innerCardBackgroundColorSelected = color
        return this
    }

    /**
     * Sets the text color for the labels in the bottom sheet.
     * @param color The color resource ID to be applied.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setTitleTextColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.titleTextColor = color
        return this
    }

    fun setUnselectedTextColorInnerCards(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.innerCardTextColorUnselected = color
        return this
    }

    fun setSelectedTextColorInnerCards(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.innerCardTextColorSelected = color
        return this
    }

    /**
     * Sets the drawable resource ID for the icon representing a cross (close) button in the bottom sheet.
     * @param resId The drawable resource ID to be applied for the cross icon.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setCrossIcon(@DrawableRes resId: Int): RatingBottomSheetBuilder {
        this.crossIcon = resId
        return this
    }

    /**
     * Sets the text color for the description in the bottom sheet.
     * @param color The color resource ID to be applied.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setDescriptionTextColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.descriptionTextColor = color
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
     * Sets the title text for the bottom sheet.
     * @param text The title text to be displayed.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setTitleText(text: String): RatingBottomSheetBuilder {
        this.titleText = text
        return this
    }

    /**
     * Sets the description text for the bottom sheet.
     * @param text The description text to be displayed.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setDescriptionText(text: String): RatingBottomSheetBuilder {
        this.descriptionText = text
        return this
    }

    /**
     * Sets the text for the confirm button in the bottom sheet.
     * @param text The text to be displayed on the confirm button.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setConfirmButtonText(text: String): RatingBottomSheetBuilder {
        this.confirmButtonText = text
        return this
    }

    /**
     * Sets the text color for the confirm button in the bottom sheet.
     * @param color The color resource ID to be applied to the confirm button text.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setConfirmButtonTextColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.confirmButtonTextColor = color
        return this
    }

    /**
     * Sets the background color for the confirm button in the bottom sheet.
     * @param color The color resource ID to be applied to the confirm button background.
     * @return The current instance of RatingBottomSheetBuilder for method chaining.
     */
    fun setConfirmButtonBackgroundColor(@ColorRes color: Int): RatingBottomSheetBuilder {
        this.confirmButtonBackgroundColor = color
        return this
    }

    /**
     * Displays the bottom sheet with the configured settings.
     * @param activity The activity in which the bottom sheet should be shown.
     * @param onSubmitClicked The callback to be invoked when the submit button is clicked, providing the rating and the dialog instance.
     */
    fun show(
        activity: FragmentActivity,
        onSubmitClicked: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit
    ) {
        val bottomSheetFragment = RatingBottomSheetFragment(onSubmitClicked, onRatingChangeListener)
        crossIcon?.let {
            bottomSheetFragment.setCancelIcon(it)
        }
        innerCardTextColorUnselected?.let {
            bottomSheetFragment.setUnselectedColorInnerCards(it)
        }
        innerCardTextColorSelected?.let {
            bottomSheetFragment.setSelectedColorInnerCards(it)
        }
        innerCardBackgroundColorUnselected?.let {
            bottomSheetFragment.setInnerCardBackgroundColorUnselected(it)
        }
        innerCardBackgroundColorSelected?.let {
            bottomSheetFragment.setInnerCardBackgroundColorSelected(it)
        }
        backgroundColor?.let { bottomSheetFragment.setBackgroundColor(it) }
        titleTextColor?.let { bottomSheetFragment.setTitleTextColor(it) }
        descriptionTextColor?.let { bottomSheetFragment.setDescriptionTextColor(it) }
        filledIcon?.let { bottomSheetFragment.setFilledIcon(it) }
        unfilledIcon?.let { bottomSheetFragment.setUnfilledIcon(it) }
        ratingOneEmoji?.let { bottomSheetFragment.setRatingOneEmoji(it) }
        ratingTwoEmoji?.let { bottomSheetFragment.setRatingTwoEmoji(it) }
        ratingThreeEmoji?.let { bottomSheetFragment.setRatingThreeEmoji(it) }
        ratingFourEmoji?.let { bottomSheetFragment.setRatingFourEmoji(it) }
        ratingFiveEmoji?.let { bottomSheetFragment.setRatingFiveEmoji(it) }
        titleText?.let { bottomSheetFragment.setTitleText(it) }
        descriptionText?.let { bottomSheetFragment.setDescriptionText(it) }
        confirmButtonText?.let { bottomSheetFragment.setConfirmButtonText(it) }
        confirmButtonTextColor?.let { bottomSheetFragment.setConfirmButtonTextColor(it) }
        confirmButtonBackgroundColor?.let { bottomSheetFragment.setConfirmButtonBackgroundColor(it) }

        // Show the bottom sheet fragment
        bottomSheetFragment.openBottomSheet(activity)
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