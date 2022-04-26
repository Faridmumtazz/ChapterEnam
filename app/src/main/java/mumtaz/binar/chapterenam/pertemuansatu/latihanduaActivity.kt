package mumtaz.binar.chapterenam.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_latihandua.*
import mumtaz.binar.chapterenam.R

class latihanduaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihandua)


        handlerThread()
    }

    fun thread(){
        Thread(Runnable {
            btn_submit.setOnClickListener {
                val bb = et_bb.text.toString()
                val tb = et_tb.text.toString()
                val tinggi = tb.toInt() / 100
                val hasil = bb.toInt() / (tinggi*tinggi)

                if (hasil < 18.5){
                    tv_ket.post(Runnable {
                        tv_ket.text = "Kurus"
                    })
                }else if (hasil >= 18.5 && hasil <= 24.5) {
                    tv_ket.post(Runnable {
                        tv_ket.text = "Normal"
                    })
                }else if (hasil >= 25 && hasil <= 29.9) {
                    tv_ket.post(Runnable {
                        tv_ket.text = "Overweight"
                    })
                }else{
                    tv_ket.post(Runnable {
                        tv_ket.text = "Obesitas"
                    })
                }
            }
        }).start()
    }

    fun handlerThread(){

        val getHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val results = msg.obj as String
                tv_ket.text = results
            }
        }

        Thread(Runnable {
            btn_submit.setOnClickListener {
                val bb = et_bb.text.toString()
                val tb = et_tb.text.toString()
                val tinggi = tb.toInt() / 100
                val hasil = bb.toInt() / (tinggi*tinggi)

                val keterangan = if (hasil < 18.5){
                    "Kurus"
                }else if (hasil >= 18.5 && hasil <= 24.5) {
                     "Normal"

                }else if (hasil >= 25 && hasil <= 29.9) {
                    "Overweight"

                }else{
                     "Obesitas"
                }


                val result = Message.obtain()
                result.obj = keterangan
                result.target = getHandler
                result.sendToTarget()

            }
        }).start()
    }
}