package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Cliente;

public interface ClienteDAO
{

    // M�todo para criar um cliente na base de dados (INSERT)
    Cliente create(Cliente pCliente);

    // M�todo para recuperar um cliente da base de dados (SELECT)
    Cliente recovery(int pId);

    // M�todo para atualizar um cliente na base de dados (UPDATE)
    Cliente update(Cliente pCliente);

    // M�todo para desativar um cliente na base de dados (DELETE)
    boolean alterarStatus(Cliente pCliente);

    // M�todo para pesquisar por cpf todos os clientes da base de dados
    Cliente searchByCpf(String pCpf);

    // M�todo para pesquisar todos os clientes da base de dados
    List<Cliente> search();

    // M�todo para pesquisar por nome todos os clientes da base de dados
    List<Cliente> searchByNome(String pNome);

    // M�todo para pesquisar por email todos os clientes da base de dados
    List<Cliente> searchByEmail(String pEmail);

}
