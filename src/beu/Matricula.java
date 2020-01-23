package beu;

import rivera.Persona;
import rivera.Unidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {

    private final String numero;
    private Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private List<Calificacion> calificaciones = new ArrayList<>();
    private float promedio;//atributo donde se van a mostrar los datos procesados

    public Matricula() {

        fecha = Calendar.getInstance();
        estado = Estado.Registrada;
        UUID numeroALeatorio = UUID.randomUUID();
        this.numero = numeroALeatorio.toString();

    }

    public String getNumero() {
        return numero;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void calcularPromedio() {
        if (this.calificaciones.isEmpty()) {
            return;

        }

        float suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.valor;// se puede acceeder directamente por q es una clase interna
        }
        int divisor = this.calificaciones.size();
        promedio = (float) suma / (float) divisor;
        if (divisor == 3) {

            if (promedio > 14) {
                this.estado = Estado.Aprobada;
            } else {

                this.estado = Estado.Reprobada;

            }

        }

    }

    //Este metodo agrega una clificacion y retorna un numero
    //1 si es la nota de la unidad I
    //2 si es la nota de la unidad II
    //3 si es la nota de la unidad III
    //0 si ya tiene las notas
    public int addCalificacion(float v) {
        Calificacion cal = new Calificacion();
        int cuentaNotas = this.calificaciones.size();
        switch (cuentaNotas) {
            case 0:
                cal.setUnidad(Unidad.I);
                break;
            case 1:
                cal.setUnidad(Unidad.II);
                break;
            case 2:
                cal.setUnidad(Unidad.III);
                break;
            //Caso de tener  todas las notas es 0
            default:
                return 0;
        }

        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.calcularPromedio();
        //retorna el tamaño de la lista
        return this.calificaciones.size();
    }

    @Override
    public String toString() {

        return estudiante.toString() + " #" + numero;
    }

    public String toSave() {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(this);

    }

    public String imprimirDetalle() {

        String str = "\n\t" + this.estudiante;
        for (Calificacion c : this.calificaciones) {
            str += "\t\t" + c.getValor();
        }
        str += "\t\t" + this.promedio + "\n";
        return str;
    }

    class Calificacion {

        private Calendar fecha;
        private float valor;
        private Unidad unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidad unidad) {
            this.unidad = unidad;
        }

    }

}
