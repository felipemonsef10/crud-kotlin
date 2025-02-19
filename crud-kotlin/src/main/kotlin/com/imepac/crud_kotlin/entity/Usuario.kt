package com.imepac.crud_kotlin.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String,
    val email: String,
    var valorCompra: Double = 0.0,
    var valorDesconto: Double = 0.0,
    var valorTotal: Double = 0.0,

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    val pedidos: List<Pedido> = emptyList(),

    @OneToOne(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    val endereco: Endereco? = null  // 🚀 Adicionada relação com Endereco
) {
    fun calcularValorTotal() {
        this.valorTotal = valorCompra - valorDesconto
    }
}
