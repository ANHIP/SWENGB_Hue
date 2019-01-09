package at.fh.swengb.hipfl.homeexercise2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface NoteDao
{
    @Insert
    fun insert(student: Note)
    @Update
    fun update(student: Note)
    @Query("DELETE FROM dbNote")
    fun deleteAllStudents()
    @Query("SELECT * FROM dbNote")
    fun getAllStudents(): List<Note>
}