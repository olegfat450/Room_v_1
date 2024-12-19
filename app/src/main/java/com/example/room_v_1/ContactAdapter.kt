package com.example.room_v_1
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
class ContactAdapter (private val contact: MutableList<Contact>): RecyclerView.Adapter<ContactAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.name_item)
        val surname = itemView.findViewById<TextView>(R.id.surname_item)
        val phone = itemView.findViewById<TextView>(R.id.phone_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount() = contact.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.name.text = contact[position].name.capitalize()
        holder.surname.text = contact[position].surname.capitalize()

        var ph = contact[position].phone
       if ( ph.isEmpty()) ph = "Тел:   не указан" else ph = "Тел:  +7" + ph
           holder.phone.text = ph
    }

}