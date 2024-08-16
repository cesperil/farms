package com.agrotente.farms.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Si tu columna `id` es autoincremental
    @Column(name = "id")
    private Integer id;

    @Column(name = "latitud", length = 30)
    private String latitud;

    @Column(name = "longitud", length = 30)
    private String longitud;

    @Column(name = "cod_municipio")
    private Integer codMunicipio;

    @Column(name = "poligono")
    private Integer poligono;

    @Column(name = "parcela")
    private Integer parcela;

    @Column(name = "fk_ide_usuario", nullable = false)
    private Integer fkIdeUsuario;

    @Column(name = "fecha_alta", nullable = false, updatable = false, insertable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "fecha_ult_modificacion", nullable = false, insertable = false)
    private LocalDateTime fechaUltModificacion;

    @Column(name = "usuario_modificacion", nullable = false, length = 50)
    private String usuarioModificacion;

    @Column(name = "nombre", length = 50)
    private String nombre;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Integer getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(Integer codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public Integer getPoligono() {
        return poligono;
    }

    public void setPoligono(Integer poligono) {
        this.poligono = poligono;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    public Integer getFkIdeUsuario() {
        return fkIdeUsuario;
    }

    public void setFkIdeUsuario(Integer fkIdeUsuario) {
        this.fkIdeUsuario = fkIdeUsuario;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDateTime getFechaUltModificacion() {
        return fechaUltModificacion;
    }

    public void setFechaUltModificacion(LocalDateTime fechaUltModificacion) {
        this.fechaUltModificacion = fechaUltModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @PrePersist
    public void prePersist() {
        if (this.fechaAlta == null) {
            this.fechaAlta = LocalDateTime.now();
        }
        if (this.fechaUltModificacion == null) {
            this.fechaUltModificacion = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaUltModificacion = LocalDateTime.now();
    }

}
