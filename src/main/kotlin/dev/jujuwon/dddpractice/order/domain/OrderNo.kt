package dev.jujuwon.dddpractice.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.*

@Embeddable
class OrderNo : Serializable {
    @Column(name = "order_number")
    var number: String? = null
        private set

    protected constructor()

    constructor(number: String?) {
        this.number = number
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null || javaClass != obj.javaClass) return false
        val orderNo = obj as OrderNo
        return number == orderNo.number
    }

    override fun hashCode(): Int {
        return Objects.hash(number)
    }

    companion object {
        fun of(number: String?): OrderNo {
            return OrderNo(number)
        }
    }
}