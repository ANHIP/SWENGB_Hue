package at.fh.swengb.hipfl.homeexercise2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {
    var noteList = listOf<Note>()
    fun updateList(list: List<Note>) {
        noteList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val student = noteList[position]
        viewHolder.bindItem(student)
    }

}

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(note: Note) {
        itemView.txt_Content.text = note.content
        itemView.txt_Title.text = note.title
    }
}