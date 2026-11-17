package model;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table (name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "apelidos", nullable = false, length = 100)
    private String apelidos;

    @Column(name = "nacionalidade",  nullable = false, length = 50)
    private String nacionalidade;

    public Autor(String nome, String apelidos, String nacionalidade) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
    }

    public Autor(Long id, String nome, String apelidos, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
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

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}


