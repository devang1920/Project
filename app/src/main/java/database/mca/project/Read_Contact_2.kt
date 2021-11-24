package database.mca.project



import android.content.ContentUris
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.core.app.ActivityCompat

class Read_Contact_2 : AppCompatActivity() {

    lateinit var button: Button
    lateinit var button2: Button
    lateinit var editText1: TextView
    lateinit var editText2: TextView

    var cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID,

        ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_contact2)

        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)

        button2.setOnClickListener {
            var intent = Intent(applicationContext, Read_Contact_1::class.java)
            startActivity(intent)
        }


        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.WRITE_CONTACTS,
                    android.Manifest.permission.READ_CONTACTS
                ),
                111
            )
        } /*else
            writeContacts()*/
        button.setOnClickListener {
            writeContacts()
            editText1.setText("")
            editText2.setText("")
        }
    }


    private fun writeContacts() {
        var cv = ContentValues()
        var rowUri = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, cv)
        var rowContactId = ContentUris.parseId(rowUri!!)

        cv.put(ContactsContract.Data.RAW_CONTACT_ID, rowContactId)
        cv.put(
            ContactsContract.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE
        )
        cv.put(
            ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
            editText1.text.toString()
        )
        contentResolver.insert(ContactsContract.Data.CONTENT_URI, cv)

        cv.put(ContactsContract.Data.RAW_CONTACT_ID, rowContactId)
        cv.put(
            ContactsContract.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE
        )
        cv.put(ContactsContract.CommonDataKinds.Phone.NUMBER, editText2.text.toString())
        contentResolver.insert(ContactsContract.Data.CONTENT_URI, cv)
    }

}

