package dev.bifel.testtask.global.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

open class BaseRecyclerAdapter<DATA, VH : BaseRecyclerViewHolder<DATA>>(private val viewHolderSupplier: (ViewGroup) -> VH) :
    RecyclerView.Adapter<VH>() {

    val data: MutableList<DATA> = ArrayList()

    var onItemClickListener: ((DATA) -> Unit)? = null

    var lastLoadedListener: (Int) -> Unit = {}

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): VH =
        viewHolderSupplier(viewGroup)

    override fun onBindViewHolder(viewHolder: VH, i: Int) {
        viewHolder.bind(data[i])
        onItemClickListener?.let {
            viewHolder.setOnItemClickListener { position: Int -> it(data[position]) }
        }
        if (i == data.size - 1) {
            lastLoadedListener(i)
        }
    }

    override fun getItemCount(): Int = data.size

    fun add(dataType: DATA) {
        data.add(dataType)
        notifyItemInserted(data.size - 1)
    }

    fun add(position: Int, dataType: DATA) {
        data.add(position, dataType)
        notifyItemInserted(position)
    }

    open fun addAll(list: List<DATA>) {
        val insertPosition = data.size
        data.addAll(list)
        notifyItemRangeInserted(insertPosition, list.size)
    }

    fun addAll(position: Int, list: List<DATA>) {
        data.addAll(position, list)
        notifyItemRangeInserted(position, list.size)
    }

    fun delete(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun delete(data: DATA) = delete(this.data.indexOf(data))

    fun update(adapterPosition: Int, newData: DATA) {
        data[adapterPosition] = newData
        notifyItemChanged(adapterPosition)
    }

    fun setData(list: List<DATA>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        val count = data.size
        data.clear()
        notifyItemRangeRemoved(0, count)
    }

    fun getItemAt(position: Int): DATA {
        return data[position]
    }
}