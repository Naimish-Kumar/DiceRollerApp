package com.example.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import com.example.dicerollerapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val diceImg: ImageView = binding.randomNumberImg
        val randomText: TextView = binding.randomNumber
        val button: Button = binding.rollDicedBtn
        val randomNumber = Dice(6).roll()
        button.setOnClickListener {
            val toast = makeText(/* context = */ this,/* text = */
                "Dice Rolled Random Number is: $randomNumber",/* duration = */
                Toast.LENGTH_SHORT
            )
            toast.show()
            randomText.text = randomNumber.toString()
           val drawableResource =  when (randomNumber) {
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                else -> R.drawable.six
            }
            diceImg.setImageResource(drawableResource)
            diceImg.contentDescription = randomNumber.toString()
        }

    }
}


class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}