package br.fiap.assistencia_tecnica.web.dto;

import br.fiap.assistencia_tecnica.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoDTO {
    private Long id;
    private Cliente cliente;
    private String tipo;
    private String marca;
    private String modelo;
    private String numero_serie;
    private LocalDate data_cadastro;
}
