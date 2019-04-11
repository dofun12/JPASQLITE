package jpasqlite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

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


        Query query = entityManager.createQuery("select us from UsuarioModel us",UsuarioModel.class);
        List<UsuarioModel> usuarioModels =  query.getResultList();
        for(UsuarioModel us:usuarioModels){
            System.out.println("Nome: "+us.getNome());
            System.out.println("Senha: "+us.getSenha());
        }




        entityManager.close();
    }
}
