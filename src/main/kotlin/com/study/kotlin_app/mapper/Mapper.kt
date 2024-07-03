package com.study.kotlin_app.mapper

interface Mapper<T, U> {

    fun map(t: T): U

//    fun mapTo(u: U): T

}