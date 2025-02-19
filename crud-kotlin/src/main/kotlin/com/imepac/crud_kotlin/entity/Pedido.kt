package com.imepac.crud_kotlin.entity

import jakarta.persistence.*

@Entity
data class Pedido(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val descricao: String,
    var valorTotal: Double,

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    val usuario: Usuario,

    @ManyToOne
    @JoinColumn(name = "servico_id") // 🔥 Cada pedido tem um serviço associado
    val servico: Servico
)
