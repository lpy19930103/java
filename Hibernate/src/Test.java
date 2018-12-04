import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Configuration configure = new Configuration().configure();
        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Student student = new Student();
//        student.setName("LPY");
//        student.setClazz("三一");
//        student.setAge(18);
//        student.setScore("99");
//        student.setSex("man");
//        session.save(student);
//        transaction.commit();
//        session.close();

//        Query query = session1.createQuery("FROM Student");
        Query query = session.createQuery("FROM Student WHERE name = 'LPY'");
//        Criteria query = session.createCriteria(Student.class);
//        query.add(Restrictions.eq("id", 1L));

        List<Student> list = query.list();

        System.out.println(list);
        transaction.commit();
        session.close();

    }
}
