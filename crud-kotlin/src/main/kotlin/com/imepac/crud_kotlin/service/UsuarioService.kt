package com.imepac.crud_kotlin.service

import com.imepac.crud_kotlin.entity.Usuario
import com.imepac.crud_kotlin.entity.Pedido
import com.imepac.crud_kotlin.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val usuarioRepository: UsuarioRepository) {
    fun listar(): List<Usuario> = usuarioRepository.findAll()

    fun buscar(id: Long): Usuario? = usuarioRepository.findById(id).orElse(null)

    fun criarUsuario(usuario: Usuario): Usuario {
        usuario.calcularValorTotal()
        return usuarioRepository.save(usuario)
    }

    fun atualizaUsuario(id: Long, usuario: Usuario): Usuario? {
        val usuarioExistente = usuarioRepository.findById(id).orElse(null) ?: return null
        val usuarioAtualizado = usuarioExistente.copy(
            nome = usuario.nome,
            email = usuario.email,
            valorCompra = usuario.valorCompra,
            valorDesconto = usuario.valorDesconto
        )
        usuarioAtualizado.calcularValorTotal()
        return usuarioRepository.save(usuarioAtualizado)
    }

    fun deletarUsuario(id: Long): Boolean {
        return if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id)
            true
        } else {
            false
        }
    }

    // 🚀 Novo método: Retorna os pedidos de um usuário específico
    fun listarPedidosPorUsuario(id: Long): List<Pedido> {
        val usuario = usuarioRepository.findWithPedidosById(id)
        return usuario?.pedidos ?: emptyList()
    }
}
