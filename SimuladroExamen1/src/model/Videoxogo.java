package model;

import java.io.Serial;

public class Videoxogo {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String Titulo;
    private String Plataforma;
    private int AnoLanzamento;
    private String Descripcion;

    public Videoxogo(int Id, String Titulo, String Plataforma, int AnoLanzamento, String Descripcion) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzamento;
        this.Descripcion = Descripcion;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setPlataforma(String plataforma) {
        Plataforma = plataforma;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public void setAnoLanzamento(int anoLanzamento) {
        AnoLanzamento = anoLanzamento; }

    public int getAnoLanzamento() {
        return AnoLanzamento;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

}









