package br.com.alugueservice.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "TBL_CUPOM")
public class Cupom
{

    /*
     * Vari�veis de inst�ncia
     */
    @SequenceGenerator(name = "ID_CUPOM", sequenceName = "ID_CUPOM_SEQ", allocationSize = 1)
    @Id
    @Column(name = "ID_CUPOM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_CUPOM")
    private int      idCupom;

    @OneToOne
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente  cliente;

    @OneToOne
    @JoinColumn(name = "ID_OPERADOR", nullable = false)
    private Operador operador;

    @Column(name = "VALOR_CUPOM")
    private float      valor;

    @Column(name = "STATUS_CUPOM")
    private int      status;

    @Column(name = "DATA_INCLUSAO", nullable = false)
    private long     dataInclusao;

    /*
     * M�todos de acesso
     */

    /**
     * M�todo get para idCupom
     *
     * @return idCupom
     */

    public int getIdCupom()
    {
        return idCupom;
    }

    /**
     * @return the valor
     */
    public float getValor()
    {
        return valor;
    }

    /**
     * @param pValor the valor to set
     */
    public void setValor(float pValor)
    {
        valor = pValor;
    }

    /**
     * @return the status
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * @param pStatus the status to set
     */
    public void setStatus(int pStatus)
    {
        status = pStatus;
    }

    /**
     * M�todo set para idCupom
     *
     * @param idCupom
     */
    public void setIdCupom(int idCupom)
    {
        this.idCupom = idCupom;
    }

    /**
     * M�todo get para idCliente
     *
     * @return idCliente
     */

    /**
     * M�todo get para dataInclusao
     *
     * @return dataInclusao
     */

    public long getDataInclusao()
    {
        return dataInclusao;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente()
    {
        return cliente;
    }

    /**
     * @param pCliente
     *            the cliente to set
     */
    public void setCliente(Cliente pCliente)
    {
        cliente = pCliente;
    }

    /**
     * @return the operador
     */
    public Operador getOperador()
    {
        return operador;
    }

    /**
     * @param pOperador
     *            the operador to set
     */
    public void setOperador(Operador pOperador)
    {
        operador = pOperador;
    }

    /**
     * M�todo set para dataInclusao
     *
     * @param dataInclusao
     */
    public void setDataInclusao(long dataInclusao)
    {
        this.dataInclusao = dataInclusao;
    }

    /**
     * M�todo get para statusCupom
     *
     * @return statusCupom
     */

    public int getStatusCupom()
    {
        return status;
    }

    /**
     * M�todo set para statusCupom
     *
     * @param statusCupom
     */
    public void setStatusCupom(int statusCupom)
    {
        this.status = statusCupom;
    }

}
