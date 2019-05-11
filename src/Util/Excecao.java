/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.swing.JOptionPane;

/**
 *
 * @author lgdal
 */
public class Excecao extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
	
	public Excecao(String msg) {
		super(msg);
                JOptionPane.showMessageDialog(null, msg);

                
    
}
}