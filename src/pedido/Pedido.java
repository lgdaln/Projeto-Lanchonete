/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import atendente.Atendente;
import cliente.Cliente;
import java.util.Date;

/**
 *
 * @author lgdal
 */
public class Pedido {
    
    private int cod_pedido;
    private Date data;
    private Date hora;
    private String status;
    private String observacao;
    private Cliente cliente;
    private Atendente atendente;

    /**
     * @return the cod_pedido
     */
    public int getCod_pedido() {
        return cod_pedido;
    }

    /**
     * @param cod_pedido the cod_pedido to set
     */
    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the atendente
     */
    public Atendente getAtendente() {
        return atendente;
    }

    /**
     * @param atendente the atendente to set
     */
    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }
    
    
    
}
