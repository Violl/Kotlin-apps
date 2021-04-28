package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice1 = Dice(6)
        val dice2 = Dice(6)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDices(dice1, dice2) }

        rollDices(dice1, dice2)
    }

    /**
     * Roll the dice and update the screen with the result.
     */

    private fun rollDice(dice: Dice, view: ImageView) {
        // Create new Dice object with 6 sides and roll it
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val diceImage: ImageView = view

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun rollDices(dice1: Dice, dice2: Dice){
        rollDice(dice1, findViewById(R.id.imageView))
        rollDice(dice2, findViewById(R.id.imageView2))
    }

}