package com.imepac.crud_kotlin.controller

import com.imepac.crud_kotlin.entity.Endereco
import com.imepac.crud_kotlin.service.EnderecoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/enderecos")
class EnderecoController(private val service: EnderecoService) {

    @GetMapping
    fun listar(): List<Endereco> = service.listar()

    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Endereco> =
        service.buscar(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun criar(@RequestBody endereco: Endereco): Endereco = service.criarEndereco(endereco)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody endereco: Endereco): ResponseEntity<Endereco> =
        service.atualizarEndereco(id, endereco)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> =
        if (service.deletarEndereco(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
}
