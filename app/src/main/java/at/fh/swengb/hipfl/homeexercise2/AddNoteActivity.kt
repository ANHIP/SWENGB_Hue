package at.fh.swengb.hipfl.homeexercise2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        db = NotesRoomDatabase.getDatabase(this)
    }

    lateinit var db: NotesRoomDatabase


    fun saveNote(v: View) {val note = Note(txt_Title.text.toString(), txt_Content.text.toString())
        db.noteDao.insert(note)

        finish()
    }
}
