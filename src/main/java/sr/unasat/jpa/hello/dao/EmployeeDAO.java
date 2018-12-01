package sr.unasat.jpa.hello.dao;

import sr.unasat.jpa.hello.entities.Employee;
import sr.unasat.jpa.hello.entities.McDonalds;

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


    public Employee selectEmployee(int id) {
        entityManager.getTransaction().begin();
        String jpql = "select e from Employee e where e.id = :id";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("id", id);
        Employee employee = query.getSingleResult();
        entityManager.getTransaction().commit();
        return employee;
    }

    public void insertEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void insertEmployee(McDonalds mcDonalds) {
        entityManager.getTransaction().begin();
        for (Employee employee : mcDonalds.getEmployee()) {
            if (employee.getId() == 0) {
                entityManager.persist(employee);
            }
        }
        entityManager.getTransaction().commit();
    }

    public void updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        for (McDonalds mcDonalds : employee.getMcDonalds()) {
            if (mcDonalds.getId() == 0) {
                entityManager.persist(mcDonalds);
            }
        }
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
    }

    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        while (employee.getMcDonalds().iterator().hasNext()) {
            McDonalds mcDonalds = employee.getMcDonalds().iterator().next();
            employee.removeMcDonalds(mcDonalds);
        }
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }
}
