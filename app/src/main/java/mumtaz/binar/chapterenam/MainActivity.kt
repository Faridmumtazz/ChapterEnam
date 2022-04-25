package mumtaz.binar.chapterenam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.chapterenam.pertemuansatu.latihansatu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//        contohHandlerThread()
        contohHt()
    }

    fun contohThereadSatu (){
        Thread(Runnable {
            btn_change.setOnClickListener {
                tv_satu.post(Runnable {
                    tv_satu.text = "Hello Binar Academy"
                })
            }
            tv_satu.post(Runnable {
                tv_satu.text = "Hello World"
            })
            tv_dua.postDelayed(Runnable {
                tv_dua.text = "Welcome"
            }, 2000)
        }).start()
    }

    fun contohHandler(){
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, latihansatu::class.java))
        },3000)

        Handler().post(Runnable {
            tv_dua.setText("helooooo")
        })
    }

    fun contohHandlerThread(){
       val handler = object : Handler(Looper.getMainLooper()){
           override fun handleMessage(msg: Message) {
               super.handleMessage(msg)
               val pesan2 = msg.obj as String
               tv_dua.text = pesan2
           }
       }

        Thread(Runnable {
            val a = "Contoh Handler Thread"
            val pesan = Message.obtain()
            pesan.obj = a
            pesan.target = handler
            pesan.sendToTarget()
        }).start()
    }

    fun contohHt(){

        val targetHandler = object  : Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val a = msg.obj as String
                tv_satu.text = a
            }
        }

        Thread(Runnable {

            btn_change.setOnClickListener {
                val a = Message.obtain()
                a.obj = "qwerty"
                a.target = targetHandler
                a.sendToTarget()
            }
        }).start()
    }
}