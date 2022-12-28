package pedro.com.br.cadastro.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
    //criado o método de conexão!
    public static EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
