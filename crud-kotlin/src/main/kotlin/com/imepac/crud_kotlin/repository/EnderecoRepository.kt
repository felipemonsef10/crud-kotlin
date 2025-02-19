package com.imepac.crud_kotlin.repository

import com.imepac.crud_kotlin.entity.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository : JpaRepository<Endereco, Long>
