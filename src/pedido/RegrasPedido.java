/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import java.util.ArrayList;

/**
 *
 * @author lgdal
 */
public class RegrasPedido {

    public void cadastraPedido(Pedido pedido) throws Exception {
        DadosPedido dadosPedido = new DadosPedido();
        dadosPedido.cadastrarPedido(pedido);
    }

    public ArrayList<Pedido> pesquisarPedidoClienteporData(Pedido pedido) throws Exception {
        DadosPedido dadosPedido = new DadosPedido();
        ArrayList<Pedido> listaPedidoCliente = new ArrayList();
        listaPedidoCliente = dadosPedido.pesquisarPedidoClienteporData(pedido);
        return listaPedidoCliente;
    }

    public double valorTotalFechamentoDoDia(Pedido pedido) throws Exception {
        DadosPedido dadosPedido = new DadosPedido();
        double valor = dadosPedido.valorTotalFechamentoDoDia(pedido);
        return valor;
    }

    public ArrayList<Pedido> pesquisarPedidoClienteporCPF(Pedido pedido) throws Exception {
        DadosPedido dadosPedido = new DadosPedido();
        ArrayList<Pedido> listaPedidoCPF = new ArrayList();
        listaPedidoCPF = dadosPedido.pesquisarPedidoClienteporCPF(pedido);
        return listaPedidoCPF;
    }

}
