/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tipo.Tipo;

/**
 *
 * @author lgdal
 */
public class DadosProduto extends conexao.ConexaoBanco {

    public void cadastrarProduto(Produto p) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO produto (nome, disponibilidade, valor_unitario, fk_cod_tipo) VALUES((?), (?), (?),(?)) ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, p.getNome());
        preparedStatement.setString(2, p.getDisponibilidade());
        preparedStatement.setDouble(3, p.getValorUnitario());
        preparedStatement.setInt(4, p.getTipo().getCod_tipo());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    public ArrayList<Produto> listar(Produto filtro) throws Exception {
        ArrayList<Produto> retorno = new ArrayList<>();

        String sql = " SELECT produto.pk_cod_produto, produto.nome, produto.disponibilidade, produto.valor_unitario, tipo.pk_cod_tipo, tipo.descricao  FROM produto INNER JOIN tipo ON produto.fk_cod_tipo = tipo.pk_cod_tipo WHERE produto.pk_cod_produto>0; ";
        //preparando a instrução
        PreparedStatement preparedStatement = super.conectar().prepareStatement(sql);
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Produto p = new Produto();
            Tipo t = new Tipo();
            p.setCod_produto(leitor.getInt("pk_cod_produto"));
            p.setNome(leitor.getString("nome"));
            p.setDisponibilidade(leitor.getString("disponibilidade"));
            p.setValorUnitario(leitor.getDouble("valor_unitario"));
            t.setCod_tipo(leitor.getInt("pk_cod_tipo"));
            t.setDescricao(leitor.getString("descricao"));
            p.setTipo(t);
            retorno.add(p);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

}
