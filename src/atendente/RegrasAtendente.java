/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atendente;

import cliente.Cliente;

/**
 *
 * @author lgdal
 */
public class RegrasAtendente {

    public void cadastrarAtendente(Atendente atendente) throws Exception {
        DadosAtendente dadosAtendente = new DadosAtendente();
        dadosAtendente.cadastrarAtendente(atendente);
    }


}
