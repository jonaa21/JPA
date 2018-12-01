package sr.unasat.jpa.hello.dao;

import sr.unasat.jpa.hello.entities.Employee;
import sr.unasat.jpa.hello.entities.McDonalds;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class McDonaldsDAO {

    private EntityManager entityManager;

    public McDonaldsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<McDonalds> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select m from McDonalds m";
        TypedQuery<McDonalds> query = entityManager.createQuery(jpql, McDonalds.class);
        List<McDonalds> mcDonaldsList = query.getResultList();
        entityManager.getTransaction().commit();
        return mcDonaldsList;
    }

    public List<McDonalds> selectAllByCity(String city) {

        entityManager.getTransaction().begin();
        String jpql = "select m from McDonalds m where m.city.name = :city";
        TypedQuery<McDonalds> query = entityManager.createQuery(jpql, McDonalds.class);
        query.setParameter("city", city);
        List<McDonalds> mcDonaldsList = query.getResultList();
        entityManager.getTransaction().commit();
        return mcDonaldsList;
    }

    public List<McDonalds> selectAllByAdres(String adres) {

        entityManager.getTransaction().begin();
        String jpql = "select m from McDonalds m where m.adres.name = :adres";
        TypedQuery<McDonalds> query = entityManager.createQuery(jpql, McDonalds.class);
        query.setParameter("adres", adres);
        List<McDonalds> mcDonaldsList = query.getResultList();
        entityManager.getTransaction().commit();
        return mcDonaldsList;
    }

    public McDonalds selectMcDonalds(int id) {
        entityManager.getTransaction().begin();
        String jpql = "select m from McDonalds m where m.code = :id";
        TypedQuery<McDonalds> query = entityManager.createQuery(jpql, McDonalds.class);
        query.setParameter("id", id);
        McDonalds mcDonalds = query.getSingleResult();
        entityManager.getTransaction().commit();
        return mcDonalds;
    }

    public void insert(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        entityManager.persist(mcDonalds);
        entityManager.getTransaction().commit();
    }

    public void updateMcDonalds(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        entityManager.merge(mcDonalds);
        entityManager.getTransaction().commit();
    }


    public void deleteMcDonalds(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        while (mcDonalds.getEmployee().iterator().hasNext()) {
            Employee employee = mcDonalds.getEmployee().iterator().next();
            mcDonalds.removeEmployee(employee);
        }
        entityManager.remove(mcDonalds);
        entityManager.getTransaction().commit();
    }
}
