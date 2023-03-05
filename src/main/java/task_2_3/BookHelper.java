package task_2_3;
import task_2_3.entity.Author;
import task_2_3.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Author> root = cq.from(Book.class);// первостепенный, корневой entity (в sql запросе - from)
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }
    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Book book = session.get(Book.class, id);
        session.delete(book); // сгенерит ID и вставит в объект
        session.getTransaction().commit();
        session.close();

//
    }

    public int deleteByName(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete <Book> cd = cb.createCriteriaDelete(Book.class);
        Root <Book> root = cd.from(Book.class);
        cd.where(cb.equal(root.get("author"), author ));
        Query query = session.createQuery(cd);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return result;

    }





}
