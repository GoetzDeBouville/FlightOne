package com.starbars.search.domain.model

/**
 * Needs for build general diffutil for reusing in all adapters
 */
open class BaseIdentifiable(
    override val id: Any
) : Identifiable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseIdentifiable

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
