package my.edu.tarc.demosharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import my.edu.tarc.demosharedpref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var bindings: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        //Read shared preference file
        sharedPreferences = getPreferences(MODE_PRIVATE)

        val name = sharedPreferences.getString(NAME, "")
        val phone = sharedPreferences.getString(PHONE, "")

        bindings.apply {
            editTextName.setText(name)
            editTextPhone.setText(phone)
            Log.d("Main", "onCreate")
        }


        bindings.buttonSave.setOnClickListener {
            val name :String = bindings.editTextName.text.toString()
            val phone : String = bindings.editTextPhone.text.toString()

            with(sharedPreferences.edit()){
                putString(NAME, name)
                putString(PHONE, phone)
                apply()
                Toast.makeText(applicationContext, "Record Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {
        const val NAME = "my.edu.tarc.demosharedpref.name"
        const val PHONE = "my.edu.tarc.demosharedpref.phone"
    }
}