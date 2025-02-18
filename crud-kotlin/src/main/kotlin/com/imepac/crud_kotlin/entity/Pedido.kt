package com.imepac.crud_kotlin.entity

import jakarta.persistence.*

@Entity
data class Pedido(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val descricao: String,
    val valorTotal: Double,

    @ManyToOne(fetch = FetchType.LAZY)  // Muitos pedidos para um usuário
    @JoinColumn(name = "usuario_id")  // Define a coluna de chave estrangeira no banco
    val usuario: Usuario
)
