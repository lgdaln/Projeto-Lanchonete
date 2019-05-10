package conexao;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        try {
            ConexaoBanco con = new ConexaoBanco();
            con.conectar();
            JOptionPane.showMessageDialog(null, "Conectou");
            con.desconectar();
            JOptionPane.showMessageDialog(null, "desconectou");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
