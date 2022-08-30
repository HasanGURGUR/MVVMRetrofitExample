package hasan.gurgur.mysecondretrofitapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.mysecondretrofitapp.R
import hasan.gurgur.mysecondretrofitapp.model.Post

class PostListAdapter(private val postList: ArrayList<Post>):
    RecyclerView.Adapter<PostViewHolder>() {

    fun updatePostList(newUpdatedPosts: List<Post>){
        postList.clear()
        postList.addAll(newUpdatedPosts)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_item,parent,false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.id.text = postList[position].id.toString()
        holder.title.text = postList[position].title
        holder.body.text = postList[position].body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class PostViewHolder(view:View):RecyclerView.ViewHolder(view){

    val id : TextView = view.findViewById(R.id.textView_id)
    val title : TextView = view.findViewById(R.id.textView_title)
    val body : TextView = view.findViewById(R.id.textView_body)

}