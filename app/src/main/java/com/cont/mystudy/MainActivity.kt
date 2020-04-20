package com.cont.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cont.mystudy.injection.component.DaggerMainActivityComponent
import com.cont.mystudy.injection.module.MainModule
import com.cont.mystudy.modle.People
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var mPeople: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder().mainModule(MainModule()).build().inject(this)

        Log.i(TAG, mPeople.toString())
    }
}
