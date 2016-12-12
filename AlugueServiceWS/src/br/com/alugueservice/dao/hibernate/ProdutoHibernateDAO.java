package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.ProdutoDAO;
import br.com.alugueservice.model.Produto;
import br.com.alugueservice.util.HibernateUtil;

public class ProdutoHibernateDAO implements ProdutoDAO
{

    @Override
    public Produto create(Produto pProduto)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pProduto);
            tSessao.flush();

            // retornando o objeto atualizado
            return pProduto;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de cria��o do Produto, " + tExcept);
        }

        return null;
    }

    @Override
    public Produto recovery(int pId)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Produto tProduto = (Produto) tSessao.get(Produto.class, pId);

            // Retornando o objeto lido
            return tProduto;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o do Produto, " + tExcept);
        }
        return null;
    }

    @Override
    public Produto update(Produto pProduto)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Atualizando o objeto via hibernate
            tSessao.merge(pProduto);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pProduto;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de atualiza��o do Produto, " + tExcept);
        }
        return null;

    }

    @Override
    public boolean alterarStatus(Produto pProduto)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();
            // Atualizando o objeto
            tSessao.merge(pProduto);
            tSessao.flush();
            // retornando status da atualiza��o
            return true;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de atualiza��o do Produto, " + tExcept);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Produto> search()
    {
        // Criando a tLista de produtos vazia
        List<Produto> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_PRODUTO");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Operador, " + tExcept);
        }

        // Retornando a lista de alunos
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Produto> searchByNome(String pNome)
    {
        // Acertando o crit�rio de pesquisa
        String tNomePesquisa = "%" + pNome + "%";

        // Criando a tLista de Cliente vazia
        List<Produto> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Produto.class)
                            .add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Produtos, " + tExcept);
        }

        // Retornando a lista de alunos
        return tLista;
    }

}
