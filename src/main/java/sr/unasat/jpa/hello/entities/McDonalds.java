package sr.unasat.jpa.hello.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MC_DONALDS")
public class McDonalds {

    public McDonalds() {
    }

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id", nullable=false)
        private int id;

        @OneToOne
        @JoinColumn(name = "adres_id")
        private Adres adres;

        @Column(name="phone", nullable=false)
        private String phone;

        @Column(name="code", nullable=false, unique=true)
        private String code;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="city_fk")     //FK to join on City table
        private City city;

        @ManyToMany(mappedBy = "mcDonalds")
        private List<Employee> employee;

    public McDonalds(Adres adres, String phone, String code, City city) {
        this.adres = adres;
        this.phone = phone;
        this.code = code;
        this.city = city;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Adres getAdres() {
            return this.adres;
        }

        public void setAdres(Adres adres) {
            this.adres = adres;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public void addEmployee(Employee employee) {
        if (!employee.getMcDonalds().contains(this)) {
            employee.getMcDonalds().add(this);
        }
        if (!this.employee.contains(employee)) {
            this.employee.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        if (employee.getMcDonalds().contains(this)) {
            employee.getMcDonalds().remove(this);
        }
        if (this.employee.contains(employee)) {
            this.employee.remove(employee);
        }
    }

    @Override
    public String toString() {
        return "McDonalds{" +
                "id=" + id +
                ", adres=" + adres +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", city=" + city +
                ", employee=" + employee +
                '}';
    }
}

