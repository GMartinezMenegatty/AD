package model;

import javax.persistence.*;

@Entity
@Table (name = "Protagonista")

public class Protagonista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", nullable = false, length = 100)
    private String nome;

    @Column (name = "poder", nullable = false, length = 200)
    private String poder;

    public Protagonista(String nome, String poder) {
        this.nome = nome;
        this.poder = poder;
    }

    public Protagonista(Long id, String nome, String poder) {
        this.id = id;
        this.nome = nome;
        this.poder = poder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }
}
