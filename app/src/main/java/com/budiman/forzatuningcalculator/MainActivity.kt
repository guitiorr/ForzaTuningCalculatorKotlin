package com.budiman.forzatuningcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private var backResult: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var minInput: TextView? = findViewById(R.id.minInput)
        var clrMin: TextView? = findViewById(R.id.minClear)
        var clrMax: TextView? = findViewById(R.id.maxClear)
        var clrFront: TextView? = findViewById(R.id.clrFront)

        var maxInput: TextView? = findViewById(R.id.maxInput)
        var frontBalance: TextView? = findViewById(R.id.frontBalanceInput)
        var submit: Button = findViewById(R.id.sbtButton)

        var frontTune: TextView? = findViewById(R.id.frontResult)
        var backTune: TextView? = findViewById(R.id.backTune)

        submit.setOnClickListener{
            if(minInput!!.text.isNotEmpty() && maxInput!!.text.isNotEmpty() && frontBalance!!.text.isNotEmpty()){
                var minInputValue: Double = minInput?.text.toString().toDouble()
                var maxInputValue: Double = maxInput?.text.toString().toDouble()
                var frontBalanceValue: Double = frontBalance?.text.toString().toDouble()
                var backBalance: Double = 100 - frontBalanceValue

                backBalance /= 100
                frontBalanceValue /= 100

                frontTune?.text = frontCount(maxInputValue, minInputValue, frontBalanceValue).toString()
                backTune?.text = backCount(maxInputValue, minInputValue, backBalance).toString()
            }
        }

        clrMin?.setOnClickListener{
            minInput?.text = null
        }

        clrMax?.setOnClickListener{
            maxInput?.text = null
        }

        clrFront?.setOnClickListener {
            frontBalance?.text = null
        }

    }

    fun frontCount(max: Double, min: Double, front: Double): Double {
        var frontResult: Double = (max-min)*front+min

        return frontResult
    }

    fun backCount(max: Double, min: Double, back: Double): Double {
        var backResult: Double = (max-min)*back+min

        return backResult
    }

}