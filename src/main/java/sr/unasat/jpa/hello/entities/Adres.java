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

    @OneToOne(mappedBy = "adres", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private McDonalds mcDonalds;
    public Adres() {
    }

    public Adres(int id,String name) {
        this.id = id;
        this.name = name;
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
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mcDonalds=" + mcDonalds +
                '}';
    }
}
