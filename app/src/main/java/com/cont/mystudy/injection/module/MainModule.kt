package com.cont.mystudy.injection.module

import com.cont.mystudy.MainActivity
import com.cont.mystudy.modle.People
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providerName(): String {
        return "zhangsan"
    }

    @Provides
    fun providerAge(): Int {
        return 30
    }

    @Provides
    fun provideMainActivity(name: String, age: Int): People {
        return People(name, age)
    }

}