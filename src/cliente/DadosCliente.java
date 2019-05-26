/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lgdal
 */
public class DadosCliente extends conexao.ConexaoBanco {

    public void cadastrarCliente(Cliente cliente) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = " INSERT INTO cliente (nome, cpf) VALUES ((?),(?)); ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, cliente.getNome());
        preparedStatement.setString(2, cliente.getCpf());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public int retornaIdCliente() throws SQLException, Exception {
        int ultimo = 0;
        try {
            String sql = "select max(pk_cod_cliente) from cliente";
            PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
            ResultSet leitor = preparedStatement.executeQuery();

            while (leitor.next()) {
                ultimo = leitor.getInt("max(pk_cod_cliente)");
            }

            return ultimo;

        } catch (Exception e) {
            e.printStackTrace();
            return 200;
        } finally {
            super.desconectar();

        }

    }


}
