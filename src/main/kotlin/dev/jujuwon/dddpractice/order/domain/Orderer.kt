package dev.jujuwon.dddpractice.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.util.*

@Embeddable
class Orderer {
    @Column(name = "orderer_name")
    var name: String? = null
        private set

    protected constructor()

    constructor(name: String?) {
        this.name = name
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        // TODO
        return false
    }

    override fun hashCode(): Int {
        // TODO
        return Objects.hash(name)
    }
}