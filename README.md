
# Rating Bottom Sheet [![](https://jitpack.io/v/muhammadawaisshan/ratingbottomsheet.svg)](https://jitpack.io/#muhammadawaisshan/ratingbottomsheet)

A customizable Android library for displaying a rating bottom sheet dialog that provides emoji feedback. This library simplifies the process of integrating a rating system into your Android applications, making it easy to collect user ratings in a visually appealing manner.

## Features

- **Customizable Background and Text Colors**: Easily change the appearance of the bottom sheet.
- **Filled and Unfilled Icons**: Set different icons for rated and unrated states.
- **Emoji Feedback**: Integrate emoji for each rating level (1 to 5 stars) for a fun user experience.
- **Simple API**: Minimal setup to get started.
- **Lifecycle Aware**: Automatically handles the bottom sheet's lifecycle.

## Installation

### Gradle (Kotlin DSL)

To include the library in your project, add the following lines to your `build.gradle.kts` file:

```kotlin
 dependencies {
    implementation("com.github.muhammadawaisshan:ratingbottomsheet:1.0.2")
}
```

To include the library in your project, add the following lines to your `settings.gradle.kts` file:
```kotlin
  repositories {
        maven("https://jitpack.io")
    }
```
## Usage
Basic Example
To show the rating bottom sheet, use the RatingBottomSheetBuilder class to configure it:
 ```koltin
RatingBottomSheetBuilder
    .show(activity) { rating, dialog ->
        // Handle the rating submission
        dialog.dismiss()
    }
```
# Customization Options for Rating Bottom Sheet
| Method Name                             | Description                                                      |
|-----------------------------------------|------------------------------------------------------------------|
| `setOnRatingChangeListener(listener: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit)` | Sets a listener to be called whenever the rating changes in the rating bar. |
| `setBackgroundColor(@ColorRes color: Int)` | Sets the background color for the bottom sheet using a color resource ID. |
| `setInnerCardBackgroundColorUnselected(@ColorRes color: Int)` | Sets the background color for the inner card when it is unselected in the bottom sheet. |
| `setInnerCardBackgroundColorSelected(@ColorRes color: Int)` | Sets the background color for the inner card when it is selected in the bottom sheet. |
| `setTitleTextColor(@ColorRes color: Int)` | Sets the text color for the labels in the bottom sheet.         |
| `setUnselectedTextColorInnerCards(@ColorRes color: Int)` | Sets the text color for unselected inner cards.                 |
| `setSelectedTextColorInnerCards(@ColorRes color: Int)` | Sets the text color for selected inner cards.                   |
| `setCrossIcon(@DrawableRes resId: Int)` | Sets the drawable resource ID for the icon representing a close button in the bottom sheet. |
| `setDescriptionTextColor(@ColorRes color: Int)` | Sets the text color for the description in the bottom sheet.     |
| `setRatingOneEmoji(@DrawableRes resId: Int)` | Sets the drawable resource ID for the emoji representing a rating of 1 star. |
| `setRatingTwoEmoji(@DrawableRes resId: Int)` | Sets the drawable resource ID for the emoji representing a rating of 2 stars. |
| `setRatingThreeEmoji(@DrawableRes resId: Int)` | Sets the drawable resource ID for the emoji representing a rating of 3 stars. |
| `setRatingFourEmoji(@DrawableRes resId: Int)` | Sets the drawable resource ID for the emoji representing a rating of 4 stars. |
| `setRatingFiveEmoji(@DrawableRes resId: Int)` | Sets the drawable resource ID for the emoji representing a rating of 5 stars. |
| `setFilledIcon(@DrawableRes resId: Int)` | Sets the resource ID for the filled icon using a drawable resource ID. |
| `setUnfilledIcon(@DrawableRes resId: Int)` | Sets the resource ID for the unfilled icon using a drawable resource ID. |
| `setTitleText(text: String)` | Sets the title text for the bottom sheet.                        |
| `setDescriptionText(text: String)` | Sets the description text for the bottom sheet.                  |
| `setConfirmButtonText(text: String)` | Sets the text for the confirm button in the bottom sheet.        |
| `setConfirmButtonTextColor(@ColorRes color: Int)` | Sets the text color for the confirm button in the bottom sheet. |
| `setConfirmButtonBackgroundColor(@ColorRes color: Int)` | Sets the background color for the confirm button in the bottom sheet. |
| `show(activity: FragmentActivity, onSubmitClicked: (rating: Int, dialog: BottomSheetDialogFragment) -> Unit)` | Displays the bottom sheet with the configured settings.          |
 
 Example Usage
Here’s a full example of how to use the library in your activity:
```kotlin
class YourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your)

        // Show the rating bottom sheet
        RatingBottomSheetBuilder()
            .setBackgroundColor(R.color.your_background_color)
            .setInnerCardBackgroundColorUnselected(R.color.your_unselected_color)
            .setInnerCardBackgroundColorSelected(R.color.your_selected_color)
            .setTitleTextColor(R.color.your_title_text_color)
            .setUnselectedTextColorInnerCards(R.color.your_unselected_text_color)
            .setSelectedTextColorInnerCards(R.color.your_selected_text_color)
            .setCrossIcon(R.drawable.your_close_icon)
            .setDescriptionTextColor(R.color.your_description_text_color)
            .setRatingOneEmoji(R.drawable.one_star_emoji)
            .setRatingTwoEmoji(R.drawable.two_star_emoji)
            .setRatingThreeEmoji(R.drawable.three_star_emoji)
            .setRatingFourEmoji(R.drawable.four_star_emoji)
            .setRatingFiveEmoji(R.drawable.five_star_emoji)
            .setFilledIcon(R.drawable.your_filled_icon)
            .setUnfilledIcon(R.drawable.your_unfilled_icon)
            .setTitleText("Rate Us")
            .setDescriptionText("Please rate your experience.")
            .setConfirmButtonText("Submit")
            .setConfirmButtonTextColor(R.color.your_confirm_button_text_color)
            .setConfirmButtonBackgroundColor(R.color.your_confirm_button_background_color)
            .setOnRatingChangeListener { rating, dialog ->
                // Handle the rating change
                Toast.makeText(this, "Rating changed to: $rating stars", Toast.LENGTH_SHORT).show()
            }
            .show(this) { rating, dialog ->
                // Handle the rating submission
                Toast.makeText(this, "You rated: $rating stars", Toast.LENGTH_SHORT).show()
            }
    }
}
```

 
 

Contact
For any inquiries or support, please reach out muhamadawaiss400@gmail.com
Feel free to customize any parts of the text to better fit your library and personal contact information!
