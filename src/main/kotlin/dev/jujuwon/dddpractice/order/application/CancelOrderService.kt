package dev.jujuwon.dddpractice.order.application

import dev.jujuwon.dddpractice.order.domain.OrderNo
import dev.jujuwon.dddpractice.order.domain.OrderRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CancelOrderService(
    private val orderRepository: OrderRepository
) {

    @Transactional
    fun cancelOrder(orderNo: OrderNo) {
        val order = orderRepository.findByIdOrNull(orderNo) ?: throw NotFoundException()
        order.cancel()
    }
}