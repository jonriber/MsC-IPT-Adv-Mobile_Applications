package pt.ipt.dama2024.mycv

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * function responsible for starting everything
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting button
        findViewById<Button>(R.id.show_CV_Button).setOnClickListener(){
            showCV(it)
        }
    }

    /**
     * T
     * @author Jonatas Ribeiro
     * @param View this is the view which is being changed
     */
    private fun showCV(view: View) {

        // first find textbox
        // then find button
        // then find cv text

        // pointer to view objects

        val showCvButton = findViewById<Button>(R.id.show_CV_Button)
        val nickNameText = findViewById<EditText>(R.id.editText_nickname)
        val labelNickNameQuestion = findViewById<TextView>(R.id.textView_ask_for_nickName)
        val scrollViewCV = findViewById<ScrollView>(R.id.show_CV)

        // hide the keyboard
        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)

        labelNickNameQuestion.text = nickNameText.text
        labelNickNameQuestion.gravity = Gravity.CENTER
        showCvButton.visibility = View.GONE
        if(scrollViewCV.visibility == View.VISIBLE){
            scrollViewCV.visibility = View.INVISIBLE
            showCvButton.text = "Show"
        }else{
            scrollViewCV.visibility = View.VISIBLE
            showCvButton.text = "Hide"

        }
    }
}