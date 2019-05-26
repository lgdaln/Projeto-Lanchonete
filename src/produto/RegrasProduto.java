/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto;

/**
 *
 * @author lgdal
 */
public class RegrasProduto {
    
    public void cadastrarProduto(Produto produto) throws Exception {
        DadosProduto dadosProduto = new DadosProduto();
        dadosProduto.cadastrarProduto(produto);
    }
    
    public void atualizarProduto(Produto p) throws Exception {
        DadosProduto dadosProduto = new DadosProduto();
        dadosProduto.atualizarProduto(p);
    }
    
}
