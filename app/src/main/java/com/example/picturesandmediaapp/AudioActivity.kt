package com.example.picturesandmediaapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Integer.parseInt
import kotlin.random.Random

class AudioActivity : AppCompatActivity() {

    lateinit var number: EditText
    lateinit var guessBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        var sound : MediaPlayer = MediaPlayer.create(this, R.raw.sound)
        number = findViewById(R.id.number)
        guessBtn = findViewById(R.id.guessBtn)
        setOnClickListenerOnGuessingButton(sound)
    }

    private fun setOnClickListenerOnGuessingButton(sound: MediaPlayer) {
        guessBtn.setOnClickListener {
            val randText : String = ""
            // lateinit var randNum: Random
            var randNum: Random? = null
            val random: Int = (randNum?.nextInt(5) ?: 0) + 1
            val userChoice: Int = parseInt(number.text.toString().trim())
            if (userChoice < 1 || userChoice > 5) {
                showToast("Please guess a number between 1 and 5")
            } else if (userChoice == random) {
                /*If User worked out guessing the number correctly
                        Crowd Cheering sound will start*/
                if (sound.isPlaying) {
                    sound.seekTo(0)
                } else {
                    sound.start()
                }
                showToast("Congratulations, you guessed the number correctly")
            } else {
                showToast("Sorry, better luck next time!")
            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}