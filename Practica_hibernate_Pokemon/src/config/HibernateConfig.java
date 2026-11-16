
package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {

    private static final StandardServiceRegistry registry =
            new StandardServiceRegistryBuilder()
                    .configure("resources/properties.xml")
                    .build();

    private static final SessionFactory factory =
            new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static void cerrar() {
        factory.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
