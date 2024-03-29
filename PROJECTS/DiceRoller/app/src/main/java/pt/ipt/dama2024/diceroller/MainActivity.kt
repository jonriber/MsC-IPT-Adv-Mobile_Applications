package pt.ipt.dama2024.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var auxDiceImage:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //when clicking the button, an event gets triggered
        // catching this

        val auxBt = findViewById<Button>(R.id.button)
            auxBt.setOnClickListener{
            rollTheDice()
            }
            auxBt.setOnLongClickListener {
                resetDice()
            }

    }

    /**
     * Roll the dice function
     * generates a random value between 1 and 6
     */
     private fun rollTheDice(){
        val randomNumber = java.util.Random().nextInt(6) +1
        val auxTxt =findViewById<TextView>(R.id.dice_value)

         auxTxt.text = randomNumber.toString()

         val imageToShow = when (randomNumber){
             1 -> R.drawable.dice_1
             2 -> R.drawable.dice_2
             3 -> R.drawable.dice_3
             4 -> R.drawable.dice_4
             5 -> R.drawable.dice_5
             6 -> R.drawable.dice_6
             else -> R.drawable.empty_dice
         }

         auxDiceImage = findViewById(R.id.image_view)
         auxDiceImage.setImageResource(imageToShow)

     }

    /**
     * Reset function, which is attached to a long click event
     * It basically resets our app status
     */
    private fun resetDice(){
        val auxTxt =findViewById<TextView>(R.id.dice_value)
        auxTxt.text = 0.toString()
    }

}