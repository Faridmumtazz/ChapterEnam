package mumtaz.binar.chapterenam.pertemuantiga.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {

        val modepengembang = p1?.getBooleanExtra("state", false)

        if(modepengembang == true){
            Toast.makeText(p0, "Mode Pengembang Aktif", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(p0, "Mode Pengembang Tidak Aktif", Toast.LENGTH_LONG).show()
        }
    }

}