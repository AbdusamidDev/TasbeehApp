package developer.abdusamid.tasbeeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tasbeh_Count()
    }

    private fun tasbeh_Count() {
        val sharedPreferences = getSharedPreferences("nomi", MODE_PRIVATE)
        val edit = sharedPreferences.edit()

        val h: String = sharedPreferences.getString("key", zikr_number.text.toString()).toString()
        zikr_number.text = h

        tasbeeh_click.setOnClickListener {
            val a = zikr_number.text.toString().toInt() + 1
            edit.putString("key", a.toString())
            edit.commit()

            val h: String = sharedPreferences.getString("key", a.toString()).toString()
            zikr_number.text = h
        }
        restart.setOnClickListener {
            count = 0
            zikr_number.text = count.toString()
            edit.putString("key", count.toString())
            edit.commit()
        }
    }
}