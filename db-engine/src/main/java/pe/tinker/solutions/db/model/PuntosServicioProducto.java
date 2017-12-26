/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tinker.solutions.db.model;

import pe.tinker.solutions.db.model.base.Auditoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "puntos_servicio_producto")
public class PuntosServicioProducto  extends Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "estado")
    private Integer estado;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Productos idProducto;
    @JoinColumn(name = "id_punto_servicio", referencedColumnName = "id")
    @ManyToOne
    private PuntosServicio idPuntoServicio;

    public PuntosServicioProducto() {
    }

    public PuntosServicioProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public PuntosServicio getIdPuntoServicio() {
        return idPuntoServicio;
    }

    public void setIdPuntoServicio(PuntosServicio idPuntoServicio) {
        this.idPuntoServicio = idPuntoServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PuntosServicioProducto)) {
            return false;
        }
        PuntosServicioProducto other = (PuntosServicioProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.PuntosServicioProducto[ id=" + id + " ]";
    }
    
}
