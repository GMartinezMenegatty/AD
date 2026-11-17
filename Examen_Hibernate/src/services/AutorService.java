package services;

import config.HibernateConfig;
import model.Autor;
import org.hibernate.*;

public class AutorService {

    //Actualizar Autores

    public void actualizarAutor(Autor novoAutor) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(novoAutor);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar un autor: " + e.getMessage());
        }
    }

    //Eliminar Autores

    public void eliminarAutor(Autor novoAutor) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

                Autor autor = (Autor) session.get(Autor.class, novoAutor.getNome());
                session.delete(autor);

                transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al eliminar un autor: " + e.getMessage());
        }
    }
}
