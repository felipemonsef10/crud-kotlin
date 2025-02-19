
package com.imepac.crud_kotlin.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Servico(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val descricao: String,
    val valorServico: Double,

    @OneToMany(mappedBy = "servico", cascade = [CascadeType.ALL], orphanRemoval = true)
    val pedidos: List<Pedido> = emptyList() // 🔥 Um serviço pode estar em vários pedidos
)
