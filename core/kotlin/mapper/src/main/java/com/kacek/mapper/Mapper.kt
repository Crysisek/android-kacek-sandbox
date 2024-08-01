package com.kacek.mapper

interface Mapper<in T, out R> {
    fun map(param: T): R
}
