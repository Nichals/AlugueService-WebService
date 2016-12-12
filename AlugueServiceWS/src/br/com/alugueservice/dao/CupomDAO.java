package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Cupom;
import br.com.alugueservice.model.Operador;

public interface CupomDAO
{

    // M�todo para criar um cupom na base de dados (INSERT)
    Cupom create(Cupom pCupom);

    // M�todo para recuperar um cupom da base de dados (SELECT)
    Cupom recovery(int pId);

 // M�todo para alterar o status, alterando para usado, do primeiro cupom de um cliente
    Boolean UsarCupom(Cliente pCliente);

    // M�todo para pesquisar todos os cupons da base de dados
    List<Cupom> search();

    // M�todo para pesquisar por nome todos os cupons de um cliente de acordo com o status informado
    List<Cupom> searchByCliente(Cliente pCliente);

    // M�todo para pesquisar por email todos os os cupons que um operador criou de acordo com o status informado
    List<Cupom> searchByOperador(Operador pOperador);

    List<Cupom> searchByOperadorStatus(Operador pOperador, int pStatus);

    List<Cupom> searchByClienteStatus(Cliente pCliente, int pStatus);



}
