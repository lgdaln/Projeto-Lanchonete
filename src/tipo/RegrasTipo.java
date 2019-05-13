/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

import cliente.RegrasCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lgdal
 */
public class RegrasTipo {

    public void cadastrarTipo(Tipo tipo) throws Exception {
        

        DadosTipo dadosTipo = new DadosTipo();

        dadosTipo.cadastrarTipo(tipo);

    }

    public void removerTipo(Tipo tipo) throws Exception {

        DadosTipo dadosTipo = new DadosTipo();

        try {
            dadosTipo.removerTipo(tipo);
        } catch (Exception ex) {
            Logger.getLogger(RegrasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
