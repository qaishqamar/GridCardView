package com.example.gridcardview

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tictac_toe.*

class TictacToe : AppCompatActivity() {
    val player1=ArrayList<Number>()
    val player2=ArrayList<Number>()

    var player=0
    val  mypreferencePlayer="myplayerpref"
    val key="myValues"
    lateinit var sharedPreferencesP: SharedPreferences
    lateinit var firstplayerName:String
    lateinit var seconndplayerName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictac_toe)

        sharedPreferencesP=getSharedPreferences(mypreferencePlayer, Context.MODE_PRIVATE)
         start_button.setOnClickListener {
             firstplayerName=firstplayer_et.text.toString()
             seconndplayerName=secondplayer_et.text.toString()
            if (TextUtils.isEmpty(firstplayerName)&&TextUtils.isEmpty(seconndplayerName)){
                Toast.makeText(this,"Please insert playes name",Toast.LENGTH_SHORT).show()

            }
             else{
                savePlayername()
                games_layout.visibility=View.VISIBLE
                set_player_layout.visibility=View.GONE

            }

         }
        play_again.setOnClickListener {
            reset()
        }
    }

    fun selectButton(view: View) {
        when(view){
            first_button->  game(1,first_button)
            second_button->  game(2,second_button)
            third_button-> game(3,third_button)
            fourth_button-> game(4,fourth_button)
            fifth_button-> game(5,fifth_button)
            sixth_button->game(6,sixth_button)
            seventh_button->game(7,seventh_button)
            eighth_button->game(8,eighth_button)
            nineth_button->game(9,nineth_button)

        }
    }
    fun reset(){
        player=0
        first_button.setBackgroundColor(Color.WHITE)
        second_button.setBackgroundColor(Color.WHITE)
        third_button.setBackgroundColor(Color.WHITE)
        fourth_button.setBackgroundColor(Color.WHITE)
        fifth_button.setBackgroundColor(Color.WHITE)
        sixth_button.setBackgroundColor(Color.WHITE)
        seventh_button.setBackgroundColor(Color.WHITE)
        eighth_button.setBackgroundColor(Color.WHITE)
        nineth_button.setBackgroundColor(Color.WHITE)

        first_row.visibility=View.VISIBLE
        second_row.visibility=View.VISIBLE
        third_row.visibility=View.VISIBLE
        winner_layout.visibility=View.GONE
        first_button.text = ""
        second_button.text = ""
        third_button.text = ""
        fourth_button.text = ""
        fifth_button.text = ""
        sixth_button.text = ""
        seventh_button.text = ""
        eighth_button.text = ""
        nineth_button.text = ""

        player1.clear()
        player2.clear()


        first_button.isEnabled = true
        second_button.isEnabled = true
        third_button.isEnabled = true
        fourth_button.isEnabled = true
        fifth_button.isEnabled = true
        sixth_button.isEnabled = true
        seventh_button.isEnabled = true
        eighth_button.isEnabled = true
        nineth_button.isEnabled = true


    }
    fun winerView(playerName:String){
        Toast.makeText(this,"$playerName is winner",Toast.LENGTH_LONG).show()
        winner_name_tv.setText(playerName+" is winner")
        win_pic.setImageResource(R.drawable.winner_pic)
        first_row.visibility=View.GONE
        second_row.visibility=View.GONE
        third_row.visibility=View.GONE
        winner_layout.visibility=View.VISIBLE
    }
    fun game( button:Number,buttonId: Button){
        player++
        var win=0
        if(player%2==1){
            buttonId.setBackgroundColor(Color.RED)
            buttonId.setText("X")
            buttonId.isEnabled=false
            player1.add(button)
            if (player1.lastIndex>=2){
                win= checkWinner(player1)
            }
            if (win==1){
                winerView(firstplayerName)
            }

        }
        else{
            buttonId.setBackgroundColor(Color.GREEN)
            buttonId.setText("O")
            buttonId.isEnabled=false
            player2.add(button)
            if (player2.lastIndex>=2){
                win= checkWinner(player2)
            }
            if (win==1){
                winerView(seconndplayerName)
            }
        }
        if(player==9){
            first_row.visibility=View.GONE
            second_row.visibility=View.GONE
            third_row.visibility=View.GONE
            win_pic.setImageResource(R.drawable.draw_image)
            winner_layout.visibility=View.VISIBLE
        }

    }

    fun  checkWinner(result:ArrayList<Number>):Int{

        if(result.contains(1)&&result.contains(2)&&result.contains(3)){
            return 1
        }
        if (result.contains(1)&&result.contains(4)&&result.contains(7)){
            return 1
        }
        if (result.contains(2)&&result.contains(5)&&result.contains(8)){
            return 1
        }
        if (result.contains(3)&&result.contains(6)&&result.contains(9)){
            return 1
        }
        if (result.contains(4)&&result.contains(5)&&result.contains(6)){
            return 1
        }
        if (result.contains(7)&&result.contains(8)&&result.contains(9)){
            return 1
        }
        if (result.contains(1)&&result.contains(5)&&result.contains(9)){
            return 1
        }
        if (result.contains(3)&&result.contains(5)&&result.contains(7)){
            return 1
        }

        return 0
    }
fun savePlayername(){
    val khiladi1=firstplayer_et.text.toString()
    val khiladi2=secondplayer_et.text.toString()
    val edit=sharedPreferencesP.edit()
    edit.putString(firstplayerKey,khiladi1)
    edit.putString(secondplayerKey,khiladi2)
    edit.commit()
    Toast.makeText(this,"khiladi details saved",Toast.LENGTH_SHORT).show()
}
    fun readPlayerName(){
        if (sharedPreferencesP.contains(firstplayerKey)){
            val player1=sharedPreferencesP.getString(firstplayerKey,"")
            firstplayer_et.setText(player1)
        }
        if (sharedPreferencesP.contains(secondplayerKey)){
            val player2=sharedPreferencesP.getString(secondplayerKey,"")
            secondplayer_et.setText(player2)
        }
    }

    override fun onResume() {
        super.onResume()
        readPlayerName()
    }

    override fun onPause() {
        super.onPause()
        savePlayername()
    }
    val firstplayerKey="firstplayer"
    val secondplayerKey="secondtplayer"
}
