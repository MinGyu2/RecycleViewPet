package mq.mqandroidworld.recycleviewpet

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mq.mqandroidworld.recycleviewpet.databinding.DataListItemPetBinding

class PetDataAdapter(private val dataArray:ArrayList<Pet>, private val context:Context,
                     val itemSelect: (Pet) -> Unit):RecyclerView.Adapter<PetDataAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(DataListItemPetBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataArray[position],context)
    }
    override fun getItemCount() = dataArray.size
    inner class ViewHolder(private val binding:DataListItemPetBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(pet:Pet, context:Context){
            binding.apply {
                pet.let {
                    if (pet.photo != ""){
                        val resourceId = context.resources.getIdentifier(
                            pet.photo,
                            "drawable",
                            context.packageName
                        )
                        imgPet.setImageResource(resourceId)
                    }else{
                        imgPet.setImageResource(R.mipmap.ic_launcher)
                    }
                    tvAge.text = it.age
                    tvBreed.text = it.breed
                    tvGender.text = it.gender
                }
            }
            binding.root.setOnClickListener { itemSelect(pet) }
        }
    }
}