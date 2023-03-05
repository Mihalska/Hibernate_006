package task_5;
import task_5.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;


public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList(String param){
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        Selection[] selections = {root.get("id"), root.get("name")};
        cq.select(cb.construct(Author.class, selections))
                .where(cb.like(root.<String>get("name"), param));
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }
    public void deleteCriteria(String pat)  {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);// первостепенный, корневой entity (в sql запросе - from)
        cd.where(cb.like(root.<String>get("name"), pat));
        Query query = session.createQuery(cd);
        int deletedValues = query.executeUpdate();
        System.out.println("Deleted values: " + deletedValues);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCriteriaLogic(String par1, String par2, String par3)  {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();// не использовать session.createCriteria, т.к. deprecated
        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);
        Root<Author> root = cd.from(Author.class);

        cd.where(cb.or(
                cb.and(
                        cb.like(root.<String>get("name"), par1),
                        cb.like(root.<String>get("lastName"), par2)
                ),
                cb.equal(root.get("lastName"), par3)
        ));
        Query query = session.createQuery(cd);
        int deletedValues = query.executeUpdate();
        System.out.println("Deleted values: " + deletedValues);
        session.getTransaction().commit();
        session.close();
    }


}
