package dev.bifel.testtask.pages.list.viewholder

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ProgressBar
import dev.bifel.testtask.model.entity.User

/**
 * Date: 08.10.2020
 * Time: 21:33
 *
 * @author Bohdan Ishchenko
 */
class LoadingVH(context: Context) : UserVH(getItemView(context)) {
    override fun bind(data: User) {}
}

fun getItemView(context: Context) = ProgressBar(context).apply {
    val layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    layoutParams.gravity = Gravity.CENTER
    this.layoutParams = layoutParams
}
