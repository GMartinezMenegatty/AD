package services;

import config.HibernateConfig;
import model.Protagonista;
import org.hibernate.*;

public class ProtagonistaService {

    //Actualizar Protagonistas

    public void actualizarProtagonista(Protagonista novoProtagonista) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(novoProtagonista);
            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al actualizar un autor: " + e.getMessage());
        }
    }

    //Eliminar Protagonistas

    public void eliminarProtagonista(Protagonista novoProtagonista) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Protagonista p = (Protagonista) session.get(Protagonista.class, novoProtagonista.getNome());
            session.delete(p);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error al eliminar un protagonista: " + e.getMessage());
        }
    }

}
