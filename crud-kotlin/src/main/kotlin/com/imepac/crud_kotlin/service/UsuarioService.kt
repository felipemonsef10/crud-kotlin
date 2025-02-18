package com.imepac.crud_kotlin.service

import com.imepac.crud_kotlin.entity.Usuario
import com.imepac.crud_kotlin.repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) {
    fun listar(): List<Usuario> = usuarioRepository.findAll()

    fun buscar(@PathVariable id: Long): Usuario? = usuarioRepository.findById(id).orElse(null)

    fun criarUsuario(usuario: Usuario): Usuario {
        usuario.calcularValorTotal() //Calcula o valor total antes de salvar
        return usuarioRepository.save(usuario)
    }

    fun atualizaUsuario(id: Long, usuario: Usuario): Usuario? {
        val usuarioExistente = usuarioRepository.findById(id).orElse(null) ?: return null
        val usuarioAtualizado = usuarioExistente.copy(
            nome = usuario.nome,
            email = usuario.email, valorCompra = usuario.valorCompra,
            valorDesconto = usuario.valorDesconto
        )
        usuarioAtualizado.calcularValorTotal() // Recalcula o valor total
        return usuarioRepository.save(usuarioAtualizado)
    }
}