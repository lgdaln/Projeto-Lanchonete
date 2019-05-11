/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lgdal
 */
public class DadosTipo extends conexao.ConexaoBanco {

    public void cadastrarTipo(Tipo tipo) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO tipo (descricao)  VALUES (?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, tipo.getDescricao());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public ArrayList<Tipo> listarTipo(Tipo tipo) throws Exception {

        ArrayList<Tipo> listaTipo = new ArrayList<>();

        //instrução sql listando os tipos
        String sql = " select pk_cod_tipo, descricao";
        sql += " from tipo ";
        sql += " where tipo.pk_cod_tipo > 0 ";
        if (tipo.getCod_tipo() > 0) {
            sql += " and tipo.pk_cod_tipo = ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (tipo.getCod_tipo() > 0) {
            preparedStatement.setInt(1, tipo.getCod_tipo());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Tipo t = new Tipo();
            t.setCod_tipo(leitor.getInt("pk_cod_tipo"));
            t.setDescricao(leitor.getString("descricao"));

            listaTipo.add(t);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return listaTipo;
    }

    public void removerTipo(Tipo t) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM tipo WHERE pk_cod_tipo = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, t.getCod_tipo());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

}
