package sr.unasat.jpa.hello.dao;

import sr.unasat.jpa.hello.entities.City;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityDAO {

    private EntityManager entityManager;

    public CityDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<City> selectAll() {
        entityManager.getTransaction().begin();
        String jpql = "select c from City c";
        TypedQuery<City> query = entityManager.createQuery(jpql, City.class);
        List<City> cityList = query.getResultList();
        entityManager.getTransaction().commit();
        return cityList;
    }

    public List<City> selectAllByName(String name) {

        entityManager.getTransaction().begin();
        String jpql = "select c from City c where c.name = :name";
        TypedQuery<City> query = entityManager.createQuery(jpql, City.class);
        query.setParameter("name", name);
        List<City> cityList = query.getResultList();
        entityManager.getTransaction().commit();
        return cityList;
    }

    public void insert(City city) {
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    public int update(City city) {
        entityManager.getTransaction().begin();
        String sql = "update City c set c.name = :name, c.description = :description" +
                " where c.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", city.getId());
        query.setParameter("name", city.getName());
        query.setParameter("description", city.getDescription());
        int updated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return updated;
    }

    public int delete(City city) {
        entityManager.getTransaction().begin();
        String sql = "delete from City c where c.id = :id";
        Query query = entityManager.createQuery(sql);
        query.setParameter("id", city.getId());
        int deleted = query.executeUpdate();
        entityManager.getTransaction().commit();
        return deleted;
    }
}
