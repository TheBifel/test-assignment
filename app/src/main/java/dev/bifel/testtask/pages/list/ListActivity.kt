package dev.bifel.testtask.pages.list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.bifel.testtask.R
import dev.bifel.testtask.global.base.BaseActivity
import dev.bifel.testtask.global.base.BaseRecyclerAdapter
import dev.bifel.testtask.global.common.DEFAULT_PAGE_SIZE
import dev.bifel.testtask.model.entity.User
import dev.bifel.testtask.pages.list.viewHolder.UserViewHolderImpl
import dev.bifel.testtask.pages.person.PersonActivity
import kotlinx.android.synthetic.main.activity_list.*
import org.koin.standalone.inject


class ListActivity : BaseActivity<ListView>(), ListView {

    private val presenter by inject<ListPresenter>()

    private var adapter = BaseRecyclerAdapter(::UserViewHolderImpl)

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        val layoutManager = LinearLayoutManager(this@ListActivity)
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val visibleItemCount: Int = layoutManager.childCount
            val totalItemCount: Int = layoutManager.itemCount
            val firstVisibleItemPosition: Int = layoutManager.findFirstVisibleItemPosition()
            if (!presenter.isLoading) {
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0 && totalItemCount >= DEFAULT_PAGE_SIZE
                ) {
                    presenter.loadMoreUsers()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        bindPresenter(presenter, this)

        adapter.onItemClickListener = { PersonActivity.launch(this, it) }
        recycler.adapter = adapter
        recycler.layoutManager = recyclerViewOnScrollListener.layoutManager
        recycler.addOnScrollListener(recyclerViewOnScrollListener)
        presenter.initUsers()
    }

    override fun showUsers(users: List<User>) {
        adapter.removeLoadingFooter()
        adapter.addAll(users)
    }

    override fun showLoading(isLoading: Boolean) {
        if (isLoading) adapter.addLoadingFooter() else adapter.removeLoadingFooter()
    }
}