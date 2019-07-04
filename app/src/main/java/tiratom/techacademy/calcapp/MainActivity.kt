package tiratom.techacademy.calcapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_LONG
import android.view.inputmethod.InputMethodManager


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 四則演算のボタン押下時の処理設定
        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        multiplyButton.setOnClickListener(this)
        divideButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        // キーボードを閉じる
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)

        // 入力値の保持用変数の宣言
        val param1Val: Float
        val param2Val: Float

        // 入力していない項目があればSnackBarでエラーメッセージを出して計算は行わない
        if (param1.text.isEmpty() || param2.text.isEmpty()) {
            Snackbar.make(v, "入力していない欄があります", LENGTH_LONG).show()
            return
        }

        // 入力値の取得
        try {
            param1Val = param1.text.toString().toFloat()
            param2Val = param2.text.toString().toFloat()

        } catch (ex: NumberFormatException) {
            moveToResultView(null)
            return
        }


        // 押したボタンに応じた四則演算を行い、結果の値を保持した状態で画面遷移用のメソッド呼び出しを行う
        when (v.id) {
            // 足し算
            R.id.plusButton -> moveToResultView(param1Val + param2Val)
            // 引き算
            R.id.minusButton -> moveToResultView(param1Val - param2Val)
            // 掛け算
            R.id.multiplyButton -> moveToResultView(param1Val * param2Val)
            // 割り算
            R.id.divideButton ->
                    // 0で割った時の対処処理
                (
                        if (param2Val == 0F) {
                            moveToResultView(null)
                        } else {
                            moveToResultView(param1Val / param2Val)
                        })
        }

    }

    // 結果画面遷移用メソッド
    // 計算エラー時はnullで渡す
    private fun moveToResultView(result: Float?) {
        val intent = Intent(this, ShowResultActivity::class.java)
        intent.putExtra("RESULT", result?.toString())
        startActivity(intent)

    }
}
