package elrizo.com.fragmentos.model;

public class Categoria {

    private int idCategoria;
    private String imagen;
    private  String nombreCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String imagen, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.imagen = imagen;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
