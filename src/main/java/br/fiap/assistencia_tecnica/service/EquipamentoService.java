package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.EquipamentoDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.NoSuchElementException;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final ClienteRepository clienteRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, ClienteRepository clienteRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.clienteRepository = clienteRepository;
    }

    public Equipamento criar(@RequestBody EquipamentoDTO equipamentoDTO) {
        var cliente = clienteRepository.findById(equipamentoDTO.getCliente().getId())
                .orElseThrow(() -> new NoSuchElementException("Cliente não localizado"));

        var equipamento = new Equipamento();
        equipamento.setModelo(equipamentoDTO.getModelo());
        equipamento.setMarca(equipamentoDTO.getMarca());
        equipamento.setTipo(equipamentoDTO.getTipo());
        equipamento.setNumero_serie(equipamentoDTO.getNumero_serie());
        equipamento.setData_cadastro(equipamentoDTO.getData_cadastro());
        equipamento.setCliente(cliente);

        return equipamentoRepository.save(equipamento);
    }

    public Equipamento buscarPorId(Long idEquipamento) {
        return equipamentoRepository.findById(idEquipamento)
                .orElseThrow(() -> new NoSuchElementException("Equipamento não encontrado"));
    }
}
