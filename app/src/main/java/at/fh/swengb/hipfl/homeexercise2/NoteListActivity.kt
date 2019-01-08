package at.fh.swengb.hipfl.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {
    private val noteAdapter = NoteAdapter()
    lateinit var db: NotesRoomDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("name", null)
        val savedAge = sharedPreferences.getString("age", null)

        userinfo.text = "Notes for " + savedName + if (!savedAge.isNullOrBlank()) ", " + savedAge else ""
        db = NotesRoomDatabase.getDatabase(this)
        recyclerview_notelist.adapter = noteAdapter
        recyclerview_notelist.layoutManager = LinearLayoutManager(this)
    }

    fun startAddNoteActivity(v: View) {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        noteAdapter.updateList(db.noteDao.findAll())
        super.onResume()
    }
}
