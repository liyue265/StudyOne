package com.cont.mystudy.modle

import javax.inject.Inject

data class People @Inject constructor(val name: String, val age: Int)