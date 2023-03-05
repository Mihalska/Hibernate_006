package task_4;
import task_4.entity.Author;
import task_4.entity.AuthorAndBook;
import task_4.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AuthorBookHelper {
    private SessionFactory sessionFactory;

    public AuthorBookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void add (long authorId, long bookId ){
        AuthorAndBook authorAndBook = new AuthorAndBook(authorId, bookId);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(authorAndBook);
        session.getTransaction().commit();
        session.close();

    }



}
