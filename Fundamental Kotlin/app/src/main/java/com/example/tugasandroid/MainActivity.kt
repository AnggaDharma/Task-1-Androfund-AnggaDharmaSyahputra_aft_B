package com.example.tugasandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tugasandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
  //parselable
    private lateinit var tv:TextView
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)



//parselable
        tv =findViewById(R.id.textView2)
        val usernamee = intent.getParcelableExtra<User>("user")?.username
        val password = intent.getParcelableExtra<User>("user")?.password
        tv.text ="username: $usernamee , password:$password"

        //implicit
        val btnimplicit : Button = findViewById(R.id.btn_implicit)
        btnimplicit.setOnClickListener(this)

        val btnfragment : Button = findViewById(R.id.btn_fragment)
        btnfragment.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_implicit -> {
//                val message = "Belajar implicit"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT,message)
//                intent.type = "text/plain"
//                startActivity(intent)

                val intent = Intent()
                intent.putExtra("History","Anda sudah pernah login")
                setResult(RESULT_OK,intent)
                finish()
            }
            R.id.btn_fragment -> {
                val intent = Intent(this@MainActivity, New_activity::class.java)
                startActivity(intent)
            }
        }

    }
}