package hasan.gurgur.mysecondretrofitapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import hasan.gurgur.mysecondretrofitapp.R
import hasan.gurgur.mysecondretrofitapp.databinding.ActivityMainBinding
import hasan.gurgur.mysecondretrofitapp.viewmodel.PostListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : PostListViewModel
    private val postListAdapter = PostListAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(PostListViewModel::class.java)
        viewModel.fetchDataFromRemoteApi()

        binding.postList.apply {
            layoutManager =  LinearLayoutManager(this@MainActivity)
            adapter = postListAdapter

        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.posts.observe(this, Observer { postList ->
            postList?.let {
                postListAdapter.updatePostList(postList)
            }

        })
    }
}