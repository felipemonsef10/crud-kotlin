package com.imepac.crud_kotlin.controller

import com.imepac.crud_kotlin.entity.Usuario
import com.imepac.crud_kotlin.entity.Pedido
import com.imepac.crud_kotlin.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController (private val service: UsuarioService) {

    @GetMapping
    fun listar(): List<Usuario> = service.listar()

    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Usuario> = service.buscar(id)
        ?.let { ResponseEntity.ok(it) }
        ?: ResponseEntity.notFound().build()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody usuario: Usuario): Usuario = service.criarUsuario(usuario)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody usuario: Usuario): ResponseEntity<Usuario> = service.atualizaUsuario(id, usuario)
        ?.let { ResponseEntity.ok(it) }
        ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.deletarUsuario(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // 🚀 Novo endpoint para buscar pedidos de um usuário
    @GetMapping("/{id}/pedidos")
    fun listarPedidos(@PathVariable id: Long): ResponseEntity<List<Pedido>> {
        val pedidos = service.listarPedidosPorUsuario(id)
        return if (pedidos.isNotEmpty()) ResponseEntity.ok(pedidos) else ResponseEntity.notFound().build()
    }
}