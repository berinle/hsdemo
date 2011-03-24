package helper;

import org.hibernate.SessionFactory;

/**
 * @author berinle
 */
public class Runner {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.close();
        System.out.println("done");
    }
}
