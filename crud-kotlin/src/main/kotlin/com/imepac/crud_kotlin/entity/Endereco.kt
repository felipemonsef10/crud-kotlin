package com.imepac.crud_kotlin.entity

import jakarta.persistence.*

@Entity
data class Endereco(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val rua: String,
    val bairro: String,
    val numeroEndereco: Int,

    @OneToOne
    @JoinColumn(name = "usuario_id")
    val usuario: Usuario
)
