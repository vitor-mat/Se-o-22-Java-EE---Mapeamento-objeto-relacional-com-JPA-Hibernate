package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dominio.Pessoa;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //Objetos utilizados para inserir dados
        //Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        //Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        //Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        //Configuração entity manager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Utilizado para as operações de inserção
        //entityManager.getTransaction().begin();

        //Buscando dados após o cadastro
        Pessoa p = entityManager.find(Pessoa.class, 2);

        //Cadastrando dados no banco
        //entityManager.persist(p1);
        //entityManager.persist(p2);
        //entityManager.persist(p3);
        //entityManager.getTransaction().commit();

        //Testando remoção dos dados
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();

        System.out.println("Pronto");
        //System.out.println(p);

        entityManager.close();
        entityManagerFactory.close();
    }
}
