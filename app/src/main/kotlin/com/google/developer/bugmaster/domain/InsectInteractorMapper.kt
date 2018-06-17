package com.google.developer.bugmaster.domain

import android.database.Cursor

interface InsectInteractorMapper<in E, out M> {
    fun map(insectTypesEntity: E): M
    fun map(cursor: Cursor): List<M>
}