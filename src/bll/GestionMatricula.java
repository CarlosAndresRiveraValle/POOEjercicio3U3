package bll;

import rivera.BaseBllCrud;
import rivera.BasePersistencia;
import rivera.Util;
import beu.Curso;
import beu.Estado;
import beu.Estudiante;
import beu.Matricula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionMatricula extends BasePersistencia<Matricula> implements BaseBllCrud<Matricula> {

    private Matricula matricula;
    private final String directorio = "matriculas";

    public GestionMatricula() {
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String calificar(float valor) {
        String mensaje = " ";

        int num = this.matricula.addCalificacion(valor);
        switch (num) {
            case 0:
                mensaje = "Todas las notas estan registradas !";
                break;
            case 1:
                mensaje = "Calificaciones de la Unidad I ingresada correctamente";
                break;
            case 2:
                mensaje = "Calificaciones de la Unidad II ingresada correctamente";
                break;
            case 3:
                mensaje = "Calificaciones de la Unidad III ingresada correctamente";
                break;
            default:
                mensaje = "Ocurrio un error al registrar la calificación";

        }
        return mensaje;
    }

    public void promediar() {
        this.matricula.calcularPromedio();
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante:");
        sb.append(matricula.getEstudiante()).append("\n");
        sb.append("Curso:");
        sb.append(matricula.getCurso().getTitulo()).append("\n");
        sb.append("Promedio:");
        sb.append(matricula.getPromedio());
        // sb.append("\n");
        // sb.append(matricula.imprimirDetalle());
        return sb.toString();
    }

    public void archivar() throws IOException {
        this.escribir(directorio, this.matricula.getNumero(), matricula);
    }

    public void configurar(Curso cr, Estudiante est) {
        this.matricula.setCurso(cr);
        this.matricula.setEstudiante(est);
    }

    public void anularMatri(boolean bool) {
        if (bool == true) {
            matricula.setEstado(Estado.Anulada);
            Util.imprimir("\nSu matricula a sido anulada exitosamente");
            float val = matricula.getCurso().getCosto() * 0.10f;
            Util.imprimir("\nDebe cancelar un 10% de  rubro por anulacion: " + val);
        }
    }

    public List<Matricula> reportar(String titulo) throws IOException {
        List<Matricula> resultado = new ArrayList<>();
        List<String> contenidos = this.leerDirectorio(directorio, titulo);
        for (String texto : contenidos) {
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
            try {
                Matricula m = gson.fromJson(texto, Matricula.class);
                resultado.add(m);
            } catch (Exception ex) {
                Util.imprimir("El texto no se pudo convertir en matricula\n");
                Util.imprimir(ex.toString() + "\n");
            }

        }
        return resultado;
    }

    @Override
    public void crear() {
        matricula = new Matricula();
    }

    @Override
    public void consultar(String id) throws IOException {
        String archivo = id + ".json";
        String contenido = this.leer(directorio, archivo);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido, Matricula.class);

    }

    @Override
    public void actualizar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
