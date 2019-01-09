package at.fh.swengb.hipfl.homeexercise2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName= "dbNote")
class Note(@PrimaryKey val title: String, val content: String)