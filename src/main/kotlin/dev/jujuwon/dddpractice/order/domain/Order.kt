package dev.jujuwon.dddpractice.order.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "purchase_order")
class Order(
    @EmbeddedId
    val number: OrderNo? = null,

    @Version
    val version: Long = 0,

    @Column(name = "order_date")
    val orderDate: LocalDateTime? = null,

    shippingInfo: ShippingInfo? = null
) {
    @Embedded
    var shippingInfo: ShippingInfo? = shippingInfo
        private set(value) {
            if (value == null) throw IllegalArgumentException("no shipping info")
            field = value
        }

    val isNotYetShipped: Boolean = true // TODO

    private fun verifyNotYetShipped() {
        if (!isNotYetShipped) throw IllegalStateException() // TODO AlreadyShippedException()
    }

    fun cancel() {
        // TODO
    }

    fun changeShippingInfo(newShippingInfo: ShippingInfo) {
        verifyNotYetShipped()
        shippingInfo = newShippingInfo
        // TODO event
    }


}