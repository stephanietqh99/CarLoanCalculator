package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCal.setOnClickListener {
            calculateLoan()
        }
    }

    //button
    private fun calculateLoan(){
        //getting input data from user
        val cal_car_price = carPrice.text.toString().toInt()
        val cal_down_payment = downPayment.text.toString().toInt()
        val cal_loan_period = loan.text.toString().toInt()
        val cal_interest_rate = interestRate.text.toString().toFloat()

        val calCarLoan = cal_car_price - cal_down_payment
        val calInterest = calCarLoan * cal_interest_rate * cal_loan_period
        val calmonthlyPayment = (calCarLoan + calInterest)/cal_loan_period/12

        //display
        carLoan.text = getString(R.string.car_loan) + " ${calCarLoan}"
        interest.text = getString(R.string.interest) + " ${calInterest}"
        repayment.text = getString(R.string.monthly_repayment) + " ${calmonthlyPayment}"

    }

    fun resetInput(view: View){
        carPrice.text = null
        downPayment.text = null
        loan.text = null
        interestRate.text = null
    }


}
