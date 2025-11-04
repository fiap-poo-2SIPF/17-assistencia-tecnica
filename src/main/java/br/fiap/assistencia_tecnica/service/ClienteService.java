package br.fiap.assistencia_tecnica.service;

import br.fiap.assistencia_tecnica.config.SenhaConfig;
import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.domain.Equipamento;
import br.fiap.assistencia_tecnica.repository.ClienteRepository;
import br.fiap.assistencia_tecnica.repository.EquipamentoRepository;
import br.fiap.assistencia_tecnica.web.dto.ClienteRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;
    private EquipamentoRepository equipamentoRepository;
    private SenhaConfig encoder;

    public ClienteService(ClienteRepository repository,
                          EquipamentoRepository equipamentoRepository,
                          SenhaConfig encoder) {
        this.repository = repository;
        this.equipamentoRepository = equipamentoRepository;
        this.encoder = encoder;
    }

    public Cliente salvar(ClienteRequest requisicao) {
        Cliente cliente = new Cliente();

        cliente.setNome(requisicao.getNome());
        cliente.setEmail(requisicao.getEmail());
        cliente.setTelefone(requisicao.getTelefone());
        cliente.setSenha(encoder.hashear().encode(requisicao.getSenha()));
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
