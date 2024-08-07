package dev.jujuwon.dddpractice.order.domain

import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, OrderNo> {
}