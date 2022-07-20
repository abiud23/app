package com.example.calculatorintentweb

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.provider.MediaStore
import androidx.core.app.ActivityCompat

import android.content.pm.PackageManager

import androidx.core.content.ContextCompat







class IntentActivity : AppCompatActivity() {

    lateinit var Buttonsms:Button
    lateinit var Buttonemail:Button
    lateinit var Buttonshare:Button
    lateinit var Buttoncamera:Button
    lateinit var Buttonmpesa:Button
    lateinit var Buttoncall:Button
    lateinit var Buttondial:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        Buttonsms = findViewById(R.id.Btn_sms)
        Buttonemail = findViewById(R.id.Btn_email)
        Buttonshare = findViewById(R.id.Btn_share)
        Buttoncamera = findViewById(R.id.Btn_camera)
        Buttonmpesa = findViewById(R.id.Btn_stk)
        Buttoncall = findViewById(R.id.Btn_call)
        Buttondial =findViewById(R.id.Btn_dial)

        Buttonsms!!.setOnClickListener {
            var uri = Uri.parse("smsto:0717419406")
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "How are you doing today.How is the weather?")
            startActivity(intent)
        }

        Buttonemail!!.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc09@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        Buttonshare!!.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        Buttoncamera!!.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        Buttonmpesa!!.setOnClickListener {
            val mpesaIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            mpesaIntent?.let { startActivity(it) }
        }

        Buttoncall!!.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))

            if (ContextCompat.checkSelfPermission(
                    this@IntentActivity,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
        }
        Buttondial!!.setOnClickListener {
            val phone = "+34666777888"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)


        }
        }
    }
