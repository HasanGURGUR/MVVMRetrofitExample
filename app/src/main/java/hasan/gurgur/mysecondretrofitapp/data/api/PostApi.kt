package hasan.gurgur.mysecondretrofitapp.data.api

import hasan.gurgur.mysecondretrofitapp.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPosts(): Single<List<Post>>
}