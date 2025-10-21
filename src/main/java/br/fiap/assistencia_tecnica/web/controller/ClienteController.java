package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.service.ClienteService;
import br.fiap.assistencia_tecnica.web.dto.ClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody ClienteRequest requisicao) {
        Cliente cliente = new Cliente();

        cliente.setNome(requisicao.getNome());
        cliente.setEmail(requisicao.getEmail());
        cliente.setTelefone(requisicao.getTelefone());
        cliente.setSenha(requisicao.getSenha());
        return service.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Cliente buscaPorId(@PathVariable Long id) {
        return service.buscaPorId(id);
    }
}
