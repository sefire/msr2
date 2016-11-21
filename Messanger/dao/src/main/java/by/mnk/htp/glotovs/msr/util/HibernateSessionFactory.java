package by.mnk.htp.glotovs.msr.util;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Sefire on 20.11.2016.
 */

public class HibernateSessionFactory {

    private static final ThreadLocal threadLocal = new ThreadLocal();
    private static org.hibernate.SessionFactory sessionFactory;

    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;

    private static Logger log = Logger.getLogger(HibernateSessionFactory.class);

    static {
        try {
            configuration.configure().setNamingStrategy(new CustomNamingStrategy());;
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.error("Error Creating HibernateSessionFactory",e);
        }
    }

    private HibernateSessionFactory() {
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;

            threadLocal.set(session);
        }
        return session;
    }

    public static void rebuildSessionFactory() {
        try {
            configuration.configure().setNamingStrategy(new CustomNamingStrategy());;
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.error("Error rebuildSessionFactory",e);
        }
    }

    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.flush();
            session.clear();//
            session.close();
        }
    }

    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

}