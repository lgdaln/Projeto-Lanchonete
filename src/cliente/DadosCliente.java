/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lgdal
 */
public class DadosCliente extends conexao.ConexaoBanco{
    
        public void cadastrarCliente(Cliente cliente) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO cliente (nome, cpf)  VALUES ((?),(?))";
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
    
}
