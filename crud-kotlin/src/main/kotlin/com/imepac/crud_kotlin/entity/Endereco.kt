package com.imepac.crud_kotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

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
