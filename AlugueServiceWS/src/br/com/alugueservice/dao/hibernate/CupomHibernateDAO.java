package br.com.alugueservice.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.alugueservice.dao.CupomDAO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Cupom;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.util.HibernateUtil;

public class CupomHibernateDAO implements CupomDAO
{

    // M�todo de cria��o de cupom
    @Override
    public Cupom create(Cupom pCupom)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // salvando o objeto via hibernate
            tSessao.save(pCupom);
            tSessao.flush();

            // retornando o objeto atualizado
            return pCupom;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de cria��o do Cliente, " + tExcept);
        }

        return null;
    }

    // M�todo de recupera��o de cupom
    @Override
    public Cupom recovery(int pId)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            Cupom tCupom = (Cupom) tSessao.get(Cupom.class, pId);

            // Retornando o objeto lido
            return tCupom;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o do Cliente, " + tExcept);
        }
        return null;
    }

    // M�tpdp de utiliza��o de cupom
    @Override
    public Boolean UsarCupom(Cliente pCliente)
    {
        try
        {

            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando a lista de cupom que o cliente possui
            List<Cupom> tListCupom = searchByClienteStatus(pCliente, 1);
            if (tListCupom.isEmpty())
            {
                return false;
            }
            Cupom tCupom = tListCupom.get(0);
            tCupom.setStatusCupom(0);
            tSessao.merge(tCupom);
            // Retornando o status da opera�a�
            return true;
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o do Cliente, " + tExcept);
        }
        return null;
    }

    // M�todo de pesquisa total da base
    @SuppressWarnings("unchecked")
    @Override
    public List<Cupom> search()
    {
        // Criando a tLista de alunos vazia
        List<Cupom> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM TBL_CUPOM");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de alunos
        return tLista;
    }

    // M�todo de pesquisa por cliente e status
    @SuppressWarnings("unchecked")
    @Override
    public List<Cupom> searchByCliente(Cliente pCliente)
    {

        // Criando a tLista de cupons vazia
        List<Cupom> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cupom.class)
                            .add(Restrictions.like("cliente", pCliente.getIdCliente()));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de cupons, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }
    // M�todo de pesquisa por cliente e status
    @SuppressWarnings("unchecked")
    @Override
    public List<Cupom> searchByClienteStatus(Cliente pCliente, int pStatus)
    {

        // Criando a tLista de cupons vazia
        List<Cupom> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cupom.class)
                            .add(Restrictions.like("cliente", pCliente.getIdCliente()))
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }
    // M�todo de pesquisa por operador e status
    @SuppressWarnings("unchecked")
    @Override
    public List<Cupom> searchByOperador(Operador pOperador)
    {
        // Criando a tLista de cupons vazia
        List<Cupom> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cupom.class)
                            .add(Restrictions.like("operador", pOperador.getIdOperador()));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cupom> searchByOperadorStatus(Operador pOperador, int pStatus)
    {
        // Criando a tLista de cupons vazia
        List<Cupom> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o crit�rio para pesquisa
            Criteria tCriterio = tSessao.createCriteria(Cupom.class)
                            .add(Restrictions.like("cliente", pOperador.getIdOperador()))
                            .add(Restrictions.like("status", pStatus));

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
        }
        catch (HibernateException tExcept)
        {
            System.out.println("Erro no m�todo de recupera��o da lista de Clientes, " + tExcept);
        }

        // Retornando a lista de clientes
        return tLista;
    }

}
