package at.fh.swengb.hipfl.homeexercise2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save(v: View) {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("name", txt_name.text.toString()).apply()
        sharedPreferences.edit().putString("age", txt_age.text.toString()).apply()
        val intent = Intent(this, NoteListActivity::class.java)
        startActivity(intent)
    }
}
