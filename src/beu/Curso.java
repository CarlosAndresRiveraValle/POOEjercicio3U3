
package beu;


public class Curso {
    private String titulo;
    private float costo;
    private String descripccion;

    public Curso(String titulo, float costo, String descripccion) {
        this.titulo = titulo;
        this.costo = costo;
        this.descripccion = descripccion;
    }

    public Curso() {
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }

    @Override
    public String toString() {
        return titulo;
    }




}
