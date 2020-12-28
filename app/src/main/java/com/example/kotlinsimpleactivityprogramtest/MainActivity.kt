package com.example.kotlinsimpleactivityprogramtest

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.Manifest
import android.net.Uri
import android.provider.MediaStore
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : BaseActivity() {
    private val url = "https://web.law.duke.edu/cspd/contest/videos/Framed-Contest_Documentaries-and-You.mp4"
    private lateinit var mp : MediaController
    private lateinit var vV :VideoView
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        mp = MediaController(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        vV = findViewById(R.id.videoView)
        var uri = Uri.parse(url)
        vV.setVideoURI(uri)
        requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.BLUETOOTH),  100)

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            if(vV.isPlaying){
                vV.pause()
                count++
            }else{
                vV.start()
                count--
            }
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode ==1){

        }else if(requestCode==100){}

        // switch in java
        when(requestCode){
            1 ->{// show map //
            }
            2->{
                // take order
            }
            100 ->{
                // display files
            }
            else -> {
                // other permission
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}open class A(var name:String){

    open fun modifyState(a : Int){
        name = "play"
    }
}