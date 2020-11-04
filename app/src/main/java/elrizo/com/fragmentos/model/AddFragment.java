package elrizo.com.fragmentos.model;

import java.util.Objects;

public class AddFragment {

    private int idJuego;
    private String imagen;
    private String titulo;
    private int clasificacion;
    private String descripcion;

    public AddFragment(){

    }

    public AddFragment(int idJuego, String imagen, String titulo, int clasificacion, String descripcion) {
        this.idJuego = idJuego;
        this.imagen = imagen;
        this.titulo = titulo;
        this.clasificacion = clasificacion;
        this.descripcion = descripcion;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
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
        AddFragment addFragment = (AddFragment) o;
        return idJuego == addFragment.idJuego;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuego);
    }


}
