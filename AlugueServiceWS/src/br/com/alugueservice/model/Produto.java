package br.com.alugueservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity(name = "TBL_PRODUTO")

public class Produto {

	/*
	 * Vari�veis de inst�ncia
	 */

    @SequenceGenerator(name = "ID_PRODUTO_SEQUENCIA", sequenceName = "ID_PRODUTO_SEQ",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ID_PRODUTO_SEQUENCIA" )
    @Column(name="ID_PRODUTO")

	private Integer idProduto;

    @Column(name="NOME_PRODUTO", nullable = false)
	private String nome;

    @Column(name="VALOR_PRODUTO", nullable = false)
    private Float valor;

    @Column(name="TAMANHO_PRODUTO", nullable = false)
    private String tamanho;

    @Column(name="GENERO_PRODUTO", nullable = false)
    private String genero;

    @Column(name="DESCRICAO_PRODUTO")
	private String descricao;

   @Column(name="STATUS_PRODUTO", nullable = false)
	private Integer status;

   @Column(name="QUANTIDADE_ALUGUEL_PRODUTO")
   private Integer quantidadeAluguel;

   @Column(name="DIRETORIO_IMAGEM_PRODUTO")
   private String diretorioImagem;

   @Column(name="DATA_CRIACAO_PRODUTO", nullable = false)
   private long dataCriacao;


   @Column(name = "ID_OPERADOR", nullable = false)
   private Integer operadorCriador;

	/*
	 * Fun��o construtora
	 */

	public Produto() {

	}

	/*
	 * M�todos de acesso
	 */

	/**
	 * M�todo get para idProduto
	 *
	 * @return idProduto
	 */
	public Integer getIdProduto() {
		return idProduto;
	}

	/**
	 * M�todo set para idProduto
	 *
	 * @param idProduto
	 */
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * M�todo get para nome
	 *
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo set para nome
	 *
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo get para descricao
	 *
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * M�todo set para descricao
	 *
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	/**
	 * M�todo get para valor
	 *
	 * @return valor
	 */
	public Float getValor() {
		return valor;
	}

	/**
	 * M�todo set para valor
	 *
	 * @param valor
	 */
	public void setValor(Float valor) {
		this.valor = valor;
	}

	/**
	 * M�todo get para status
	 *
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * M�todo set para status
	 *
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * M�todo get para tamanho
	 *
	 * @return tamanho
	 */
	public String getTamanho() {
		return tamanho;
	}

	/**
	 * M�todo set para tamanho
	 *
	 * @param tamanho
	 */
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * M�todo get para genero
	 *
	 * @return genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * M�todo set para genero
	 *
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
     * M�todo get para genero
     *
     * @return genero
     */
    public long getDataCriacao() {
        return dataCriacao;
    }

    /**
     * M�todo set para genero
     *
     * @param genero
     */
    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    /**
     * @return the quantidadeAluguel
     */
    public Integer getQuantidadeAluguel()
    {
        return quantidadeAluguel;
    }

    /**
     * @param pQuantidadeAluguel the quantidadeAluguel to set
     */
    public void setQuantidadeAluguel(Integer pQuantidadeAluguel)
    {
        quantidadeAluguel = pQuantidadeAluguel;
    }

    /**
     * @return the diretorioImagem
     */
    public String getDiretorioImagem()
    {
        return diretorioImagem;
    }

    /**
     * @param pDiretorioImagem the diretorioImagem to set
     */
    public void setDiretorioImagem(String pDiretorioImagem)
    {
        diretorioImagem = pDiretorioImagem;
    }

    /**
     * @return the operadorCriador
     */
    public Integer getOperadorCriador()
    {
        return operadorCriador;
    }

    /**
     * @param pOperadorCriador the operadorCriador to set
     */
    public void setOperadorCriador(Integer pOperadorCriador)
    {
        operadorCriador = pOperadorCriador;
    }


}
