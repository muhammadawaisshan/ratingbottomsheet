
# Rating Bottom Sheet [![](https://jitpack.io/v/bucket04/ratingbottomsheet.svg)](https://jitpack.io/#bucket04/ratingbottomsheet)

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
    implementation("com.github.bucket04:ratingbottomsheet:LATEST_VERSION")
}
```

To include the library in your project, add the following lines to your `settings.gradle.kts` file:
```kotlin
  repositories {
        maven("https://jitpack.io")
    }
```
#Usage
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
| `setBackgroundColor(@ColorRes color: Int)` | Set the background color of the bottom sheet.                    |
| `setTextColor(@ColorRes color: Int)`       | Set the color of the text displayed in the bottom sheet.         |
| `setFilledIcon(@DrawableRes resId: Int)`   | Set the icon for filled stars.                                   |
| `setUnfilledIcon(@DrawableRes resId: Int)` | Set the icon for unfilled stars.                                 |
| `setRatingOneEmoji(@DrawableRes resId: Int)` | Set the emoji for a 1-star rating.                              |
| `setRatingTwoEmoji(@DrawableRes resId: Int)` | Set the emoji for a 2-star rating.                              |
| `setRatingThreeEmoji(@DrawableRes resId: Int)` | Set the emoji for a 3-star rating.                              |
| `setRatingFourEmoji(@DrawableRes resId: Int)`  | Set the emoji for a 4-star rating.                              |
| `setRatingFiveEmoji(@DrawableRes resId: Int)`  | Set the emoji for a 5-star rating.                              |
| `show(activity: FragmentActivity, onSubmitClicked: ((Int, BottomSheetDialogFragment) -> Unit))` | Display the bottom sheet with the configured settings.          |
 
 Example Usage
Here’s a full example of how to use the library in your activity:
```kotlin
class YourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your)

        // Show the rating bottom sheet
        RatingBottomSheetBuilder
            .setBackgroundColor(R.color.your_background_color)
            .setTextColor(R.color.your_text_color)
            .setFilledIcon(R.drawable.your_filled_icon)
            .setUnfilledIcon(R.drawable.your_unfilled_icon)
            .setRatingOneEmoji(R.drawable.one_star_emoji)
            .setRatingTwoEmoji(R.drawable.two_star_emoji)
            .setRatingThreeEmoji(R.drawable.three_star_emoji)
            .setRatingFourEmoji(R.drawable.four_star_emoji)
            .setRatingFiveEmoji(R.drawable.five_star_emoji)
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
