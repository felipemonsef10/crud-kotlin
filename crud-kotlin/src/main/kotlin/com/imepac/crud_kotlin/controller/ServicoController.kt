package com.imepac.crud_kotlin.controller

import com.imepac.crud_kotlin.entity.Servico
import com.imepac.crud_kotlin.service.ServicoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/servicos")
class ServicoController(private val service: ServicoService) {

    @GetMapping
    fun listar(): List<Servico> = service.listar()

    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Servico> =
        service.buscar(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun criar(@RequestBody servico: Servico): Servico = service.criarServico(servico)

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody servico: Servico): ResponseEntity<Servico> =
        service.atualizarServico(id, servico)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> =
        if (service.deletarServico(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
}
