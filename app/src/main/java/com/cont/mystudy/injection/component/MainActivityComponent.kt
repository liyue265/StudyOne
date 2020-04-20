package com.cont.mystudy.injection.component

import com.cont.mystudy.MainActivity
import com.cont.mystudy.injection.module.MainModule
import dagger.Component

@Component(modules = arrayOf(MainModule::class))
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}