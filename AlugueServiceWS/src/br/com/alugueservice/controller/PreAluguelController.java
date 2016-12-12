package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dao.PreAluguelDAO;
import br.com.alugueservice.dto.PreAluguelDTO;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.PreAluguel;

public class PreAluguelController
{

    // M�todo de cadastro de PreAluguel
    public static PreAluguelDTO cadastrar(PreAluguel pPreAluguel)
    {

        // Valida se objeto � nulo.
        if (pPreAluguel == null)
        {
            return new PreAluguelDTO(false, "Tentativa de cadastrar Pr�-aluguel nulo.");
        }

        // Acesso a camada de persistencia
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = aluguelDAO.create(pPreAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new PreAluguelDTO(false, "Erro ao gravar o Pr�-aluguel.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "Pr�-aluguel gravado com sucesso", aluguel);

    }

    // M�todo de recupera��o de PreAluguel
    public static PreAluguelDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = PreAluguelDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
        {
            return new PreAluguelDTO(false, "Pr�-aluguel n�o existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "Pr�-aluguel recuperado com sucesso", aluguel);

    }

    // M�todo de pesquisa total da base de dados
    public static PreAluguelDTO pesquisar()
    {
        // Obtendo lista de Pr� - Aluguel
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = PreAluguelDAO.search();

        // Valida se lista est� vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Pr�-aluguel recuperada.", listaPreAluguel);

    }

    // M�todo de atualiza��o de PreAluguel
    public static PreAluguelDTO atualizar(PreAluguel pPreAluguel)
    {
        // Valida se objeto � nulo.
        if (pPreAluguel == null)
            return new PreAluguelDTO(false, "Tentativa de cadastrar Pre-aluguel nulo.");

        // Acesso a camada de persistencia
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        PreAluguel aluguel = aluguelDAO.update(pPreAluguel);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (aluguel == null)
            return new PreAluguelDTO(false, "Erro ao atualizar o pr�-aluguel.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new PreAluguelDTO(true, "PreAluguel atualizado com sucesso.", aluguel);
    }

    // M�todo de pesquisa por operador
    public static PreAluguelDTO pesquisarPorOperador(Operador pOperador, Integer pStatus)
    {
        // Valida se nome � nulo
        if (pOperador == null)
            return new PreAluguelDTO(false, "Operador n�o possui nenhuma informa��o.");

        // Obtendo lista de Pr� - Aluguel
        PreAluguelDAO PreAluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = PreAluguelDAO.searchByOperador(pOperador, pStatus);

        // Valida se lista est� vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum Pr�-aluguel encontrado para o Operador " + pOperador.getNome() + " " + pOperador.getSobrenome() + ".");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Alugueis recuperada.", listaPreAluguel);

    }

    // M�todo de pesquisa por cliente
    public static PreAluguelDTO pesquisarPorCliente(Cliente pCliente, Integer pStatus)
    {
        // Valida se nome � nulo
        if (pCliente == null)
            return new PreAluguelDTO(false, "Cliente informado n�o possui nenhuma informa��o.");

        // Obtendo lista de Pr� - Aluguel
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = aluguelDAO.searchByCliente(pCliente, pStatus);

        // Valida se lista est� vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum cupom encontrado para o Cliente " + pCliente.getNome() + " " + pCliente.getSobrenome() + ".");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de Pr� - Aluguel recuperada.", listaPreAluguel);

    }

    // M�todo de pesquisa por status
    public static PreAluguelDTO pesquisarPorStatus(Integer pStatus)
    {
        // Obtendo lista de Alugueis
        PreAluguelDAO aluguelDAO = DAOFactoy.getPreAluguelDAO();
        List<PreAluguel> listaPreAluguel = aluguelDAO.searchByStatus(pStatus);

        // Valida se lista est� vazia
        if (listaPreAluguel.isEmpty())
            return new PreAluguelDTO(false, "Nenhum aluguel encontrado para o status informado.");

        // Retorna a lista
        return new PreAluguelDTO(true, "Lista de pr� - aluguel recuperada.", listaPreAluguel);

    }
}

