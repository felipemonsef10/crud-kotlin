package com.imepac.crud_kotlin.repository

import com.imepac.crud_kotlin.entity.Usuario
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    // 🚀 Alteração: Busca um usuário e já carrega seus pedidos
    @EntityGraph(attributePaths = ["pedidos"])
    fun findWithPedidosById(id: Long): Usuario?
}
