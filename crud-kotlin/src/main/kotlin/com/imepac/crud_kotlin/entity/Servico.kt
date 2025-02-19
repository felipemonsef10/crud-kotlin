
package com.imepac.crud_kotlin.entity

import jakarta.persistence.*

@Entity
data class Servico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val descricao: String,
    val valorServico: Double,

    @OneToMany(mappedBy = "servico", cascade = [CascadeType.ALL], orphanRemoval = true)
    val pedidos: List<Pedido> = emptyList() // 🔥 Um serviço pode estar em vários pedidos
)
