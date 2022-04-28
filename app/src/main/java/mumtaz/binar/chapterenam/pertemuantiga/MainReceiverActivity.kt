package mumtaz.binar.chapterenam.pertemuantiga

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mumtaz.binar.chapterenam.R
import mumtaz.binar.chapterenam.pertemuantiga.receiver.AirplaneModeReceiver

class MainReceiverActivity : AppCompatActivity() {

    lateinit var receiv : AirplaneModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_receiver)

        receiv = AirplaneModeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiv, it)
        }
    }
}