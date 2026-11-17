package models;

public class Xogadores {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String posicion;
    private int idade;

    public Xogadores(String nome, String posicion, int idade) {
        this.nome = nome;
        this.posicion = posicion;
        this.idade = idade;
    }

    public Xogadores(int id, String nome, String posicion, int idade){
        this.id = id;
        this.nome = nome;
        this.posicion = posicion;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

