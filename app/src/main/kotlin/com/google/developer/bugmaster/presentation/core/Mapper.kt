package com.google.developer.bugmaster.presentation.core

interface Mapper<in I, out O> {
    fun map(item: I): O
}
