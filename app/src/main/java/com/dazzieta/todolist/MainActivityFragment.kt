package com.dazzieta.todolist

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dazzieta.todolist.model.TodoItem
import kotlinx.android.synthetic.main.todo_list_item.view.*
import kotlinx.android.synthetic.main.todo_recycler_view.*

/**
 * A placeholder fragment containing a simple view.
 */
class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.todo_recycler_view, container, false)

        val todoRecyclerView = view.findViewById(R.id.todoRecyclerView) as RecyclerView
        todoRecyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = TodoAdapter(todoList = listOf(TodoItem("aaa", 123), TodoItem("bbb", 234)), context = activity)
        todoRecyclerView.adapter = adapter

        return view
    }

    class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(todoItem: TodoItem){
            itemView.todoData.text = todoItem.todo
            itemView.todoTime.text = todoItem.time.toString()
        }
    }

    class TodoAdapter(val todoList: List<TodoItem>, val context: FragmentActivity?) : RecyclerView.Adapter<TodoViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
            return TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_list_item, parent, false))
        }

        override fun getItemCount(): Int {
            return todoList.size
        }

        override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
            holder.bind(todoList.get(position))
        }

    }


}
