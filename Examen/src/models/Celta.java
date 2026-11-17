package models;

public class Celta {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private int soldo;

    public Celta(String nome, int soldo){
        this.nome = nome;
        this.soldo = soldo;
    }

    public Celta(int id, String nome, int soldo) {
        this.id = id;
        this.nome = nome;
        this.soldo = soldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSoldo() {
        return soldo;
    }

    public void setSoldo(int soldo) {
        this.soldo = soldo;
    }
}
