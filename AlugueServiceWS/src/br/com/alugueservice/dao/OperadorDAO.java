package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Operador;

public interface OperadorDAO
{

    // M�todo para criar um operador na base de dados (INSERT)
    Operador create(Operador pOperador);

    // M�todo para recuperar um operador da base de dados (SELECT)
    Operador recovery(int pId);

    // M�todo para atualizar um operador na base de dados (UPDATE)
    Operador update(Operador pOperador);

    // M�todo para autentica��o de operador
    Operador autenticar(Operador pOperador);

    // M�todo para desativar um cliente na base de dados (DELETE)
    boolean alterarStatus(Operador pOperador);

    // M�todo para pesquisar todos os clientes da base de dados
    List<Operador> search();

    // M�todo para pesquisar por nome todos os clientes da base de dados
    List<Operador> searchByNome(String pNome);

    // M�todo para pesquisar por email todos os clientes da base de dados
    List<Operador> searchByLogin(String pLogin);

    // M�todo para pesquisar por cpf um clientes da base de dados
    List<Operador> searchByCpf(String pCpf);

}
