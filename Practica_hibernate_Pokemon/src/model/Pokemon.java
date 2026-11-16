
package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nacemento")
    private LocalDate nacemento;

    @ManyToOne
    @JoinColumn(name = "pokedexentry")
    private Pokedex pokedex;

    @ManyToOne
    @JoinColumn(name = "adestrador")
    private Adestrador adestrador;

    public Pokemon(String nome, Adestrador adestrador, Pokedex pokedex) {
        this.nome = nome;
        this.adestrador = adestrador;
        this.pokedex = pokedex;
    }

    public Pokemon(String nome,
                   LocalDate nacemento,
                   Pokedex pokedex,
                   Adestrador adestrador) {

        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedex = pokedex;
        this.adestrador = adestrador;
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

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", adestrador=" +
                (adestrador == null ? "-" : adestrador.getNome()) +
                ", pokedex=" +
                (pokedex == null ? "-" : pokedex.getNome()) +
                '}';
    }
}
