package br.com.alugueservice.controller;

import java.util.List;

import br.com.alugueservice.dao.DAOFactoy;
import br.com.alugueservice.dao.OperadorDAO;
import br.com.alugueservice.dto.OperadorDTO;
import br.com.alugueservice.model.Operador;

public class OperadorController
{

    // M�todo de cadastro de Operador
    public static OperadorDTO cadastrar(Operador pOperador)
    {
        Operador operador = null;
        // Valida se objeto � nulo.
        if (pOperador == null)
        {
            return new OperadorDTO(false, "Tentativa de cadastrar operador nulo.");
        }

        // Acesso a camada de persistencia
        OperadorDAO operadorDAO = DAOFactoy.getOperadorDAO();
        OperadorDTO validaCPF = OperadorController.pesquisarPorCpf(pOperador.getCpf());

        // Valida se j� possui cpf cadastrado.
        if (!validaCPF.isOk())
        {
            // Valida se j� possui login cadastrado
            OperadorDTO validaLogin = OperadorController.pesquisarPorLogin(pOperador.getLogin());
            if (!validaLogin.isOk())
            {
                operador = operadorDAO.create(pOperador);

            }
            else
            {
                return new OperadorDTO(false, "Erro ao gravar o operador, Login j� cadastrado.");
            }

        }
        else
        {
            return new OperadorDTO(false, "Erro ao gravar o operador, CPF j� cadastrado.");
        }

        // Retornando o indicativo de falha ao salvar o objeto.
        if (operador == null)
        {
            return new OperadorDTO(false, "Erro ao gravar o operador.");
        }

        // Retornando o indicativo de sucesso com o objeto criado
        return new OperadorDTO(true, "Operador gravado com sucesso", operador);

    }

    // M�todo de autentica��o de operador
    public static OperadorDTO autenticar(Operador pOperador)
    {

        // Pesquisa operador pelo login informado
        OperadorDTO tDto = pesquisarPorLogin(pOperador.getLogin());

        // Valida se foi recuperado operador com o login informado
        if (tDto.isOk() == false)
            return new OperadorDTO(false, "Nenhum operador encontrado com o login: " + pOperador.getLogin() + ".");
        // Valida se a senha informada corresponde com a senha cadastrada
        if (tDto.getOperador().getSenha() != pOperador.getSenha())
            return new OperadorDTO(false, "Senha incorreta.");
        return tDto;
    }

    // M�todo de atualiza��o de Operador
    public static OperadorDTO atualizar(Operador pOperador)
    {

        Operador operador = null;
        // Valida se objeto � nulo.
        if (pOperador == null)
            return new OperadorDTO(false, "Tentativa de cadastrar operador nulo.");

        // Acesso a camada de persistencia
        OperadorDAO operadorDAO = DAOFactoy.getOperadorDAO();
        // Valida se j� possui cpf cadastrado
        OperadorDTO validaCPF = OperadorController.pesquisarPorCpf(pOperador.getCpf());

        // Valida se j� possui login cadastrado
        OperadorDTO validaLogin = OperadorController.pesquisarPorLogin(pOperador.getLogin());
        if (validaCPF.isOk())
        {

            if (validaCPF.getLista().contains(pOperador))
            {
                if (validaLogin.isOk())
                {
                    if (validaLogin.getLista().contains(pOperador))
                    {
                        operador = operadorDAO.update(pOperador);
                    }
                    else
                    {
                        return new OperadorDTO(false, "Erro ao atualizar operador, Login j� cadastrado em outro operador.");
                    }
                }
                else
                {
                    operador = operadorDAO.update(pOperador);
                }

            }
            else
            {
                return new OperadorDTO(false, "Erro ao atualizar operador, CPF j� cadastrado em outro operador.");
            }

        }
        else
        {
            if (validaLogin.isOk())
            {
                if (validaLogin.getLista().contains(pOperador))
                {
                    operador = operadorDAO.update(pOperador);
                }
                else
                {
                    return new OperadorDTO(false, "Erro ao atualizar operador, Login j� cadastrado em outro operador.");
                }
            }
            else
            {
                operador = operadorDAO.update(pOperador);
            }

        }

        // Retornando o indicativo de falha ao salvar o objeto.
        if (operador == null)
            return new OperadorDTO(false, "Erro ao atualizar operador.");

        // Retornando o indicativo de sucesso com o objeto criado
        return new OperadorDTO(true, "Operador atualizado com sucesso.", operador);
    }

    // M�todo de recupera��o de operador
    public static OperadorDTO recuperar(Integer pId)
    {
        // Recuperando objeto do banco
        OperadorDAO operadorDAO = DAOFactoy.getOperadorDAO();
        Operador operador = operadorDAO.recovery(pId);

        // Valida se Operador foi recuperado com sucesso;
        if (operador == null)
            return new OperadorDTO(false, "Operador n�o existe.");

        return new OperadorDTO(true, "Operador recuperado com sucesso.", operador);
    }

    // M�todo de pesquisa total da base de dados
    public static OperadorDTO pesquisar()
    {
        // Obtendo lista de Operadors
        OperadorDAO OperadorDAO = DAOFactoy.getOperadorDAO();
        List<Operador> listaOperador = OperadorDAO.search();

        // Valida se lista est� vazia
        if (listaOperador.isEmpty())
            return new OperadorDTO(false, "Nenhum resultado encontrado.");

        // Retorna a lista
        return new OperadorDTO(true, "Lista de Operadors recuperada.", listaOperador);

    }

    // M�todo de pesquisa por nome
    public static OperadorDTO pesquisarPorNome(String pNome)
    {
        // Valida se nome � nulo, caso seja, retorna base de Operadors completa.
        if (pNome == null)
            return pesquisar();

        // Obtendo lista de Operadors
        OperadorDAO OperadorDAO = DAOFactoy.getOperadorDAO();
        List<Operador> listaOperador = OperadorDAO.searchByNome(pNome);

        // Valida se lista est� vazia
        if (listaOperador.isEmpty())
            return new OperadorDTO(false, "Nenhum resultado encontrado com o nome " + pNome + ".");

        // Retorna a lista
        return new OperadorDTO(true, "Lista de Operadors recuperada.", listaOperador);

    }

    // M�todo de pesquisa por nome
    public static OperadorDTO pesquisarPorCpf(String pCpf)
    {
        // Valida se cpf � nulo, caso seja, retorna base de Operadors completa.
        if (pCpf == null)
            return pesquisar();

        // Obtendo lista de Operadors
        OperadorDAO OperadorDAO = DAOFactoy.getOperadorDAO();
        List<Operador> Operador = OperadorDAO.searchByCpf(pCpf);

        // Valida se Operador foi recuperado
        if (Operador.isEmpty())
            return new OperadorDTO(false, "Nenhum resultado encontrado com o cpf " + pCpf + ".");

        // Retorna o Operador
        return new OperadorDTO(true, "Lista de Operadors recuperada.", Operador);

    }

    // M�todo de altera��o de status
    public static OperadorDTO alterarStatus(Operador pOperador)
    {

        // Valida se Operador informado � nulo
        if (pOperador == null)
            return new OperadorDTO(false, "Operador infomado � nulo.");
        // Acessa camada de persist�ncia
        OperadorDAO operadorDAO = DAOFactoy.getOperadorDAO();

        // Valida se altera��o foi efetuada
        if (operadorDAO.alterarStatus(pOperador))
            return new OperadorDTO(true, "Status do Operador alterado com sucesso");

        return new OperadorDTO(false, "N�o foi possivel alterar status do Operador.");
    }

    // M�todo de pesquisa por nome
    public static OperadorDTO pesquisarPorLogin(String pLogin)
    {
        // Valida se nome � nulo, caso seja, retorna base de Operadors completa.
        if (pLogin == null)
            return new OperadorDTO(false, "Nenhum login informado");

        // Obtendo operador usando o login
        OperadorDAO operadorDAO = DAOFactoy.getOperadorDAO();
        List<Operador> operador = operadorDAO.searchByLogin(pLogin);

        // Valida se objeto est� vazia
        if (operador.isEmpty())
            return new OperadorDTO(false, "Nenhum resultado encontrado com o nome " + pLogin + ".");

        // Retorna o operador
        return new OperadorDTO(true, "Lista de Operadors recuperada.", operador);

    }

}
