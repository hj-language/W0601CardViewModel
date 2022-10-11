package kr.ac.kumoh.s20200370.w0601cardviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// 기본 Constructor를 쓰는 ViewModel 상속
class CardViewModel: ViewModel() {
    private var _cards = MutableLiveData<IntArray>()
    val cards: LiveData<IntArray>
        get() = _cards  // getter

    val random = Random(System.currentTimeMillis())
    // 개발할 때는 100 처럼 따로 값을 세팅해놓고 하는 것이 좋음

    fun deal() {
        var c = IntArray(5, {-1})
        var temp = 0
        for (i in 0 until c.size) {
            while (c.contains(temp))
                temp = Random.nextInt(52)
            c[i] = temp
        }
        _cards.value = c
    }
}