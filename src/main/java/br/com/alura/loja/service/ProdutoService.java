package br.com.alura.loja.service;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class ProdutoService {

    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Sansung");
        celular.setDescricao("S20");
        celular.setPreco(new BigDecimal("4000"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();

    }
}
