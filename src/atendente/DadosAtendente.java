/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import telas.TelaCadastraAtendente;
import tipo.Tipo;

/**
 *
 * @author lgdal
 */
public class DadosAtendente extends conexao.ConexaoBanco {

    void cadastrarAtendente(Atendente atendente) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO atendente (nome)  VALUES (?)";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, atendente.getNome());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();

    }

    public ArrayList<Atendente> listarAtendentes(Atendente atendente) throws Exception {

        ArrayList<Atendente> listaAtendente = new ArrayList<>();

        //instrução sql listando os tipos
        String sql = " select pk_matricula, nome";
        sql += " from atendente ";
        sql += " where atendente.pk_matricula > 0 ";
        if (atendente.getMatricula() > 0) {
            sql += " and atendente.pk_matricula = ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);

        if (atendente.getMatricula() > 0) {
            preparedStatement.setInt(1, atendente.getMatricula());
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Atendente a = new Atendente();
            a.setMatricula(leitor.getInt("pk_matricula"));
            a.setNome(leitor.getString("nome"));

            listaAtendente.add(a);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return listaAtendente;
    }

    public void excluirAtendente(Atendente a) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM atendente WHERE pk_matricula = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, a.getMatricula());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();

    }

}
