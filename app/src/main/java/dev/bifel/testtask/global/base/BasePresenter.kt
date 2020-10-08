package dev.bifel.testtask.global.base

import dev.bifel.testtask.model.repo.Repository
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

/**
 * Date: 08.10.2020
 * Time: 18:18
 *
 * @author Bohdan Ishchenko
 */
abstract class BasePresenter<VIEW : BaseView> : KoinComponent {
    protected val repository by inject<Repository>()
    protected var view: VIEW? = null
    var compositeDisposable: CompositeDisposable? = null

    fun bindView(view: VIEW) {
        compositeDisposable = CompositeDisposable()
        this.view = view
    }

    fun unbindView() {
        if (compositeDisposable != null && compositeDisposable?.isDisposed == false) {
            compositeDisposable?.dispose()
        }
        this.view = null
    }
}

fun Disposable.register(presenter: BasePresenter<*>) {
    presenter.compositeDisposable?.add(this)
}

fun <T> Single<T>.toAsync(subscribeScheduler: Scheduler = Schedulers.io()): Single<T> =
    subscribeOn(subscribeScheduler)
        .observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.showLoading(view: BaseView?, isLoading: (Boolean) -> Unit = {}): Single<T> =
    doOnSubscribe {
        view?.showLoading(true)
        isLoading(true)
    }.doAfterTerminate {
        view?.showLoading(false)
        isLoading(false)
    }

fun <T> Single<T>.subscribe(
    view: BaseView?,
    callback: (T) -> Unit = {}
): Disposable =
    subscribe(Consumer(callback)) {
        it.printStackTrace()
        view?.showError(it.localizedMessage ?: "Error")
    }