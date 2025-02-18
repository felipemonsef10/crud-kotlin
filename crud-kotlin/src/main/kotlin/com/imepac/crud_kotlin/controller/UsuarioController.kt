package com.imepac.crud_kotlin.controller

import com.imepac.crud_kotlin.entity.Usuario
import com.imepac.crud_kotlin.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

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


    // @DeleteMapping("/{id}")
    // fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
    //    service.deletar(id)
    //}

}


