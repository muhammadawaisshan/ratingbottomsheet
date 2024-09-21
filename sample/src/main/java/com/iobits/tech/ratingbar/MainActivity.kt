package com.iobits.tech.ratingbar

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.iobits.tech.ratingbottomsheet.RatingBottomSheetBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        lifecycleScope.launch {
            delay(3000)
            RatingBottomSheetBuilder.setTitleText("Title is as Follow")
                .setSelectedTextColorInnerCards(
                    com.iobits.tech.ratingbottomsheet.R.color.light_orange
                ).setUnselectedTextColorInnerCards(
                    com.iobits.tech.ratingbottomsheet.R.color.dark_green
                ).setDescriptionText("This is desc").setConfirmButtonText("noConfitm")
                .setTitleTextColor(R.color.black).setDescriptionTextColor(
                    com.iobits.tech.ratingbottomsheet.R.color.ad_color
                ).setConfirmButtonTextColor(com.iobits.tech.ratingbottomsheet.R.color.textInner)
                .setConfirmButtonBackgroundColor(
                    com.iobits.tech.ratingbottomsheet.R.color.colorAccent
                ).setOnRatingChangeListener { rating, dialog ->
                    Log.d("TAG", "onCreateKistner:$rating ")

                }.show(this@MainActivity) { rating, bottomSheet ->
                    Log.d("TAG", "onCreate:$rating ")
                    if (rating == 5) {
                        bottomSheet.dismiss()
                    }
                }
        }
    }
}