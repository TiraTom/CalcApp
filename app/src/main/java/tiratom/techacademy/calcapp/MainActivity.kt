package tiratom.techacademy.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        divideButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.plusButton -> plus()
            R.id.minusButton -> minus()
            R.id.multiplyButton -> multiply()
            R.id.divideButton -> devide()
        }
    }

    private fun plus(){
        // TODO: 計算


        moveToResultView()
    }

    private fun minus(){
        // TODO: 計算


        moveToResultView()
    }

    private fun multiply(){
        // TODO: 計算


        moveToResultView()
    }

    private fun devide(){
        // TODO: 計算


        moveToResultView()
    }



    private fun moveToResultView(result: Float){
        // 　TODO:結果ページに遷移


    }
}
