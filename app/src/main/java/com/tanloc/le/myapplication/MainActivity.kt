package com.tanloc.le.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tanloc.le.myapplication.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.displayfragment.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var model = ViewModelProviders.of(this).get(MainViewModel::class.java);

        var mng = supportFragmentManager.beginTransaction();
        mng.add(R.id.fra_container, DisplayFragment());
        mng.addToBackStack("fragment")
        mng.commit();

        val random = Random(10);

        button.setOnClickListener {
            model.data.value = txtField.text.toString()
        }
        button2.setOnClickListener {

            model.data2.value = random.nextInt().toString()
        }

//        dashboardViewModel =
//            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
/*  var model = ViewModelProviders.of(this).get(MainViewModel::class.java);
  var nameObserver = Observer<String> {
      textView.text = it;
  }
  // update livedata
  model.currentName.observe(this, nameObserver)
*/
//        val navController = findNavController(R.id.nav_host_fragment)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//        button.setOnClickListener {
//            var edt = editText.text.toString();
//
//            model.currentName.postValue(edt);
//        }
    }
}
