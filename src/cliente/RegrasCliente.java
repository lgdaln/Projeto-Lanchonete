/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import Util.Excecao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lgdal
 */
public class RegrasCliente {

    public void cadastrarCliente(Cliente cliente) throws Exception {

        if (cliente == null) {
            throw new Exception("Informar os dados do cliente");
        }

        if (cliente == null) {
            throw new Excecao("Informar os dados do cliente");
        }

        if (cliente.getNome() == null) {
            throw new Exception("Informar o nome do cliente");
        }
        if (cliente.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do cliente");
        }
        if (cliente.getNome().trim().length() > 200) {
            throw new Exception("O nome do cliente deverá ter menos de 200 caracteres");
        }

        if (cliente.getCpf() == null) {
            throw new Exception("Informar o cpf do cliente");
        }
        if (cliente.getCpf().trim().equals("") == true) {
            throw new Exception("Informar o cpf do cliente");
        }
        if (cliente.getCpf().trim().length() > 200) {
            throw new Exception("O cpf do cliente deverá ter menos de 200 caracteres");
        }

        DadosCliente dadosCliente = new DadosCliente();
        try {
            dadosCliente.cadastrarCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(RegrasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
