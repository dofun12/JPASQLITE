package jpasqlite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Start {
    public static void main(String... args){
        EntityManagerFactory sessionFactory = Persistence.createEntityManagerFactory( "minha-pu" );

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome("Teste");
        usuarioModel.setSenha("teste2");

        entityManager.persist( usuarioModel );
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
