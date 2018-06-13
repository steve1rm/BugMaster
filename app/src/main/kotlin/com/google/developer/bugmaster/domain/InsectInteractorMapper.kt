package com.google.developer.bugmaster.domain

import android.database.Cursor

interface InsectInteractorMapper<E, M> {
    fun map(insectTypesEntity: E): M
    fun map(cursor: Cursor): MutableList<M>
}