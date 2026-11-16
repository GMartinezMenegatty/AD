
package services;

import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PokedexService {

    // INSERTAR CON OBJETOS
    public void crearPokedex(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.save(pokemon);
                tx.commit();
            } catch (Exception e) {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                System.out.println("Erro ao crear a pokedex da Pokedex: " + e.getMessage());
            }
        }
    }

    // INSERTAR CON SQL
    public void crearPokedexQuery(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createNativeQuery(
                                "INSERT INTO Pokedex (Nome, Peso, Misc) " +
                                        "VALUES (:nome, :peso, :misc)")
                        .setParameter("nome", pokemon.getNome())
                        .setParameter("peso", pokemon.getPeso())
                        .setParameter("misc", pokemon.getMisc())
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao crear a pokedex da Pokedex: " + e.getMessage());
            }
        }
    }

    // BUSCAR POR ID CON OBJETOS
    public Pokedex lerPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokedex.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler a pokedex da Pokedex: " + e.getMessage());
            return null;
        }
    }

    // BUSCAR POR ID CON HQL
    public Pokedex lerPokedexQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Pokedex WHERE id = :id",
                            Pokedex.class
                    )
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (Exception e) {
            System.out.println("Erro ao ler a pokedex da Pokedex: " + e.getMessage());
            return null;
        }
    }

    // LISTAR TODOS
    public List<Pokedex> listarPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery(
                    "FROM Pokedex ORDER BY id",
                    Pokedex.class).list();
        } catch (Exception e) {
            System.out.println("Erro ao listar as pokedexes da Pokedex: " + e.getMessage());
            return null;
        }
    }

    // MODIFICAR CON OBJETOS
    public void modificarPokedex(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.update(pokemon);
                tx.commit();
            } catch (Exception e) {
                System.out.println("Erro ao modificar a pokedex da Pokedex: " + e.getMessage());
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    // MODIFICAR CON HQL
    public void modificarPokedexQuery(Pokedex pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "UPDATE Pokedex SET " +
                                        "nome = :nome, " +
                                        "peso = :peso, " +
                                        "misc = :misc " +
                                        "WHERE id = :id"
                        )
                        .setParameter("nome", pokemon.getNome())
                        .setParameter("peso", pokemon.getPeso())
                        .setParameter("misc", pokemon.getMisc())
                        .setParameter("id", pokemon.getId())
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao modificar a pokedex da Pokedex: " + e.getMessage());
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // ELIMINAR CON OBJETOS
    public void eliminarPokedex(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                Pokedex pokemon =
                        session.get(Pokedex.class, id);

                if (pokemon != null) {
                    session.delete(pokemon);
                }

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar a pokedex da Pokedex: " + e.getMessage());
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
            }
        }
    }

    // ELIMINAR CON HQL
    public void eliminarPokedexQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "DELETE FROM Pokedex WHERE id = :id"
                        )
                        .setParameter("id", id)
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar a pokedex da Pokedex: " + e.getMessage());
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }

    // ELIMINAR TODOS CON OBJETOS
    public List<Pokedex> eliminarTodosPokedex() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Pokedex> pokedexList = session.createQuery(
                    "FROM Pokedex", Pokedex.class
            ).list();

            return pokedexList;

        } catch (Exception e) {
            System.out.println("Erro ao listar pokedexs da Pokedex: " + e.getMessage());
            return null;
        }
    }

    // ELIMINAR TODOS CON HQL
    public void eliminarTodosPokedexQuery() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                        "DELETE FROM Pokedex"
                ).executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar a pokedex da Pokedex: " + e.getMessage());
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
                throw e;
            }
        }
    }
}
