package mumtaz.binar.chapterenam.pertemuansatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_latihansatu.*
import mumtaz.binar.chapterenam.R

class latihansatu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihansatu)
        thread()
    }

    fun thread(){
        Thread(Runnable {
            btn_hitung.setOnClickListener {
                val nama = et_nama.text.toString()
                val umur = et_umur.text.toString()
                val hasil = 2022 - umur.toInt()

                tv_nama.post(Runnable {
                    tv_nama.text = nama
                })
                tv_umur.post(Runnable {
                    tv_umur.text = hasil.toString()
                })
            }
        }).start()

    }
}