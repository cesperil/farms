package com.agrotente.farms.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "harvests")
public class Harvest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_parcela", nullable = false)
    private Farm idParcela;

    @Column(name = "tipo_cultivo", nullable = false)
    private String tipoCultivo;

    @Column(name = "cantidad", nullable = false)
    private String cantidad;
    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "calidad", nullable = false)
    private String calidad;
    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Farm getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Farm idParcela) {
        this.idParcela = idParcela;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

}
