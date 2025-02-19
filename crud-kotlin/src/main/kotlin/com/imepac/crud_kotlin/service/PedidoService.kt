package com.imepac.crud_kotlin.service

import com.imepac.crud_kotlin.entity.Pedido
import com.imepac.crud_kotlin.repository.PedidoRepository
import org.springframework.stereotype.Service

@Service
class PedidoService(private val pedidoRepository: PedidoRepository) {

    fun listarPedidos(): List<Pedido> = pedidoRepository.findAll()

    fun buscarPedido(id: Long): Pedido? = pedidoRepository.findById(id).orElse(null)

    fun criarPedido(pedido: Pedido): Pedido = pedidoRepository.save(pedido)

    fun deletarPedido(id: Long): Boolean {
        return if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id)
            true
        } else {
            false
        }
    }


    fun listarPedidosPorUsuario(usuarioId: Long): List<Pedido> {
        return pedidoRepository.findByUsuarioId(usuarioId)
    }
}
