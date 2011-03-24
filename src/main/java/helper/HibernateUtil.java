package helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Properties;

/**
 * @author berinle
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    static {
        try {
            AnnotationConfiguration config = new AnnotationConfiguration().configure("demo.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static ThreadLocal<Session> session = new ThreadLocal<Session>();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession() {
        if(session.get() == null){
            session.set(sessionFactory.getCurrentSession());
        }
        return session.get();
    }
}
