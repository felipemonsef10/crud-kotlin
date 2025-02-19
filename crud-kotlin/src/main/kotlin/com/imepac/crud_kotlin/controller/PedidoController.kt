package com.imepac.crud_kotlin.controller

import com.imepac.crud_kotlin.entity.Pedido
import com.imepac.crud_kotlin.service.PedidoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pedidos")
class PedidoController(private val pedidoService: PedidoService) {

    @GetMapping
    fun listarPedidos(): List<Pedido> = pedidoService.listarPedidos()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criarPedido(@RequestBody pedido: Pedido): Pedido = pedidoService.criarPedido(pedido)

    @GetMapping("/{id}")
    fun buscarPedido(@PathVariable id: Long): ResponseEntity<Pedido> {
        val pedido = pedidoService.buscarPedido(id)
        return if (pedido != null) ResponseEntity.ok(pedido) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletarPedido(@PathVariable id: Long): ResponseEntity<Void> {
        return if (pedidoService.deletarPedido(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

}
