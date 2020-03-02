package com.example.fragmentsexchangeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    // A global variable to alternate fragments
    private var isFragmentOneLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    // This method replace one fragment with another
    fun exchangeFragments(view: View) {

        // Begin the transaction
        val transaction = supportFragmentManager.beginTransaction()

        // Create an instance of your fragment(s)
        val fragmentOne = FragmentOne()
        val fragmentTwo = FragmentTwo()

        if (isFragmentOneLoaded){
            // Replace the contents of the container with the new fragment
            transaction.replace(R.id.fragment1, fragmentOne)
            transaction.replace(R.id.fragment2, fragmentTwo)
            isFragmentOneLoaded = false
        }
        else{
            // Replace the contents of the container with the new fragment
            transaction.replace(R.id.fragment1, fragmentTwo)
            transaction.replace(R.id.fragment2, fragmentOne)
            isFragmentOneLoaded = true
        }


        // Add this transaction to the back stack.
        // This means that the transaction will be remembered after it is committed
        transaction.addToBackStack(null)

        // Complete the changes added above -- You must call commit for changes to take place
        transaction.commit()


    }
}
