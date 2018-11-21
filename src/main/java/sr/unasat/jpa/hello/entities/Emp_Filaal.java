package sr.unasat.jpa.hello.entities;

import javax.persistence.*;

@Entity
@Table(name = "EMP_FILIAAL")
public class Emp_Filaal {


    public Emp_Filaal(){

    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;

    @Column(name="emp_filiaal_name", nullable = false)
    private String empFiliaalName;

    @ManyToOne
    @JoinColumn(name="employee_fk")
    private Employee employee;

    public Emp_Filaal(int id,String empFiliaalName, Employee employee) {
        this.id = id;
        this.empFiliaalName = empFiliaalName;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpFiliaalName() {
        return empFiliaalName;
    }

    public void setEmpFiliaalName(String empFiliaalName) {
        this.empFiliaalName = empFiliaalName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
