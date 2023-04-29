package uz.muhsinov.irregularverbs.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.muhsinov.irregularverbs.R
import uz.muhsinov.irregularverbs.databinding.ListBinding
import uz.muhsinov.irregularverbs.models.English

class RvAdapter(val context: Context, val rvClick: RvClick, var list: List<English>) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(var itemRv: ListBinding) : RecyclerView.ViewHolder(itemRv.root) {

        fun onBind(english: English, position: Int) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.rv_anim)
            itemView.startAnimation(animation)


            itemRv.type1.text = "  "+list[position].type1
            itemRv.type2.text =list[position].type2
            itemRv.type3.text = list[position].type3
            itemRv.type4.text = list[position].tarjima


            itemRv.volume.setOnClickListener {
                rvClick.onClick(english, itemRv.volume)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(english: English, view: View)
    }

}
