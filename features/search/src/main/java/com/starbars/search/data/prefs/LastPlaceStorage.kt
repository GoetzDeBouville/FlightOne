package com.starbars.search.data.prefs

internal interface LastPlaceStorage {

    fun get(): String?

    fun save(place: String)
}