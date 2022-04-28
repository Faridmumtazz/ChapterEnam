package mumtaz.binar.chapterenam.pertemuantiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_service.*
import mumtaz.binar.chapterenam.R
import mumtaz.binar.chapterenam.pertemuantiga.service.ServicePlayer

class MainServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_service)

        btn_play.setOnClickListener {
            startService(Intent(this, ServicePlayer::class.java))
        }
        btn_stop.setOnClickListener {
            stopService(Intent(this, ServicePlayer::class.java))
        }
    }
}