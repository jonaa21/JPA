package sr.unasat.jpa.hello.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CITY")
public class City {

    public City(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", nullable=false , unique=true)
    private String name;

    @Column(name="description", nullable=false)
    private String description;

    @OneToMany( mappedBy = "city")
    private List<McDonalds> mcDonalds;


    public City(int id, String name, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){

        return "City {" +
                "id = " + id +
                ", name = " + name+
                ", description = " + description +"}";
    }
}
