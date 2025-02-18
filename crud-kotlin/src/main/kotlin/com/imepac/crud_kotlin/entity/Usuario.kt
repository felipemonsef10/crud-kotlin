package com.imepac.crud_kotlin.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nome: String,
    val email: String,
    // teste para ver o uso do var
    var valorCompra: Double = 0.0,
    var valorDesconto: Double = 0.0,
    var valorTotal: Double = 0.0,

    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], orphanRemoval = true)
    val pedidos: List<Pedido> = emptyList()  // Um usuário pode ter vários pedidos

) {
    fun calcularValorTotal() {
        this.valorTotal = valorCompra - valorDesconto
    }
}