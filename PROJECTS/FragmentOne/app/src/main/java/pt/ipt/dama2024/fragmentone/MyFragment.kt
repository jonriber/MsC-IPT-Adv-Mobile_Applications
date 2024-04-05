package pt.ipt.dama2024.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1_TXT_LABEL = ""
private const val ARG_PARAM2_TXT_BUTTON = ""
private const val ARG_PARAM3_NUMBER = "0"

/**
 * A simple [Fragment] subclass.
 * Use the [MyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyFragment : Fragment() {
    private var txtLabel: String? = null
    private var txtButton: String? = null
    private var number:Byte = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            txtLabel = it.getString(ARG_PARAM1_TXT_LABEL)
            txtButton = it.getString(ARG_PARAM2_TXT_BUTTON)
            number = it.getByte(ARG_PARAM3_NUMBER)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_my, container, false)

        // look for fragment objects
        val aux_txt:TextView = view.findViewById(R.id.frag_text)
        val aux_btn:Button = view.findViewById(R.id.fragment_button)

        //assign parameters do variables
        aux_txt.text = txtLabel
        aux_btn.text = txtButton

        aux_btn.setOnClickListener{
            if (number % 2 !=0) {
                Toast.makeText(this.context, "Toaster Text, button $txtButton", Toast.LENGTH_LONG)
                    .show()
            } else {
                Snackbar.make(view,"Snackbar Text, button $txtButton", Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1, label text.
         * @param param2 Parameter 2, button text.
         * @param number Parameter 3, item position
         * @return A new instance of fragment MyFragment.
         */
        //Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, number: Byte) =
            MyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1_TXT_LABEL, param1)
                    putString(ARG_PARAM2_TXT_BUTTON, param2)
                    putByte(ARG_PARAM3_NUMBER, number)
                }
            }
    }
}