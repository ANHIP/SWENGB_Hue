package at.fh.swengb.hipfl.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity()
{
    lateinit var db: NotesRoomDatabase
    private val noteAdapter = NoteAdapter()


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val savedName = sharedPreferences.getString("name", null)

        val savedAge = sharedPreferences.getString("age", null)

        userinfo.text = "Notes for " + savedName + ", " + savedAge

        db = NotesRoomDatabase.getDatabase(this)
        recyclerview_notelist.adapter = noteAdapter
        recyclerview_notelist.layoutManager = LinearLayoutManager(this)
    }
    override fun onResume()
    {
        noteAdapter.updateOfList(db.noteDao.getAllStudents())
        super.onResume()
    }

    fun clickAddNote(v: View)
    {
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }


}
