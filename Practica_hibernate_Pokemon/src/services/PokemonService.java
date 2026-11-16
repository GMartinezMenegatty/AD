
package services;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokemonService {

    // INSERTAR CON OBJETOS
    public void crearPokemon(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            try {
                session.save(pokemon);
                tx.commit();
            } catch (Exception e) {
                System.out.printf("Erro ao crear o Pokemon: %s%n", e.getMessage());
                tx.rollback();
            }
        }
    }

    // INSERTAR CON SQL
    public void crearPokemonQuery(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createNativeQuery(
                                "INSERT INTO Pokemon " +
                                        "(Nome, Nacemento, PokedexEntry, Adestrador) " +
                                        "VALUES (:nome, :nacemento, :pokedex, :adestrador)"
                        )
                        .setParameter("nome", pokemon.getNome())
                        .setParameter(
                                "nacemento",
                                pokemon.getNacemento() == null
                                        ? null
                                        : java.sql.Date.valueOf(
                                        pokemon.getNacemento())
                        )
                        .setParameter(
                                "pokedex",
                                pokemon.getPokedex() == null
                                        ? null
                                        : pokemon.getPokedex().getId()
                        )
                        .setParameter(
                                "adestrador",
                                pokemon.getAdestrador() == null
                                        ? null
                                        : pokemon.getAdestrador().getId()
                        )
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao crear o Pokemon: " + e.getMessage());
                tx.rollback();
            }
        }
    }

    // BUSCAR POR ID CON OBJETOS
    public Pokemon lerPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.get(Pokemon.class, id);
        }
    }

    // BUSCAR POR ID CON HQL
    public Pokemon lerPokemonQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Pokemon WHERE id = :id",
                            Pokemon.class
                    )
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    // LISTAR POKEMON
    public List<Pokemon> listarPokemons() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Pokemon ORDER BY id",
                    Pokemon.class).list();
        }
    }

    // MODIFICAR CON OBJETOS
    public void modificarPokemon(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.update(pokemon);
                tx.commit();
            } catch (Exception e) {
                System.out.println("Erro ao actualizar o Pokemon: " + e.getMessage());
                tx.rollback();
            }
        }
    }

    // MODIFICAR CON HQL
    public void modificarPokemonQuery(Pokemon pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "UPDATE Pokemon SET " +
                                        "nome = :nome, " +
                                        "nacemento = :nacemento, " +
                                        "pokedex = :pokedex, " +
                                        "adestrador = :adestrador " +
                                        "WHERE id = :id"
                        )
                        .setParameter("nome", pokemon.getNome())
                        .setParameter(
                                "nacemento",
                                pokemon.getNacemento()
                        )
                        .setParameter(
                                "pokedex",
                                pokemon.getPokedex()
                        )
                        .setParameter(
                                "adestrador",
                                pokemon.getAdestrador()
                        )
                        .setParameter("id", pokemon.getId())
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println( "Erro ao actualizar o Pokemon: " + e.getMessage());
                tx.rollback();
            }
        }
    }

    // ELIMINAR CON OBJETOS
    public void eliminarPokemon(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                Pokemon pokemon =
                        session.get(Pokemon.class, id);

                if (pokemon != null) {
                    session.delete(pokemon);
                }

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar o Pokemon: " + e.getMessage());
                tx.rollback();
            }
        }
    }

    // ELIMINAR CON HQL
    public void eliminarPokemonQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "DELETE FROM Pokemon WHERE id = :id")
                        .setParameter("id", id)
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar o Pokemon: " + e.getMessage());
                tx.rollback();
            }
        }
    }

    // ELIMINAR TODOS CON OBJETOS
    public void eliminarTodosPokemons() {
        List<Pokemon> lista = listarPokemons();

        for (Pokemon pokemon : lista) {
            eliminarPokemon(pokemon.getId());
        }
    }

    // ELIMINAR TODOS CON HQL
    public void eliminarTodosPokemonsQuery() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                        "DELETE FROM Pokemon"
                ).executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar todos os Pokemons: " + e.getMessage());
                tx.rollback();
            }
        }
    }
}
