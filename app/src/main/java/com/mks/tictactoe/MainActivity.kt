package com.mks.tictactoe

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var a1: Button
    lateinit var a2: Button
    lateinit var a3: Button
    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var c1: Button
    lateinit var c2: Button
    lateinit var c3: Button
    private lateinit var tv: TextView
    private lateinit var tv_p1: TextView
    private lateinit var tv_p2: TextView
    var turn= 0
    var p1Win=0
    var p2Win=0
    private var p1 = "X"
    var p2 = "O"
    var activeplayer= p1
    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a1=findViewById(R.id.a1)
        a2=findViewById(R.id.a2)
        a3=findViewById(R.id.a3)
        b1=findViewById(R.id.b1)
        b2=findViewById(R.id.b2)
        b3=findViewById(R.id.b3)
        c1=findViewById(R.id.c1)
        c2=findViewById(R.id.c2)
        c3=findViewById(R.id.c3)
        tv=findViewById(R.id.tv_msg)
        tv_p1 =findViewById(R.id.p1)
        tv_p2=findViewById(R.id.p2)
        a1.setOnClickListener(this)
        a2.setOnClickListener(this)
        a3.setOnClickListener(this)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        c1.setOnClickListener(this)
        c2.setOnClickListener(this)
        c3.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        val clickbtn: Button = findViewById(p0!!.id)
        if(activeplayer==p1) {
            tv.text = "Player 2's turn"
        }else{
            tv.text="Player 1's turn"
        }
        if (activeplayer == p2 && clickbtn.text.isEmpty()){
            clickbtn.text = "O"
            activeplayer=p1
            turn+=1

        }
        else if(activeplayer == p1 && clickbtn.text.isEmpty()){
            clickbtn.text="X"
            activeplayer = p2
            turn+=1

        }

            checkWin()

    }


    @SuppressLint("SetTextI18n")
    private fun checkWin() {
        val winPos = arrayOf(
            arrayOf(a1, a2, a3),
            arrayOf(b1, b2, b3),
            arrayOf(c1, c2, c3),
            arrayOf(a1, b2, c3),
            arrayOf(a3, b2, c1),
            arrayOf(a1, b1, c1),
            arrayOf(a2, b2, c2),
            arrayOf(a3, b3, c3)
        )


        for (i in winPos.indices) {
            val val0 = winPos[i][0]
            val val1 = winPos[i][1]
            val val2 = winPos[i][2]


            if (val0.text == val1.text && val1.text == val2.text) {
                if (val0.text.equals("X") && val0.text.isNotEmpty()) {
                    tv.text = "Player 1 wins"
                    activeplayer="win"

                    p1Win+=1
                    tv_p1.text="Player 1 \n$p1Win"
                    restartGame()
                } else if (val0.text.equals("O") && val0.text.isNotEmpty()) {
                    tv.text = "Player 2 wins"
                    activeplayer="win"
                    p2Win+=1
                    tv_p2.text="Player 2 \n$p2Win"
                    restartGame()
                }

            }else if(turn>=9 && activeplayer!="win"){
                tv.text="Draw!!!"
                restartGame()
            }


        }
    }

    private fun restartGame(){
        val btn= arrayOf(a1,a2,a3,b1,b2,b3,c1,c2,c3)
        for (i in btn){
            i.text=""

        }
        activeplayer=p1
        turn=0
    }

}


