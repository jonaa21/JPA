package sr.unasat.jpa.hello.dao;

import sr.unasat.jpa.hello.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeDAO{

        private EntityManager entityManager;

        public EmployeeDAO(EntityManager entityManager) {
            this.entityManager = entityManager;
        }

        public List<Employee> selectAll() {
            entityManager.getTransaction().begin();
            String jpql = "select e from Employee e";
            TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
            List<Employee> employeeList = query.getResultList();
            entityManager.getTransaction().commit();
            return employeeList;
        }

        public List<Employee> selectAllById(int id) {

            entityManager.getTransaction().begin();
            String jpql = "select e from Employee e where e.id = :id";
            TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
            query.setParameter("id", id);
            List<Employee> employeeList = query.getResultList();
            entityManager.getTransaction().commit();
            return employeeList;
        }

        public void insert(Employee employee) {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        }

        public int update(Employee employee) {
            entityManager.getTransaction().begin();
            String sql = "update Employee e set e.firstname = :firstname, e.lastname = :lastname" +
                    " where e.id = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", employee.getId());
            query.setParameter("firstname", employee.getFirstname());
            query.setParameter("lastname", employee.getLastname());
            int updated = query.executeUpdate();
            entityManager.getTransaction().commit();
            return updated;
        }

        public int delete(Employee employee) {
            entityManager.getTransaction().begin();
            String sql = "delete from Employee e where e.id = :id";
            Query query = entityManager.createQuery(sql);
            query.setParameter("id", employee.getId());
            int deleted = query.executeUpdate();
            entityManager.getTransaction().commit();
            return deleted;
        }
}
