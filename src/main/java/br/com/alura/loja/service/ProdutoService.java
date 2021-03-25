package br.com.alura.loja.service;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoService {

    public static void main(String[] args) {
        cadastrarProduto();
       cadastrarProduto();


        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(1l);
        System.out.println("Preço do produto encontrado: " + p.getPreco());

        List<Produto> produtoList = produtoDao.buscarPorNomeDaCategoria("Celulares");
        produtoList.forEach(p2 -> System.out.println(p2.getNome()));


        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoPorNome("Samsung");
        System.out.println("Preço do produto " + precoDoProduto);


    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Samsung", "S20", new BigDecimal("4000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        em.getTransaction().commit();
        em.close();
    }
}
