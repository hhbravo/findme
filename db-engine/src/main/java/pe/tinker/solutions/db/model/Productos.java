/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tinker.solutions.db.model;

import pe.tinker.solutions.db.model.base.Auditoria;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author petervs
 */
@Entity
@Table(name = "productos")
public class Productos extends Auditoria implements Serializable {

    public static final String FIND_ALL_PRODUCTOS = "Productos.findAll";
    public static final String FIND_BY_NOMBRE = "Productos.findByNombre";
    public static final String FIND_BY_ESTADO = "Productos.findByEstado";
    public static final String FIND_BY_NOMBRE_LIKE = "Productos.findByNombreLike";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "estado")
    private Integer estado;

    @OneToMany(mappedBy = "idProducto")
    private List<PuntosServicioProducto> puntosServicioProductoList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias idCategoria;

    public Productos() {
    }

    public Productos(Integer id) {
        this.id = id;
    }

    public Productos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    @XmlTransient
    public List<PuntosServicioProducto> getPuntosServicioProductoList() {
        return puntosServicioProductoList;
    }

    public void setPuntosServicioProductoList(List<PuntosServicioProducto> puntosServicioProductoList) {
        this.puntosServicioProductoList = puntosServicioProductoList;
    }

    public Categorias getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categorias idCategoria) {
        this.idCategoria = idCategoria;
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
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tinker.findme.model.Productos[ id=" + id + " ]";
    }

}
