package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Aluguel;
import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;

public interface AluguelDAO
{
    // M�todo para criar um aluguel na base de dados (INSERT)
    Aluguel create(Aluguel pAluguel);

    // M�todo para recuperar um aluguel da base de dados (SELECT)
    Aluguel recovery(int pId);

    //M�todo para finalizar o aluguel
    Boolean finalizar(Aluguel pAluguel);

    //M�todo para atualizar um aluguel
    Aluguel update(Aluguel pAluguel);

    // M�todo para pesquisar todos os alugueis da base de dados
    List<Aluguel> search();

    // M�todo para pesquisar todos os alugueis de um cliente de acordo
    // com o status informado
    List<Aluguel> searchByCliente(Cliente pCliente, int pStatus);

    // M�todo para pesquisar por operador todos os os alugueis que um operador criou
    // de acordo com o status informado
    List<Aluguel> searchByOperador(Operador pOperador, int pStatus);

    // M�todo para pesquisar por status todos os os alugueis
    List<Aluguel> searchByStatus(int pStatus);
}
