package com.imepac.crud_kotlin.service

import com.imepac.crud_kotlin.entity.Endereco
import com.imepac.crud_kotlin.repository.EnderecoRepository
import org.springframework.stereotype.Service

@Service
class EnderecoService(private val enderecoRepository: EnderecoRepository) {

    fun listar(): List<Endereco> = enderecoRepository.findAll()

    fun buscar(id: Long): Endereco? = enderecoRepository.findById(id).orElse(null)

    fun criarEndereco(endereco: Endereco): Endereco = enderecoRepository.save(endereco)

    fun atualizarEndereco(id: Long, endereco: Endereco): Endereco? {
        val enderecoExistente = enderecoRepository.findById(id).orElse(null) ?: return null
        val enderecoAtualizado = enderecoExistente.copy(
            rua = endereco.rua,
            bairro = endereco.bairro,
            numeroEndereco = endereco.numeroEndereco
        )
        return enderecoRepository.save(enderecoAtualizado)
    }

    fun deletarEndereco(id: Long): Boolean {
        return if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
