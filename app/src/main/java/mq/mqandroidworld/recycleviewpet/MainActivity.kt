package mq.mqandroidworld.recycleviewpet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mq.mqandroidworld.recycleviewpet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val dataArray:ArrayList<String> = ArrayList()
    private val petDataArray = arrayListOf<Pet>(
        Pet("고양이0", "암컷", "12", "cat2"),
        Pet("고양이1", "암컷", "1", "cat3"),
        Pet("고양이2", "암컷", "13", "download"),
        Pet("고양이3", "암컷", "1243", "cat2"),
        Pet("고양이4", "암컷", "63", "cat2"),
        Pet("고양이5", "암컷", "3", "download"),
        Pet("고양이0", "암컷", "12", "cat2"),
        Pet("고양이1", "암컷", "1", "cat3"),
        Pet("고양이2", "암컷", "13", "download"),
        Pet("고양이3", "암컷", "1243", "cat2"),
        Pet("고양이4", "암컷", "63", "cat2"),
        Pet("고양이5", "암컷", "3", "download"),
        Pet("고양이0", "암컷", "12", "cat2"),
        Pet("고양이1", "암컷", "1", "cat3"),
        Pet("고양이2", "암컷", "13", "download"),
        Pet("고양이3", "암컷", "1243", "cat2"),
        Pet("고양이4", "암컷", "63", "cat2"),
        Pet("고양이5", "암컷", "3", "download"))

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        addDataArray()  // 배열 나열
//        binding.rvDataList.layoutManager = LinearLayoutManager(this)    // 레이아웃 매니저 생성
//        binding.rvDataList.adapter = DataAdapter(dataArray)   //DataAdapter 작성 예정
        binding.rvDataList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)    //RecycleView 크기 재구성 방지
            adapter = PetDataAdapter(petDataArray,this@MainActivity){
                Toast.makeText(this@MainActivity,"품종: ${it.breed}, 나이 ${it.age}",Toast.LENGTH_SHORT).show()
            }
        }

        
    }

    private fun addDataArray() {
        dataArray.apply {
            repeat(5){
                add("사자")
                add("호랑이")
                add("허경언")
                add("고양이")
                add("코난")
                add("미란이")
                add("홍장미")
                add("강아지")
                add("멍멍이")
            }
        }
    }
}