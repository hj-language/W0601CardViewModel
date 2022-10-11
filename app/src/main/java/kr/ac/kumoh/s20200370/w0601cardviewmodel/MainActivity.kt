package kr.ac.kumoh.s20200370.w0601cardviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20200370.w0601cardviewmodel.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //binding.card1.setImageResource(R.drawable.c_2_of_hearts)
//        val c = Random.nextInt(52)
//        Log.i("Test", "$c : ${getCardName(c)}")
//
//        val res = resources.getIdentifier(
//            getCardName(c),
//            "drawable",
//            packageName
//        )
//
//        binding.card1.setImageResource(res)
        binding.btnDeal.setOnClickListener {
            val c = IntArray(5)
            val res = IntArray(5)

            //for (i in 0..4)
            //for (i in 0 until 5)
            //for (i in 0 until c.size)
            for (i in c.indices) {
                c[i] = Random.nextInt(52)

                Log.i("Test", "${c[i]} : " +
                        "${getCardName(c[i])}")

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }

            //card1.setImageResource(R.drawable.c_2_of_hearts)
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        }
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}