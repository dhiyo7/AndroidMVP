package dev7.id.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev7.id.myapplication.R
import dev7.id.myapplication.models.User
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserAdapter(
        var users : List<User>, var  context : Context
) : RecyclerView.Adapter<UserAdapter.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_user,parent,false))
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(users[position], context)
    }

    class ViewHolder (itemView : View) :
            RecyclerView.ViewHolder(itemView){
        fun bind(user : User, context: Context){
            itemView.fullname.text = user.name
            itemView.email.text = user.email
        }
    }

}