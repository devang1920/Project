package database.mca.project

import android.content.DialogInterface
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Contact_Provider : AppCompatActivity() {

    lateinit var lv: ListView
    lateinit var db: SQLiteDatabase
    lateinit var rs: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_provider)
        title = "PROJECT"

        var helper = MyHelper(applicationContext)
        db = helper.writableDatabase

        rs = db.rawQuery("SELECT * FROM NOTES",null)
        lv = findViewById<ListView>(R.id.listview1)
        var adapter = SimpleCursorAdapter(this,
            R.layout.mylayout,
            rs,
            arrayOf("TITLE","DESCRIPTION","UPDATEDON"),
            intArrayOf(R.id.text1,R.id.text3,R.id.text2),0)
        lv.adapter = adapter

        registerForContextMenu(lv)
    }

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(0, 101, 0, "UPDATE")
        menu?.add(0, 102, 1, "DELETE")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            101 ->
            {
                intent = Intent(applicationContext,Update::class.java)
                intent.putExtra("id",rs.getString(0))
                startActivity(intent)
            }
            102 ->{
                db.delete("NOTES","_id=?", arrayOf(rs.getString(0)))
                rs.requery()
                AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("Deleted Successfully..")
                    .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()
            }
        }
        finish()
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1000,100,0,"Add User")

        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            100 -> {startActivity(Intent(applicationContext,AddNotes::class.java))}
        }
        return super.onOptionsItemSelected(item)
    }
}