package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco
{

    /*
     * Vari�veis de inst�ncia
     */
    @Column(name = "RUA", nullable = false)
    private String rua;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    /*
     * M�todos de acesso
     */

    /**
     * M�todo get para rua
     *
     * @return rua
     */
    public String getRua()
    {
        return rua;
    }

    /**
     * M�todo set para rua
     *
     * @param rua
     */
    public void setRua(String rua)
    {
        this.rua = rua;
    }

    /**
     * M�todo get para numero
     *
     * @return numero
     */
    public String getNumero()
    {
        return numero;
    }

    /**
     * M�todo set para numero
     *
     * @param numero
     */
    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    /**
     * M�todo get para cidade
     *
     * @return cidade
     */
    public String getCidade()
    {
        return cidade;
    }

    /**
     * M�todo set para cidade
     *
     * @param cidade
     */
    public void setCidade(String cidade)
    {
        this.cidade = cidade;
    }

    /**
     * M�todo get para cep
     *
     * @return cep
     */
    public String getCep()
    {
        return cep;
    }

    /**
     * M�todo set para cep
     *
     * @param cep
     */
    public void setCep(String cep)
    {
        this.cep = cep;
    }

    /**
     * M�todo get para bairro
     *
     * @return bairro
     */
    public String getBairro()
    {
        return bairro;
    }

    /**
     * M�todo set para bairro
     *
     * @param bairro
     */
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }

}
