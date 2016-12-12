package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_CONFIGURACAO")
public class Configuracao {

	/*
	 * Vari�veis de inst�ncia
	 */
    @Id
    @SequenceGenerator(name = "ID_CONFIGURACAO", sequenceName = "ID_CONF_SEQ", allocationSize = 1)
    @Column(name="ID_CONFIGURACAO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ID_CONFIGURACAO" )
	private Integer idConfiguracao;

    @Column(name="MULTA_VALOR")
	private Float multa;

    @Column(name="CUPOM_VALOR")
	private Float cupom;

    @Column(name="CONTRATO")
	private String contrato;

	/*
	 * Fun��o construtora
	 */

	public Configuracao() {

	}

	/*
	 * M�todos de acesso
	 */

	/**
	 * M�todo get para idConf
	 *
	 * @return idConf
	 */

	public Integer getIdConfiguracao() {
		return idConfiguracao;
	}

	/**
	 * M�todo set para idConf
	 *
	 * @param idConf
	 */
	public void setIdConfiguracao(Integer idConfiguracao) {
		this.idConfiguracao = idConfiguracao;
	}

	/**
	 * M�todo get para multa
	 *
	 * @return multa
	 */

	public Float getMulta() {
		return multa;
	}

	/**
	 * M�todo set para multa
	 *
	 * @param multa
	 */
	public void setMulta(Float multa) {
		this.multa = multa;
	}

	/**
	 * M�todo get para cupom
	 *
	 * @return cupom
	 */

	public Float getCupom() {
		return cupom;
	}

	/**
	 * M�todo set para cupom
	 *
	 * @param cupom
	 */
	public void setCupom(Float cupom) {
		this.cupom = cupom;
	}

    /**
     * @return the contrato
     */

    public String getContrato()
    {
        return contrato;
    }

    /**
     * @param pContrato the contrato to set
     */
    public void setContrato(String pContrato)
    {
        contrato = pContrato;
    }

}
