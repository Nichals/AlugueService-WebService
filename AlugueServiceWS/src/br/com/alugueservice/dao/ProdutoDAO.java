package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Produto;

public interface ProdutoDAO
{

    // M�todo para criar um produto na base de dados (INSERT)
    Produto create(Produto pProduto);

    // M�todo para recuperar um produto da base de dados (SELECT)
    Produto recovery(int pId);

    // M�todo para atualizar um produto na base de dados (UPDATE)
    Produto update(Produto pProduto);

    // M�todo para desativar um produto na base de dados (DELETE)
    boolean alterarStatus(Produto pProduto);

    // M�todo para pesquisar todos os produtos da base de dados
    List<Produto> search();

    // M�todo para pesquisar por nome todos os produtos da base de dados
    List<Produto> searchByNome(String pNome);

}
