package sr.unasat.jpa.hello.dao;

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
        String jpql = "select m from McDonalds m where m.id = :id";
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

    public int update(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        String sql = "update McDonalds m set m.adres = :adres, m.phone = :phone," +
                "m.code = :code, m.city = :city where m.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", mcDonalds.getId());
        query.setParameter("adres", mcDonalds.getAdres());
        query.setParameter("phone", mcDonalds.getPhone());
        query.setParameter("code", mcDonalds.getCode());
        query.setParameter("city", mcDonalds.getCity());
        int updated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return updated;
    }

    public int delete(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        String sql = "delete from McDonalds m where m.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", mcDonalds.getId());
        int deleted = query.executeUpdate();
        entityManager.getTransaction().commit();
        return deleted;
    }
}
