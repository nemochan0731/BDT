package com.example.bdt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private lateinit var bDViewModel: bdViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            bdDatabase::class.java, "birthday_database"
//        ).build()
     //   testing.insertDB( DB(1,"asd","asd"))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = bdAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager= LinearLayoutManager(this) as RecyclerView.LayoutManager?
        bDViewModel = ViewModelProvider(this).get(bdViewModel::class.java)
        bDViewModel.allbd.observe(this, Observer {
          adapter.setBDS(it)
        })



        fab.setOnClickListener {

             // newbd.name="ihihi"
              //newbd.dob="asdad"
            //bDViewModel.insertBD(DB(0,"dasdd",12))
            val test:ArrayList<DB> = ArrayList()
            test.add(DB(1,"2",2))

            adapter.setBDS(test)

           // val intent = Intent(this , AddActivity::class.java)
         //   startActivityForResult(intent , REQUEST_CODE)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      //  super.onActivityResult(requestCode, resultCode, data)
        if(requestCode ==REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK) {
                val _name: String? = data?.getStringExtra(AddActivity.EXTRA_NAME)
                val _dob: Long? = data?.getLongExtra(AddActivity.EXTRA_DOB,0)
                val bd: DB = DB(id = 0, name = _name!!, dob = _dob!!)


            }

        }

super.onActivityResult(requestCode, resultCode, data)
    }


companion object{
    const val REQUEST_CODE = 1

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
}
