package dev.bifel.testtask.global.base

import android.app.Activity
import android.widget.Toast
import org.koin.standalone.KoinComponent

/**
 * Date: 08.10.2020
 * Time: 18:23
 *
 * @author Bohdan Ishchenko
 */
abstract class BaseActivity<VIEW : BaseView>() : Activity(), KoinComponent, BaseView {

    private var presenter: BasePresenter<VIEW>? = null
    private var view: VIEW? = null

    protected fun bindPresenter(presenter: BasePresenter<VIEW>, view: VIEW) {
        this.presenter = presenter
        presenter.bindView(view)
    }

    override fun onResume() {
        super.onResume()
        view?.let { presenter?.bindView(it) }
    }

    override fun onPause() {
        super.onPause()
        presenter?.unbindView()
    }

    override fun showLoading(isLoading: Boolean) {}

    override fun showError(errorMsg: String) =
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
}