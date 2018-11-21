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
        out.println("Current table");

        List<McDonalds> mcDonaldsList = mcDonaldsDAO.selectAll();
        for (McDonalds mc : mcDonaldsList) {
            out.println(mc);
        }
    }
}
