package model;

import java.io.Serial;

public class Videoxogo {
    private static Serial Id;
    private static String Titulo;
    private static String Plataforma;
    private static int AnoLanzamento;
    private static String Descripcion;

    public Videoxogo(Serial Id, String Titulo, String Plataforma, int AnoLanzamento, String Descripcion) {
        Videoxogo.Id = Id;
        Videoxogo.Titulo = Titulo;
        Videoxogo.Plataforma = Plataforma;
        Videoxogo.AnoLanzamento = AnoLanzamento;
        Videoxogo.Descripcion = Descripcion;
    }

    public void setId(Serial id) { Id = id; }
    public static Serial getId() { return Id; }

    public void setTitulo(String titulo) { Titulo = titulo; }
    public static String getTitulo() { return Titulo; }

    public void setPlataforma(String plataforma) { Plataforma = plataforma; }
    public static String getPlataforma() { return Plataforma; }

    public void setAnoLanzamento(int anoLanzamento) { AnoLanzamento = anoLanzamento; }
    public static int getAnoLanzamento() { return AnoLanzamento; }

    public void setDescripcion(String descripcion) { Descripcion = descripcion; }
    public static String getDescripcion() { return Descripcion; }

    public String toString() {
        return Titulo + "(" + Plataforma + ", " + AnoLanzamento + ")" + Descripcion;
    }
}









