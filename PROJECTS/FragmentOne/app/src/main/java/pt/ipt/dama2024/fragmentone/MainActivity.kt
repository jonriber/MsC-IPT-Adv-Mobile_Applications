package pt.ipt.dama2024.fragmentone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    //adding 3 different variables
    lateinit var f1:MyFragment
    lateinit var f2:MyFragment
    lateinit var f3:MyFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f1 = MyFragment.newInstance("Fragment 1", "button 1",1)
        f2 = MyFragment.newInstance("Fragment 2", "button 2",2)
        f3 = MyFragment.newInstance("Fragment 3", "button 3",3)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frag1,f1)
        fragmentTransaction.add(R.id.frag2,f2)
        fragmentTransaction.add(R.id.frag3,f3)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()

    }

}