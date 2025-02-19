package com.imepac.crud_kotlin.entity

import jakarta.persistence.*

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
