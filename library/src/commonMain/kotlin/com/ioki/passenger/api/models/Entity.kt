package com.ioki.passenger.api.models

public interface Entity {
    public val id: String
    public val version: Int
}

public infix fun Entity.isSameAs(other: Entity): Boolean = id == other.id && version == other.version
