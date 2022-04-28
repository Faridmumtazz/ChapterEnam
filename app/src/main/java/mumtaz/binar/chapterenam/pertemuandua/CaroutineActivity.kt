package mumtaz.binar.chapterenam.pertemuandua

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_caroutine.*
import kotlinx.coroutines.*
import mumtaz.binar.chapterenam.R

class CaroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caroutine)

//        contohCaroutine()
//        CoroutineScope(Dispatchers.Main).launch {
//            contohCaroutine()
//        }
        contohCR()
    }

    fun contohCR(){
        GlobalScope.launch {
            CoroutineScope(Dispatchers.Main).launch {
                tvCaroutine.text = dotext()
                btn_prosess.setOnClickListener {
                    val a = bb_ett.text.toString()
                    val b = tb_ett.text.toString()
                    val c = b.toInt() / 100
                    val hasil = a.toInt() / (c*c)


                    if (hasil < 18.5){
                        tvHasill.text = "Berat Badan Kurang"
                    }else if (hasil >= 18.5 && hasil <= 24.5) {
                        tvHasill.text = "Berat Badan Ideal"

                    }else if (hasil >= 25 && hasil <= 29.9) {
                        tvHasill.text = "Berat Badan Overweight"

                    }else if (hasil >= 30 && hasil <= 39.9){
                        tvHasill.text ="Berat Badan Obesitas"
                    }else{
                        tvHasill.text = "Berat Badan Gemuk Sekali"
                    }
                }


            }




            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG, "dispatcher IO")
            }
            CoroutineScope(Dispatchers.Default).launch {
                Log.d(TAG, "dispatcher Default")
            }
        }
    }

    suspend fun dotext(): String{
        return "Hello Binar"
    }



}