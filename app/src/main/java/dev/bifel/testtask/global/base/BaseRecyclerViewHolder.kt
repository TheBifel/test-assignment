package dev.bifel.testtask.global.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<DATA>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(data: DATA)

    fun setOnItemClickListener(onItemClickListener: (Int) -> Unit) {
        itemView.setOnClickListener {
            onItemClickListener(adapterPosition)
        }
    }

    companion object {
        @JvmStatic
        fun inflate(@LayoutRes resource: Int, root: ViewGroup, attachToRoot: Boolean): View =
            LayoutInflater.from(root.context).inflate(resource, root, attachToRoot)
    }
}