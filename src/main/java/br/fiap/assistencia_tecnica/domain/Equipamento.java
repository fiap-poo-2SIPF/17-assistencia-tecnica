package br.fiap.assistencia_tecnica.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "JAVA_EQUIPAMENTO")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIP")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false,
            foreignKey = @ForeignKey(name = "FK_EQUIP_CLIENTE"))
    private Cliente cliente;

    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @Column(name = "MARCA", length = 50)
    private String marca;

    @Column(name = "MODELO", length = 50)
    private String modelo;

    @Column(name = "NUMERO_SERIE", length = 80)
    private String numero_serie;

    @Column(name = "DATA_CADASTRO")
    private LocalDate data_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
