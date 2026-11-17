package services;

import config.HibernateConfig;
import model.Comic;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ComicService {

    //Crear Comics

    public void crearComic(Comic comic) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.save(comic);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al crear un comic: " + e.getMessage());
        }
    }

    //Listar Comics

    public List<Comic> listarComics() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Comic> comics = session.createQuery("from Comic").list();
            transaction.commit();

            return comics;
        } catch (Exception e) {
            System.out.println("Error al listar los comics: " + e.getMessage());
        }
        return null;
    }

    //Eliminar Comics

    public void eliminarComic(Comic comic) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Comic c = (Comic) session.get(Comic.class, comic.getTitulo());
            session.delete(c);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al eliminar un comic: " + e.getMessage());
        }
    }


}
