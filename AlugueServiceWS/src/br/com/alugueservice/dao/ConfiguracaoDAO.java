package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Configuracao;

public interface ConfiguracaoDAO
{

    // M�todo para criar um configura��o na base de dados (INSERT)
    Configuracao create(Configuracao pConfiguracao);

    // M�todo para recuperar um configura��o da base de dados (SELECT)
    Configuracao recovery(int pId);

    // M�todo para pesquisar todos os configura��es da base de dados
    List<Configuracao> search();

    // M�todo para pesquisar a ultima configura��o da base de dados
    Configuracao searchLast();
}
