package sr.unasat.jpa.hello.app;

import sr.unasat.jpa.hello.config.JPAConfiguration;
import sr.unasat.jpa.hello.dao.McDonaldsDAO;
import sr.unasat.jpa.hello.entities.McDonalds;

import java.util.List;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class App {

    public static void main(String[] args) {
        McDonaldsDAO mcDonaldsDAO = new McDonaldsDAO(JPAConfiguration.getEntityManager());
        List<McDonalds> mcDonaldsList = mcDonaldsDAO.selectAll();
        mcDonaldsList.stream().forEach(System.out::println);
        JPAConfiguration.shutdown();

        //TODO
        //In adresDao -> insertAddressWithMcDonaldsList(Adres adres) met een lijst van McDonalds records
        //CRUD mbt ManyToMany en OneToOne
        //Scenario I: nieuwe emp met nieuwe filialen (cascade)
        //Scenario II: nieuwe emp met lijst van bestaande mcD
        //Scenario III: bestaande emp met lijst van nieuwe mcD
        //Scenario IV: bestaande emp met bestaande mcD
        //Scenario V: mixed van nieuwe/bestaande emp en nieuwe/bestaande mcD
    }
}
