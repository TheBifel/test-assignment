package dev.bifel.testtask.pages.list

import android.view.ViewGroup
import dev.bifel.testtask.R
import dev.bifel.testtask.global.base.BaseRecyclerViewHolder
import dev.bifel.testtask.model.entity.User
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Date: 08.10.2020
 * Time: 19:03
 *
 * @author Bohdan Ishchenko
 */
class UserVH(parent: ViewGroup) :
    BaseRecyclerViewHolder<User>(inflate(R.layout.item_user, parent, false)) {
    override fun bind(data: User) {
        val name = data.name
        val fullName = "${name?.first} ${name?.last}"
        itemView.text_name.text = fullName
    }
}