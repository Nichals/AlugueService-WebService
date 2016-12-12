package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.ClienteDAO;
import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dto.ClienteDTO;
import br.com.alugueservice.model.Cliente;

public class ClienteController
{
    // M�todo de cria��o de cliente.
    public static ClienteDTO cadastrar(Cliente pCliente)
    {
        Cliente cliente = null;
        // Valida se objeto � nulo.
        if (pCliente == null)
        {
            return new ClienteDTO(false, "Tentativa de cadastrar cliente nulo.");
        }

        // Acesso a camada de persistencia
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        ClienteDTO validaCPF = ClienteController.pesquisarPorCpf(pCliente.getCpf());

        // Valida se j� possui cpf cadastrado.
        if (!validaCPF.isOk())
        {
            cliente = clienteDAO.create(pCliente);

        }
        else
        {
            return new ClienteDTO(false, "Erro ao gravar o cliente, CPF j� cadastrado.");
        }

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cliente == null)
        {
            return new ClienteDTO(false, "Erro ao gravar o cliente.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new ClienteDTO(true, "Cliente gravado com sucesso", cliente);

    }

    // M�todo de atualiza��o de cliente
    public static ClienteDTO atualizar(Cliente pCliente)
    {
        // Valida se objeto � nulo.
        if (pCliente == null)
            return new ClienteDTO(false, "Tentativa de cadastrar cliente nulo.");

        // Acesso a camada de persistencia
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        Cliente cliente = null;
        ClienteDTO validaCPF = ClienteController.pesquisarPorCpf(pCliente.getCpf());
        // Valida se j� possui login cadastrado

        if (validaCPF.isOk())
        {
            if (validaCPF.getCliente().getIdCliente() == pCliente.getIdCliente())
            {
                cliente = clienteDAO.update(pCliente);
            }
            else
            {
                return new ClienteDTO(false, "Erro ao atualizar Cliente, CPF j� cadastrado em outro Cliente.");
            }
        }
        else
        {
            cliente = clienteDAO.update(pCliente);
        }

        // Retornando o indicativo de falha ao salvar o objeto.
        if (cliente == null)
            return new ClienteDTO(false, "Erro ao atualizar cliente.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new ClienteDTO(true, "Cliente atualizado com sucesso.", cliente);
    }

    // M�todo de recupera��o de cliente
    public static ClienteDTO recuperar(Integer pId)
    {
        // Recuperando objeto do banco
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        Cliente cliente = clienteDAO.recovery(pId);

        // Valida se cliente foi recuperado com sucesso;
        if (cliente == null)
            return new ClienteDTO(false, "Cliente n�o existe.");

        return new ClienteDTO(true, "Cliente recuperado com sucesso.", cliente);
    }

    // M�todo de pesquisa total da base de dados
    public static ClienteDTO pesquisar()
    {
        // Obtendo lista de clientes
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        List<Cliente> listaCliente = clienteDAO.search();

        // Valida se lista est� vazia
        if (listaCliente.isEmpty())
            return new ClienteDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new ClienteDTO(true, "Lista de clientes recuperada.", listaCliente);

    }

    // M�todo de pesquisa por nome
    public static ClienteDTO pesquisarPorNome(String pNome)
    {
        // Valida se nome � nulo, caso seja, retorna base de clientes completa.
        if (pNome == null)
            return pesquisar();

        // Obtendo lista de clientes
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        List<Cliente> listaCliente = clienteDAO.searchByNome(pNome);

        // Valida se lista est� vazia
        if (listaCliente.isEmpty())
            return new ClienteDTO(false, "Nenhum resultado encontrado com o nome " + pNome + ".");

        // Retorna a lista
        return new ClienteDTO(true, "Lista de clientes recuperada.", listaCliente);

    }

    // M�todo de pesquisa por nome
    public static ClienteDTO pesquisarPorEmail(String pEmail)
    {
        // Valida se email � nulo, caso seja, retorna base de clientes completa.
        if (pEmail == null)
            return pesquisar();

        // Obtendo lista de clientes
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        List<Cliente> listaCliente = clienteDAO.searchByEmail(pEmail);

        // Valida se lista est� vazia
        if (listaCliente.isEmpty())
            return new ClienteDTO(false, "Nenhum resultado encontrado com o email " + pEmail + ".");

        // Retorna a lista
        return new ClienteDTO(true, "Lista de clientes recuperada.", listaCliente);

    }

    // M�todo de pesquisa por nome
    public static ClienteDTO pesquisarPorCpf(String pCpf)
    {
        // Valida se cpf � nulo, caso seja, retorna base de clientes completa.
        if (pCpf == null)
            return pesquisar();

        // Obtendo lista de clientes
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();
        Cliente cliente = clienteDAO.searchByCpf(pCpf);

        // Valida se cliente foi recuperado
        if (cliente == null)
            return new ClienteDTO(false, "Nenhum resultado encontrado com o cpf " + pCpf + ".");

        // Retorna o cliente
        return new ClienteDTO(true, "Lista de clientes recuperada.", cliente);

    }

    // M�todo de altera��o de status
    public static ClienteDTO alterarStatus(Cliente pCliente)
    {

        // Valida se cliente informado � nulo
        if (pCliente == null)
            return new ClienteDTO(false, "Cliente infomado � nulo.");
        // Acessa camada de persist�ncia
        ClienteDAO clienteDAO = DAOFactoy.getClienteDAO();

        // Valida se altera��o foi efetuada
        if (clienteDAO.alterarStatus(pCliente))
            return new ClienteDTO(true, "Status do cliente alterado com sucesso");

        return new ClienteDTO(false, "N�o foi possivel alterar status do cliente.");
    }
}
