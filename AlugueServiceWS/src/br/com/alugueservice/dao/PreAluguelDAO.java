package br.com.alugueservice.dao;

import java.util.List;

import br.com.alugueservice.model.Cliente;
import br.com.alugueservice.model.Operador;
import br.com.alugueservice.model.PreAluguel;

public interface PreAluguelDAO
{
    // M�todo para criar um pr�-aluguel na base de dados (INSERT)
    PreAluguel create(PreAluguel pPreAluguel);

    // M�todo para recuperar um pr�-aluguel da base de dados (SELECT)
    PreAluguel recovery(int pId);

    // M�todo para finalizar um pr�-aluguel da base de dados
    PreAluguel update(PreAluguel pPreAluguel);

    // M�todo para pesquisar todos os pr�-alugueis da base de dados
    List<PreAluguel> search();

    // M�todo para pesquisar todos os pr�-alugueis de um cliente de acordo
    // com o status informado
    List<PreAluguel> searchByCliente(Cliente pCliente, int pStatus);

    // M�todo para pesquisar por operador todos os os pr�-alugueis que um operador criou
    // de acordo com o status informado
    List<PreAluguel> searchByOperador(Operador pOperador, int pStatus);

    // M�todo para pesquisar por status todos os os pr�-alugueis
    List<PreAluguel> searchByStatus(int pStatus);
}
