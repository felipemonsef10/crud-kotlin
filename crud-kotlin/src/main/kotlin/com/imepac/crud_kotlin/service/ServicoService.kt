package com.imepac.crud_kotlin.service

import com.imepac.crud_kotlin.entity.Servico
import com.imepac.crud_kotlin.repository.ServicoRepository
import org.springframework.stereotype.Service

@Service
class ServicoService(private val servicoRepository: ServicoRepository) {

    fun listar(): List<Servico> = servicoRepository.findAll()

    fun buscar(id: Long): Servico? = servicoRepository.findById(id).orElse(null)

    fun criarServico(servico: Servico): Servico = servicoRepository.save(servico)

    fun atualizarServico(id: Long, servico: Servico): Servico? {
        val servicoExistente = servicoRepository.findById(id).orElse(null) ?: return null
        val servicoAtualizado = servicoExistente.copy(
            descricao = servico.descricao,
            valorServico = servico.valorServico
        )
        return servicoRepository.save(servicoAtualizado)
    }

    fun deletarServico(id: Long): Boolean {
        return if (servicoRepository.existsById(id)) {
            servicoRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
