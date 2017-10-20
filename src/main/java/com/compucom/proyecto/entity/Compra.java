package com.compucom.proyecto.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate fecha;
    private Double total;
    private Integer idEnvio;
    private Integer idUsuario;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compra_producto",
            joinColumns = @JoinColumn(name = "compra_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id"))
    private List<Producto> productos;

    public Compra() {
    }

    public Compra(LocalDate fecha, Double total, Integer idEnvio, Integer idUsuario, List<Producto> productos) {
        this.fecha = fecha;
        this.total = total;
        this.idEnvio = idEnvio;
        this.idUsuario = idUsuario;
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", total=" + total +
                ", idEnvio=" + idEnvio +
                ", idUsuario=" + idUsuario +
                ", productos=" + productos +
                '}';
    }
}
