package mq.mqandroidworld.recycleviewpet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mq.mqandroidworld.recycleviewpet.databinding.DataListItemBinding

class DataAdapter(val dataArray: ArrayList<String>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    // 목록 개수 반환
    override fun getItemCount(): Int {
        return dataArray.size
    }
    // 뷰를 띄움
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    // ArrayList의 각 데이터를 바인드
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvItem.text = dataArray[position]
    }

    // 데이터를 로드해 보여주기위한 뷰 홀더
    // 바인딩된 뷰의 각 항목을 가져오기 위한 것 이다.
    inner class ViewHolder(val binding:DataListItemBinding):RecyclerView.ViewHolder(binding.root)
}