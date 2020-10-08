package dev.bifel.testtask.pages.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import dev.bifel.testtask.R
import dev.bifel.testtask.global.base.BaseActivity
import dev.bifel.testtask.global.base.BaseRecyclerAdapter
import dev.bifel.testtask.model.entity.User
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.standalone.inject

class ListActivity : BaseActivity<ListView>(), ListView {

    private val presenter by inject<ListPresenter>()

    override val content: View
        get() = recycler
    override val progress: View
        get() = progress_bar

    private var adapter = BaseRecyclerAdapter(::UserVH)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        bindPresenter(presenter, this)

        adapter.onItemClickListener = { }
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        presenter.initUsers()
    }

    override fun showUsers(users: List<User>) = adapter.setData(users)
}