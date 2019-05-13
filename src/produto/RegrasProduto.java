/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

import cliente.RegrasCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lgdal
 */
public class RegrasProduto {

    public void cadastrarProduto(Produto produto) throws Exception {
        DadosProduto dadosProduto = new DadosProduto();
        dadosProduto.cadastrarProduto(produto);
    }

    public void editarProduto(Produto produto) throws Exception {
        DadosProduto dadosProduto = new DadosProduto();
        dadosProduto.atualizarPrpoduto(produto);
    }

    public void removerProduto(Produto produto) throws Exception {
        DadosProduto dadosProduto = new DadosProduto();
        dadosProduto.removerProduto(produto);
    }

}
