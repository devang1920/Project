package database.mca.project


import android.content.ContentResolver
import android.content.ContentUris
import android.content.ContentValues
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.Attendees.query
import android.provider.ContactsContract
import android.widget.Adapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class Read_Contact_1 : AppCompatActivity() {

    lateinit var listview1 : ListView
    lateinit var searchView : SearchView

    var cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID,

        ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_contact1)

        listview1 = findViewById(R.id.listview1)
        searchView = findViewById(R.id.searchView)

        //READ_CONTACT
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,Array(1){android.Manifest.permission.READ_CONTACTS},111)
        }
        //WRITE_CONTACT
        //if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED){
        //  ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_CONTACTS,android.Manifest.permission.READ_CONTACTS),111)
        //}
        else
            readContact()
        //  writeContacts()
    }

//    private fun writeContacts() {
//        var cv = ContentValues()
//        var rowUri = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI,cv)
//        var rowContactId = ContentUris.parseId(rowUri!!)
//
//        cv.put(ContactsContract.Data.RAW_CONTACT_ID,rowContactId)
//        cv.put(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
//        cv.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,"Dvang GOhel")
//        contentResolver.insert(ContactsContract.Data.CONTENT_URI,cv)
//
//        cv.put(ContactsContract.Data.RAW_CONTACT_ID,rowContactId)
//        cv.put(ContactsContract.Data.MIMETYPE,ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
//        cv.put(ContactsContract.CommonDataKinds.Phone.NUMBER,9877859687)
//        contentResolver.insert(ContactsContract.Data.CONTENT_URI,cv)
//    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==111 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            readContact()
    }

    private fun readContact() {

        var from = listOf<String>(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER).toTypedArray()

        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

        var rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

        var adapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,rs,from,to,0)

        listview1.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    cols,"${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                    Array(1){"%$p0%"},ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                adapter.changeCursor(rs)
                return false
            }
        })



    }
}