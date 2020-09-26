package com.example.gridcardview

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_km_mile.*

class KmMile : AppCompatActivity() {

    val  mypreference="mypref"
    val key="myValues"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_km_mile)

        sharedPreferences=getSharedPreferences(mypreference, Context.MODE_PRIVATE)
    }
var kilomer=""
 var mile=""
    fun readData(){
        if (sharedPreferences.contains("km")){
         kilomer=sharedPreferences.getString("km","")
        }
        if (sharedPreferences.contains("mile")){
                mile=sharedPreferences.getString("mile","")
            }
    }

    override fun onPause() {
        super.onPause()
        val mile=mile_et.text.toString()
        val km=kilo_et.text.toString()
        save(km,mile)
    }
    override fun onResume() {
        super.onResume()
        readData()
        mile_et.setText(mile)
        kilo_et.setText(kilomer)
    }

    fun convertButtonSelect(view: View) {
      when(view){
          mile_to_kilo->{
              val mile=mile_et.text.toString().toDouble()
              val tokilo=mile*1.6
              kilo_et.setText(tokilo.toString())
              val units=Units(tokilo.toString(),mile.toString())
          }
          kilo_to_mile->{
              val kilo=kilo_et.text.toString().toDouble()
              val toMile=kilo/1.6
              mile_et.setText(toMile.toString())


          }
      }

    }
    fun save(km: String,mile:String){
        //val units=Units(km,mile)
       val editor=sharedPreferences.edit()
        editor.putString("km",km)
        editor.putString("mile",mile)
        editor.commit()
        Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show()

    }


}



class Units(val km:String,val Mile:String){
    constructor():this("","")
}