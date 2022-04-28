package mumtaz.binar.chapterenam.pertemuandua

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_async_task.*
import mumtaz.binar.chapterenam.R

@Suppress("DEPRECATION")
class AsyncTaskActivity : AppCompatActivity() {
    lateinit var cont : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        cont = this

        btn_proses.setOnClickListener {
            contohAsyncTask().execute()
        }


    }

    inner class contohAsyncTask : AsyncTask<Int, Void, String>(){

        lateinit var pdialog : ProgressDialog

        override fun onPreExecute() {
            super.onPreExecute()
            pdialog = ProgressDialog(cont)
            pdialog.show()
        }

        override fun doInBackground(vararg p0: Int?): String {
            val berat = bb_et.text.toString()
            val tinggi = tb_et.text.toString()
            val tb = tinggi.toInt() / 100
            val hasil = berat.toInt() / (tb*tb)
            var output = ""

            if (hasil < 18.5){
                output = "Berat Badan Kurang"
            }else if (hasil >= 18.5 && hasil <= 24.5) {
                output = "Berat Badan Ideal"

            }else if (hasil >= 25 && hasil <= 29.9) {
                output = "Berat Badan Overweight"

            }else if (hasil >= 30 && hasil <= 39.9){
                output ="Berat Badan Obesitas"
            }else{
                output = "Berat Badan Gemuk Sekali"
            }

            return output
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tvHasil.text = result
            pdialog.dismiss()
            bb_et.setText("")
            tb_et.setText("")
        }

    }
}