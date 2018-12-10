package mymobileapp.code.mbasuony.calculatebirthday

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

   private var currentDay:Int = 0;
   private var currentMonth:Int=0;
   private var currentYear:Int=0;

   private  var resultDay:Int?=0
   private var resultMonth:Int?=0
   private var resultYear:Int?=0

   private var dayBirthday:String = ""
    private var monthBirthday:String = ""
    private var yearBirthday:String = ""

    private var calendar: Calendar? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

             calendar= Calendar.getInstance()




        //------------Event-------------------//
        btn_calculate.setOnClickListener(
            {
                dayBirthday= editDay.text.toString()
                monthBirthday= editMonth.text.toString()
                yearBirthday= editYear.text.toString()

                getCalender(dayBirthday,monthBirthday,yearBirthday)

            })


    }

    private fun getCalender(dayBirthday: String, monthBirthday: String, yearBirthday: String)
    {
        currentDay= calendar!!.get(Calendar.DAY_OF_MONTH)
        currentMonth= calendar!!.get(Calendar.MONTH)
        currentYear=calendar!!.get(Calendar.YEAR)


        if (TextUtils.isEmpty(dayBirthday))
        {
            editDay.setError("Please Enter Day")
            return
        }

        if (TextUtils.isEmpty(monthBirthday))
        {
             editMonth.setError("Please Enter Month")
             return
        }

        if (TextUtils.isEmpty(yearBirthday))
        {
            editYear.setError("Please Enter Year")
            return
        }else
        {

            var day:Int=Integer.valueOf(dayBirthday);
            var month:Int=Integer.valueOf(monthBirthday);
            var year:Int=Integer.valueOf(yearBirthday);
            
            resultDay=currentDay-day
            resultMonth=currentMonth-month
            resultYear=currentYear-year

            if (resultDay!! <0)
            {
                resultDay= resultDay!! * -1
            }

            if (resultMonth!! <0)
            {
                resultMonth= resultMonth!! * -1
            }

            editDay.setText("")
            editMonth.setText("")
            editYear.setText("")
            textResult.setText(""+resultDay+" "+"Day"+" - "+" "+resultMonth+" Month "+" - "+resultYear+" Year ")

        }


    }


}
