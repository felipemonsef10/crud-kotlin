package com.imepac.crud_kotlin.repository

import com.imepac.crud_kotlin.entity.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository : JpaRepository<Pedido, Long> {
    fun findByUsuarioId(usuarioId: Long): List<Pedido> // 🚀 Busca pedidos por usuário
}
