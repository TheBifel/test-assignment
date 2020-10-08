package dev.bifel.testtask.pages.list.viewHolder

import android.view.ViewGroup
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.bifel.testtask.R
import dev.bifel.testtask.model.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Date: 08.10.2020
 * Time: 21:37
 *
 * @author Bohdan Ishchenko
 */
class UserViewHolderImpl(parent: ViewGroup) : UserVH(inflate(R.layout.item_user, parent, false)) {
    override fun bind(data: User) {
        val name = data.name
        val fullName = "${name?.first} ${name?.last}"
        itemView.text_name.text = fullName
        itemView.text_phone.text = data.cell
        val context = itemView.context
        Glide.with(itemView)
            .load(data.picture?.medium)
            .placeholder(
                CircularProgressDrawable(context)
                    .apply {
                        strokeWidth = 5f
                        centerRadius = 30f
                        setColorSchemeColors(context.getColor(R.color.colorAccent))
                        start()
                    })
            .apply(RequestOptions().circleCrop())
            .into(itemView.img_user_icon)
    }
}