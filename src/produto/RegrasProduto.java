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

        if (produto == null) {
            throw new Exception("Informar os dados do produto");
        }

        if (produto.getNome() == null) {
            throw new Exception("Informar o nome do produto");
        }
        if (produto.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do produto");
        }
        if (produto.getNome().trim().length() > 200) {
            throw new Exception("o nome deverá ter menos de 200 caracteres");
        }

        if (produto.getDisponibilidade() == null) {
            throw new Exception("Informar a disponibilidade do produto");
        }
        if (produto.getDisponibilidade().trim().equals("") == true) {
            throw new Exception("Informar a disponibilidade do produto");
        }       

        try {
            DadosProduto dadosProduto = new DadosProduto();
            dadosProduto.cadastrarProduto(produto);
        } catch (Exception ex) {
            Logger.getLogger(RegrasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
