package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_CLIENTE")
public class Cliente implements IPessoa
{

    /*
     * Vari�veis de inst�ncia
     */

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @SequenceGenerator(name = "ID_CLIENTE", sequenceName = "ID_CLIENTE_SEQ", allocationSize = 1)
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CLIENTE")

    private int      idCliente;

    @Column(name = "NOME_CLIENTE", nullable = false)
    private String   nome;

    @Column(name = "SOBRENOME_CLIENTE", nullable = false)
    private String   sobrenome;

    @Column(name = "CPF_CLIENTE", nullable = false)
    private String   cpf;

    @Column(name = "DATA_NASCIMENTO", nullable = true)
    private long     dataNascimento;

    @Column(name = "EMAIL_CLIENTE", nullable = true)
    private String   email;

    @Column(name = "TELEFONE_CLIENTE")
    private String   telefone;

    @Column(name = "CELULAR_CLIENTE")
    private String   celular;

    @Embedded
    private Endereco endereco;

    @Column(name = "STATUS_CLIENTE", nullable = false)
    private int      status;

    @Column(name = "DATA_CRIACAO_CLIENTE", nullable = true)
    private long     dataCriacao;

    @Column(name = "ID_OPERADOR", nullable = false)
    private Integer  operadorCriador;

    /*
     * Fun��o construtora
     */

    public Cliente()
    {

        endereco = new Endereco();
    }

    /*
     * M�todos de acesso
     */

    /**
     * M�todo get para idCliente
     *
     * @return idCliente
     */

    public int getIdCliente()
    {
        return idCliente;
    }

    /**
     * M�todo set para idCliente
     *
     * @param idCliente
     */
    public void setIdCliente(int idCliente)
    {
        this.idCliente = idCliente;
    }

    /**
     * M�todo get para nome
     *
     * @return nome
     */
    @Override

    public String getNome()
    {
        return nome;
    }

    /**
     * M�todo set para nome
     *
     * @param nome
     */
    @Override
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    /**
     * M�todo get para sobrenome
     *
     * @return sobrenome
     */
    @Override

    public String getSobrenome()
    {
        return sobrenome;
    }

    /**
     * M�todo set para sobrenome
     *
     * @param sobrenome
     */
    @Override
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }

    /**
     * M�todo get para telefone
     *
     * @return telefone
     */
    @Override

    public String getTelefone()
    {
        return telefone;
    }

    /**
     * M�todo set para telefone
     *
     * @param telefone
     */
    @Override
    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    /**
     * M�todo get para celular
     *
     * @return celular
     */
    @Override

    public String getCelular()
    {
        return celular;
    }

    /**
     * M�todo set para celular
     *
     * @param celular
     */
    @Override
    public void setCelular(String celular)
    {
        this.celular = celular;
    }

    /**
     * M�todo get para cpf
     *
     * @return cpf
     */
    @Override

    public String getCpf()
    {
        return cpf;
    }

    /**
     * M�todo set para cpf
     *
     * @param cpf
     */
    @Override
    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    /**
     * M�todo get para endereco
     *
     * @return endereco
     */
    @Override

    public Endereco getEndereco()
    {
        return endereco;
    }

    /**
     * M�todo set para endereco
     *
     * @param endereco
     */
    @Override
    public void setEndereco(Endereco endereco)
    {
        this.endereco = endereco;
    }

    /**
     * M�todo get para status
     *
     * @return status
     */
    @Override

    public int getStatus()
    {
        return status;
    }

    /**
     * M�todoset para status
     *
     * @param status
     */
    @Override
    public void setStatus(int status)
    {
        this.status = status;
    }

    /**
     * M�todo get para quantidadeCupom
     *
     * @return quantidadeCupom
     */

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador
     *            the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }

    public long getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(long pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

    public long getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(long pDataCriacao)
    {
        dataCriacao = pDataCriacao;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    @Override
    public String toString()
    {
        return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", celular=" + celular
                        + ", cpf=" + cpf + ", endereco=" + endereco + ", status=" + status + "]";
    }

}
