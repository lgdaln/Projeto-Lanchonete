/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedido;

import atendente.Atendente;
import cliente.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import produto.Produto;
import tipo.Tipo;

/**
 *
 * @author lgdal
 */
public class DadosPedido extends conexao.ConexaoBanco {

    public void cadastrarPedido(Pedido p) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO pedido (data, observacao, fk_cod_produto, valorAtual, fk_cod_cliente, fk_matricula, quantidade, hora, statusp) VALUES((?),(?),(?),(?),(?), ?, ?, ?, ?) ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setDate(1, (Date) p.getData());
        preparedStatement.setString(2, p.getObservacao());
        preparedStatement.setInt(3, p.getProduto().getCod_produto());
        preparedStatement.setDouble(4, p.getProduto().getValorUnitario());
        preparedStatement.setInt(5, p.getCliente().getCod_cliente());
        preparedStatement.setInt(6, p.getAtendente().getMatricula());
        preparedStatement.setInt(7, p.getQuantidade());
        preparedStatement.setString(8, p.getHora());
        preparedStatement.setString(9, p.getStatus());

        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();

    }

    public double valorTotalFechamentoDoDia(Pedido p) throws SQLException, Exception {
        double ultimo = 0;

        try {
            String sql = "SELECT  SUM(valorAtual)  FROM pedido WHERE data = (?)";
            //preparando a instrução
            PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

            //passando os valores para os parametros
            preparedStatement.setDate(1, (Date) p.getData());
            //preparedStatement.setDate(2, (java.sql.Date) i.getDataFinal());

            ResultSet leitor = preparedStatement.executeQuery();

            while (leitor.next()) {
                ultimo = leitor.getDouble("SUM(valorAtual)");
            }

            return ultimo;

        } catch (Exception e) {
            e.printStackTrace();
            return 200;
        } finally {
            super.desconectar();

        }

    }

    public ArrayList<Pedido> pesquisarPedidoClienteporData(Pedido p) throws SQLException {

        ArrayList<Pedido> listaPedidoCliente = new ArrayList();
        Cliente cliente = new Cliente();
        Pedido pedido = new Pedido();

        try {
            String sql = "SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao,pedido.quantidade , pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto WHERE pedido.data = ? ";

            PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

            preparedStatement.setDate(1, (Date) p.getData());

            ResultSet leitor = preparedStatement.executeQuery();

            while (leitor.next()) {
                cliente = new Cliente();
                pedido = new Pedido();
                Produto produto = new Produto();

                produto.setNome(leitor.getString("nomeProduto"));
                pedido.setProduto(produto);

                cliente.setNome(leitor.getString("nomeCliente"));
                pedido.setCliente(cliente);

                pedido.setQuantidade(leitor.getInt("quantidade"));

                pedido.setValorAtual(leitor.getDouble("valorAtual"));

                listaPedidoCliente.add(pedido);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.desconectar();
        }
        return listaPedidoCliente;
    }

    public ArrayList<Pedido> pesquisarPedidoClientePendentes() throws Exception {
        ArrayList<Pedido> retorno = new ArrayList<>();

        String sql = " SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.fk_cod_cliente, pedido.fk_cod_produto, pedido.statusp, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo, atendente.nome AS nomeAtendente, pedido.quantidade FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto  INNER JOIN atendente ON pedido.fk_matricula = atendente.pk_matricula  AND pedido.statusp <> 'entregue' ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Cliente cliente = new Cliente();
            Pedido pedido = new Pedido();
            Atendente atendente = new Atendente();
            Produto produto = new Produto();
            pedido.setCod_pedido(leitor.getInt("pk_cod_pedido"));
            pedido.setStatus(leitor.getString("statusp"));
            produto.setNome(leitor.getString("nomeProduto"));
            pedido.setProduto(produto);
            cliente.setNome(leitor.getString("nomeCliente"));
            pedido.setCliente(cliente);
            atendente.setNome(leitor.getString("nomeAtendente"));
            pedido.setAtendente(atendente);
            pedido.setQuantidade(leitor.getInt("quantidade"));
            pedido.setData(leitor.getDate("data"));
            pedido.setHora(leitor.getString("hora"));
            pedido.setObservacao(leitor.getString("observacao"));

            retorno.add(pedido);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

    public void atualizarStatus(Pedido p) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE pedido SET statusp = ? WHERE pk_cod_pedido = ? ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, p.getStatus());
        preparedStatement.setInt(2, p.getCod_pedido());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public void atualizarAtendente(Pedido p) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE pedido SET fk_matricula = ? WHERE pk_cod_pedido = ? ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, p.getAtendente().getMatricula());
        preparedStatement.setInt(2, p.getCod_pedido());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public void removerPedido(Pedido p) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM pedido WHERE pk_cod_pedido = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, p.getCod_pedido());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public ArrayList<Pedido> pesquisarPedidoClienteporCPF(Pedido p) throws SQLException {

        ArrayList<Pedido> listaPedidoCliente = new ArrayList();
        Cliente cliente = new Cliente();
        Pedido pedido = new Pedido();

        try {
            String sql = "SELECT pedido.pk_cod_pedido, pedido.data, pedido.hora, pedido.observacao, pedido.valorAtual, pedido.statusp, pedido.fk_cod_cliente, pedido.fk_cod_produto, cliente.pk_cod_cliente, cliente.cpf, cliente.nome AS nomeCliente, produto.pk_cod_produto, produto.nome AS nomeProduto, produto.disponibilidade, produto.valor_unitario, produto.fk_cod_tipo FROM pedido INNER JOIN cliente ON pedido.fk_cod_cliente = cliente.pk_cod_cliente INNER JOIN produto ON pedido.fk_cod_produto = produto.pk_cod_produto WHERE pedido.fk_cod_cliente = (SELECT pk_cod_cliente FROM cliente WHERE cpf = ? )  AND pedido.statusp <> 'entregue' ";

            PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

            preparedStatement.setString(1, p.getCliente().getCpf());

            ResultSet leitor = preparedStatement.executeQuery();

            while (leitor.next()) {
                cliente = new Cliente();
                pedido = new Pedido();
                Produto produto = new Produto();

                produto.setNome(leitor.getString("nomeProduto"));
                pedido.setProduto(produto);

                pedido.setStatus(leitor.getString("statusp"));

                listaPedidoCliente.add(pedido);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.desconectar();
        }
        return listaPedidoCliente;
    }

}
