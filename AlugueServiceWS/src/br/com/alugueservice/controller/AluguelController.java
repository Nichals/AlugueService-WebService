package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.AluguelDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.AluguelDTO;
import br.com.alugueservice.model.Aluguel;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;

public class AluguelController
{
    // M�todo de cadastro de Aluguel
    public static AluguelDTO cadastrar(Aluguel pAluguel)
    {

        // Valida se objeto � nulo.
        if (pAluguel == null)
        {
            return new AluguelDTO(false, "Tentativa de cadastrar Aluguel nulo.");
        }

        // Acesso a camada de persistencia
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = aluguelDAO.create(pAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new AluguelDTO(false, "Erro ao gravar o Aluguel.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel gravado com sucesso", aluguel);

    }

    //M�todo de finaliza��o de Aluguel
    public static AluguelDTO finalizar(Aluguel pAluguel) {
        // valida se o objeto possui informa��o
        if (pAluguel == null)
            return new AluguelDTO(false, "Tentativa de finalizar Aluguel nulo.");
     // Acesso a camada de persistencia
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        Boolean resultado = AluguelDAO.finalizar(pAluguel);

     // Retornando o indicativo de falha ao salvar o objeto.
        if (resultado == false)
        {
            return new AluguelDTO(false, "Aluguel n�o foi finalizado.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel finalizado com sucesso");

    }
    // M�todo de recupera��o de Aluguel
    public static AluguelDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = AluguelDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new AluguelDTO(false, "Aluguel n�o existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel recuperado com sucesso", aluguel);

    }

    // M�todo de pesquisa total da base de dados
    public static AluguelDTO pesquisar()
    {
        // Obtendo lista de Produtos
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = AluguelDAO.search();

        // Valida se lista est� vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Produtos recuperada.", listaAluguel);

    }

    // M�todo de atualiza��o de Aluguel
    public static AluguelDTO atualizar(Aluguel pAluguel)
    {
        // Valida se objeto � nulo.
        if (pAluguel == null)
            return new AluguelDTO(false, "Tentativa de cadastrar Aluguel nulo.");

        // Acesso a camada de persistencia
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        Aluguel aluguel = aluguelDAO.update(pAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
            return new AluguelDTO(false, "Erro ao atualizar o aluguel.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new AluguelDTO(true, "Aluguel atualizado com sucesso.", aluguel);
    }

    // M�todo de pesquisa por operador
    public static AluguelDTO pesquisarPorOperador(Operador pOperador, Integer pStatus)
    {
        // Valida se nome � nulo
        if (pOperador == null)
            return new AluguelDTO(false, "Operador n�o possui nenhuma informa��o.");

        // Obtendo lista de Produtos
        AluguelDAO AluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = AluguelDAO.searchByOperador(pOperador, pStatus);

        // Valida se lista est� vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum Aluguel encontrado para o Operador " + pOperador.getNome() + " " + pOperador.getSobrenome() + ".");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Alugueis recuperada.", listaAluguel);

    }

    // M�todo de pesquisa por cliente
    public static AluguelDTO pesquisarPorCliente(Cliente pCliente, Integer pStatus)
    {
        // Valida se nome � nulo
        if (pCliente == null)
            return new AluguelDTO(false, "Cliente informado n�o possui nenhuma informa��o.");

        // Obtendo lista de Produtos
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = aluguelDAO.searchByCliente(pCliente, pStatus);

        // Valida se lista est� vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum cupom encontrado para o Cliente " + pCliente.getNome() + " " + pCliente.getSobrenome() + ".");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de Produtos recuperada.", listaAluguel);

    }

    // M�todo de pesquisa por status
    public static AluguelDTO pesquisarPorStatus(Integer pStatus)
    {
        // Obtendo lista de Alugueis
        AluguelDAO aluguelDAO = DAOFactoy.getAluguelDAO();
        List<Aluguel> listaAluguel = aluguelDAO.searchByStatus(pStatus);

        // Valida se lista est� vazia
        if (listaAluguel.isEmpty())
            return new AluguelDTO(false, "Nenhum aluguel encontrado para o status informado.");

        // Retorna a lista
        return new AluguelDTO(true, "Lista de alugueis recuperada.", listaAluguel);

    }
}
