package imtiaj.repository;


import imtiaj.model.Tax;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaxRepository {

    private SessionFactory sessionFactory;

    public TaxRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.save(tax);
    }

    public void edit(Tax tax) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tax);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Tax tax = get(id);
        session.delete(tax);
    }

    public List<Tax> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Tax> userQuery = session.createQuery("from Tax", Tax.class);
        return userQuery.getResultList();
    }

    public Tax get(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tax.class, id);
    }


}
