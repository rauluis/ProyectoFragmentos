package elrizo.com.fragmentos.model;

import java.util.Objects;

public class Admin {

    private int idAdmin;
    private String imagen;
    private String titulo;
    private int clasificacion;
    private String descripcion;

    public Admin() {
    }

    public Admin(int idAdmin, String imagen, String titulo, int clasificacion, String descripcion) {
        this.idAdmin = idAdmin;
        this.imagen = imagen;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin Admin = (Admin) o;
        return idAdmin == Admin.idAdmin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdmin);
    }



}

