package hasan.gurgur.mysecondretrofitapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import hasan.gurgur.mysecondretrofitapp.data.api.PostService
import hasan.gurgur.mysecondretrofitapp.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PostListViewModel: ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    private val postService : PostService = PostService()
    private val disposable : CompositeDisposable = CompositeDisposable()


    fun fetchDataFromRemoteApi(){

        disposable.add(
            postService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Post>>(){
                    override fun onSuccess(postList: List<Post>) {
                        posts.value = postList
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}