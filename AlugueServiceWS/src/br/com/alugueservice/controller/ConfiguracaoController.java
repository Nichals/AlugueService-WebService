package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.ConfiguracaoDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.ConfiguracaoDTO;
import br.com.alugueservice.model.Configuracao;

public class ConfiguracaoController
{

    // M�todo de cadastro de Configura��o
    public static ConfiguracaoDTO cadastrar(Configuracao pConfiguracao)
    {

        // Valida se objeto � nulo.
        if (pConfiguracao == null)
        {
            return new ConfiguracaoDTO(false, "Tentativa de cadastrar Cupom nulo.");
        }
        // Acesso a camada de persistencia
        ConfiguracaoDAO configuracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao cupom = configuracaoDAO.create(pConfiguracao);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cupom == null)
        {
            return new ConfiguracaoDTO(false, "Erro ao gravar a Configura��o.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ConfiguracaoDTO(true, "Configura��o gravado com sucesso", cupom);

    }

    // M�todo de recupera��o de Cupom
    public static ConfiguracaoDTO recuperar(Integer pId)
    {

        // Acesso a camada de persistencia
        ConfiguracaoDAO configuracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao configuracao = configuracaoDAO.recovery(pId);

        // Retornando o indicativo de falha ao salvar o objeto.
        if (configuracao == null)
        {
            return new ConfiguracaoDTO(false, "Configura��o n�o existe.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ConfiguracaoDTO(true, "Configura��o recuperada com sucesso", configuracao);

    }

    // M�todo de pesquisa total da base de dados
    public static ConfiguracaoDTO pesquisar()
    {
        // Obtendo lista de Produtos
        ConfiguracaoDAO ConfiguracaoDAO = DAOFactoy.getConfiguracaoDAO();
        List<Configuracao> listaConfiguracao = ConfiguracaoDAO.search();

        // Valida se lista est� vazia
        if (listaConfiguracao.isEmpty())
            return new ConfiguracaoDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ConfiguracaoDTO(true, "Lista de Produtos recuperada.", listaConfiguracao);

    }

    // M�todo de pesquisa total da base de dados
    public static ConfiguracaoDTO pesquisarUltimo()
    {
        // Obtendo lista de Produtos
        ConfiguracaoDAO ConfiguracaoDAO = DAOFactoy.getConfiguracaoDAO();
        Configuracao configuracao = ConfiguracaoDAO.searchLast();

        // Valida se lista est� vazia
        if (configuracao == null)
            return new ConfiguracaoDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ConfiguracaoDTO(true, "Lista de Produtos recuperada.", configuracao);

    }

}
