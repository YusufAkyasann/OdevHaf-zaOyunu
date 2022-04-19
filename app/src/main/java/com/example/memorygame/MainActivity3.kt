package com.example.memorygame

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.memorygame.R.drawable.*
import com.example.memorygame.utils.showLogDebug
import com.example.memorygame.utils.showToast
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*

class MainActivity3 : AppCompatActivity() {

    private var eslesmeSayisi = 0
    private var hamleSayisi = 0
    var timer: Int = 0
    var skor: Int= 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        object : CountDownTimer(8000000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer++
                timerTextView.text = "Süre:"+ timer.toString()

            }

            override fun onFinish() {

            }
        }.start()



        val tiklamaListImage = arrayListOf<Int>()
        val tiklamaListButton = arrayListOf<ImageButton>()





        var foto:MutableList<Int> = mutableListOf(
            resim1,resim2,resim3,resim4,resim5,resim6,resim7, resim8,resim9,resim10,resim11,resim12,
            resim13,resim14,resim15,resim16,resim17,resim18,resim1,resim2,resim3,resim4,resim5,resim6,resim7, resim8
            ,resim9,resim10,resim11,resim12,resim13,resim14,resim15,resim16,resim17,resim18
        )
        foto.shuffle()

         var btnList = arrayOf(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,
            btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20,
            btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,
            btn31,btn32,btn33,btn34,btn35,btn36)


        for ((index, btn) in btnList.withIndex()) {
            btn.setOnClickListener {
                btn.isClickable = false
                btn.setImageResource(foto.get(index))
                tiklamaListImage.add(foto.get(index))
                tiklamaListButton.add(btn)
                hamleSayisi++
                hamleSayisiTextView.text = hamleSayisi.toString()



                if (tiklamaListImage.size == 2){

                    tiklamaListButton.get(0).isClickable = true
                    tiklamaListButton.get(1).isClickable = true

                   showLogDebug(this.toString(),tiklamaListImage.toString())

                    if (tiklamaListImage.get(0) == tiklamaListImage.get(1)){
                        showLogDebug("ZorMod", "buldum")
                        showToast(this,"buldum")
                        eslesmeSayisi++
                        eslesmeSayisiTextView.text = eslesmeSayisi.toString()
                        skor+=10
                        skorTextView.text="skor:"+skor.toString()


                        if (eslesmeSayisi == 18) {

                            val alertDialogBuilder = AlertDialog.Builder(this)

                            alertDialogBuilder.setTitle("süre : ${timer}")
                            alertDialogBuilder.setMessage("skorunuz : ${eslesmeSayisi} hamle sayisi : ${hamleSayisi}")
                            alertDialogBuilder.setPositiveButton("Kayıt et") { dialog, which ->
                                Toast.makeText(applicationContext, "",Toast.LENGTH_SHORT).show()
                            }
                            alertDialogBuilder.show()


                        }


                        tiklamaListImage.clear()
                        tiklamaListButton.clear()
                    }else{
                        Handler().postDelayed({
                            hideImg(tiklamaListButton.get(0))
                            hideImg(tiklamaListButton.get(1))
                            tiklamaListImage.clear()
                            tiklamaListButton.clear()
                            skor-=2
                            if (skor<=0){
                                skor=0

                            }
                            skorTextView.text="skor:"+skor.toString()
                        }, 300)

                    }


                }

            }
        }
    }




    fun hideImg(btn: ImageButton){
        btn.setImageResource(kapali)
    }






}