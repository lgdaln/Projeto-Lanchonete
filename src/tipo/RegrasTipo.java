/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipo;

/**
 *
 * @author lgdal
 */
public class RegrasTipo {

    public void cadastrarTipo(Tipo tipo) throws Exception {

        DadosTipo dadosTipo = new DadosTipo();
        dadosTipo.cadastrarTipo(tipo);
    }
    

}
