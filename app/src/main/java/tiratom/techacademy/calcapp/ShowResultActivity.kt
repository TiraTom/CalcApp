package tiratom.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_result.*

class ShowResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_result)

        // TODO エラーなら”ERROR"と表示させたい
        resultTextView.text = intent.getIntExtra("RESULT", null)?.toString() :? "ERROR"
    }
}
