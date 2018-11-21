package sr.unasat.jpa.hello.entities;

import javax.persistence.*;

@Entity
@Table(name = "ADRES")
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "adres",fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    private McDonalds mcDonalds;

    public Adres() {
    }

    public Adres(String name, McDonalds mcDonalds) {
        this.name = name;
        this.mcDonalds = mcDonalds;
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

    public McDonalds getMcDonalds() {
        return mcDonalds;
    }

    public void setMcDonalds(McDonalds mcDonalds) {
        this.mcDonalds = mcDonalds;
    }

    @Override
    public String toString(){
        return "Adres {" +
                "id = " + id+
                "name = " + name +
                "}";

    }
}
