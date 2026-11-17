
package services;

import config.HibernateConfig;
import model.Adestrador;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdestradorService {
// INSERTAR CON OBJETOS
    public void crearAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            try {
                session.save(adestrador);
                tx.commit();
            } catch (Exception e) {
                System.out.println("Erro ao crear o Adestrador: " + e.getMessage());
            }
        }
    }
// INSERTAR CON SQL
    public void crearAdestradorQuery(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            try {
                session.createNativeQuery(
                                "INSERT INTO Adestrador (Nome, Nacemento) " +
                                        "VALUES (:nome, :nacemento)")
                        .setParameter("nome", adestrador.getNome())
                        .setParameter(
                                "nacemento", adestrador.getNacemento() == null ? null
                                        : java.sql.Date.valueOf(
                                        adestrador.getNacemento())
                        )
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao crear o Adestrador: " + e.getMessage());
            }
        }
    }

    // BUSCAR POR ID CON OBJETOS
    public Adestrador lerAdestrador(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, id);
        } catch (Exception e) {
            System.out.println("Erro ao ler o Adestrador: " + e.getMessage());
            return null;
        }
    }

    // BUSCAR POR ID CON HQL
    public Adestrador lerAdestradorQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery(
                            "FROM Adestrador WHERE id = :id", Adestrador.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    // LISTAR ENTRENADORES
    public List<Adestrador> listarAdestradores() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            return session.createQuery("FROM Adestrador ORDER BY id", Adestrador.class).list();
        }
    }

    // MODIFICAR CON OBJETOS
    public void modificarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.update(adestrador);
                tx.commit();
            } catch (Exception e) {
                System.out.println("Erro ao modificar o Adestrador: " + e.getMessage());
            }
        }
    }

    // MODIFICAR CON HQL
    public void modificarAdestradorQuery(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "UPDATE Adestrador SET nome = :nome, nacemento = :nacemento WHERE id = :id"
                        )
                        .setParameter("nome", adestrador.getNome())
                        .setParameter(
                                "nacemento",
                                adestrador.getNacemento()
                        )
                        .setParameter("id", adestrador.getId())
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao modificar o Adestrador: " + e.getMessage());
            }
        }
    }

    // ELIMINAR CON OBJETOS
    public void eliminarAdestrador(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                Adestrador adestrador =
                        session.get(Adestrador.class, id);

                if (adestrador != null) {
                    session.delete(adestrador);
                }

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar o Adestrador: " + e.getMessage());
            }
        }
    }

    // ELIMINAR CON HQL
    public void eliminarAdestradorQuery(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();
            try {
                session.createQuery(
                                "DELETE FROM Adestrador WHERE id = :id"
                        )
                        .setParameter("id", id)
                        .executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar o Adestrador: " + e.getMessage());
            }
        }
    }

    // ELIMINAR TODOS CON OBJETOS
    public void eliminarTodosAdestradores() {
        List<Adestrador> lista = listarAdestradores();

        for (Adestrador adestrador : lista) {
            eliminarAdestrador(adestrador.getId());
        }
    }

    // ELIMINAR TODOS CON HQL
    public void eliminarTodosAdestradoresQuery() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            try {
                session.createQuery(
                        "DELETE FROM Adestrador"
                ).executeUpdate();

                tx.commit();

            } catch (Exception e) {
                System.out.println("Erro ao eliminar todos os Adestradores: " + e.getMessage());
            }
        }
    }
}
