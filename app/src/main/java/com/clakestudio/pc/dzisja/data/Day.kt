package com.clakestudio.pc.dzisja.data

import java.util.*

data class Day(
    val id: String = UUID.randomUUID().toString(),
    val date: String,
    var note: String,
    var feelings: String
)