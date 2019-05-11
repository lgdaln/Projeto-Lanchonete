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

        if (tipo == null) {
            throw new Exception("Informar os dados do tipo");
        }

        if (tipo.getDescricao() == null) {
            throw new Exception("Informar a descrição do tipo");
        }
        if (tipo.getDescricao().trim().equals("") == true) {
            throw new Exception("Informar a descrição do tipo");
        }
        if (tipo.getDescricao().trim().length() > 200) {
            throw new Exception("a descrição deverá ter menos de 200 caracteres");
        }
        
        DadosTipo dadosTipo = new DadosTipo();

        try {
            dadosTipo.cadastrarTipo(tipo);
        } catch (Exception ex) {
            Logger.getLogger(RegrasCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
