package dev.bifel.testtask.global.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.bifel.testtask.pages.list.viewholder.LoadingVH
import java.util.*

open class BaseRecyclerAdapter<DATA, VH : BaseRecyclerViewHolder<DATA>>(private val viewHolderSupplier: (ViewGroup) -> VH) :
    RecyclerView.Adapter<VH>() {

    private var isLoadingAdded: Boolean = false
    val data: MutableList<DATA?> = ArrayList()

    var onItemClickListener: ((DATA) -> Unit)? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): VH =
        if (type == ITEM) viewHolderSupplier(viewGroup) else LoadingVH(viewGroup.context) as VH

    override fun onBindViewHolder(viewHolder: VH, i: Int) {
        data[i]?.let { dataItem ->
            viewHolder.bind(dataItem)
            onItemClickListener?.let {
                viewHolder.setOnItemClickListener { position: Int -> data[position]?.let(it) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == data.size - 1 && isLoadingAdded) LOADING else ITEM
    }

    override fun getItemCount(): Int = data.size

    open fun removeLoadingFooter() {
        if (isLoadingAdded) {
            isLoadingAdded = false
            data.removeLast()
            notifyItemRemoved(data.size)
        }
    }

    open fun addLoadingFooter() {
        if (!isLoadingAdded) {
            isLoadingAdded = true
            data.add(null)
            notifyItemInserted(data.size - 1)
        }
    }

    open fun addAll(list: List<DATA>) {
        val insertPosition = data.size
        data.addAll(list)
        notifyItemRangeInserted(insertPosition, list.size)
    }

    companion object {
        private const val ITEM = 0
        private const val LOADING = 1
    }
}