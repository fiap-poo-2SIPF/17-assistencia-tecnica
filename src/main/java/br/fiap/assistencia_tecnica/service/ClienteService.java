package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;
    private EquipamentoRepository equipamentoRepository;

    public ClienteService(ClienteRepository repository, EquipamentoRepository equipamentoRepository) {
        this.repository = repository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public Cliente buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Equipamento> listarEquipamentos(Long idCliente) {
        return equipamentoRepository.findByClienteId(idCliente);
    }

}
