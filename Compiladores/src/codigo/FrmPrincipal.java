/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author Anderson
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtEntradaLex.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA -> " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtResultado.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += " LINEA -> " + cont + "\n";
                    break;
                case Set:
                    resultado += " <Reservada Set>\t" + lexer.lexeme + "\n";
                    break;
                case Puts:
                    resultado += " <Reservada Puts>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += " <Reservada If>\t\t" + lexer.lexeme + "\n";
                    break;
                case Then:
                    resultado += " <Reservada Then>\t\t" + lexer.lexeme + "\n";
                    break;
                case Elseif:
                    resultado += " <Reservada Elseif>\t\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += " <Reservada Else>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += " <Operador Booleano>\t" + lexer.lexeme + "\n";
                    break;
                case And:
                    resultado += " <Operador logico And>\t" + lexer.lexeme + "\n";
                    break;
                case Or:
                    resultado += " <Operador logico Or>\t" + lexer.lexeme + "\n";
                    break;
                case Not:
                    resultado += " <Operador logico Not>\t" + lexer.lexeme + "\n";
                    break;
                case Switch:
                    resultado += " <Reservada Switch>\t" + lexer.lexeme + "\n";
                    break;
                case Default:
                    resultado += " <Reservada Default>\t\t" + lexer.lexeme + "\n";
                    break;
                case Continue:
                    resultado += " <Reservada Continue>\t" + lexer.lexeme + "\n";
                    break;
                case Break:
                    resultado += " <Reservada Break>\t\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += " <Reservada For>\t" + lexer.lexeme + "\n";
                    break;
                case Proc:
                    resultado += " <Reservada Proc>\t" + lexer.lexeme + "\n";
                    break;
                case Return:
                    resultado += " <Reservada Return>\t" + lexer.lexeme + "\n";
                    break;
                case Incr:
                    resultado += " <Reservada Incremental>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += " <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += " <Reservada While>\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += " <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case Dolar:
                    resultado += " <Reservada $>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += " <Cadena de texto>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += " <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += " <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_a:
                    resultado += " <Corchete de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Corchete_c:
                    resultado += " <Corchete de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += " <punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Expr:
                    resultado += " <Reservada Expr>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += " <Signo suma>\t\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += " <Signo Multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += " <Signo Division>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += " <Signo Resta>\t\t" + lexer.lexeme + "\n";
                    break;
                case Menor:
                    resultado += " <Signo Menor>\t\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += " <Signo Igual>\t\t" + lexer.lexeme + "\n";
                    break;
                case Menor_igual:
                    resultado += " <Signo Menor igual>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor:
                    resultado += " <Signo Mayor>\t\t" + lexer.lexeme + "\n";
                    break;
                case Mayor_igual:
                    resultado += " <Signo Mayor igual>\t" + lexer.lexeme + "\n";
                    break;
                case Comillas:
                    resultado += " <Comillas \"\\\"\" >\t" + lexer.lexeme + "\n";
                    break;
                case Igual_que:
                    resultado += " <Igual que >\t\t" + lexer.lexeme + "\n";
                    break;
                case No_igual_que:
                    resultado += " <No igual que >\t\t" + lexer.lexeme + "\n";
                    break;
                case Listado_si:
                    resultado += " <cadena en listado>\t\t" + lexer.lexeme + "\n";
                    break;
                case Listado_no:
                    resultado += " <cadano no en listado >\t\t" + lexer.lexeme + "\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAdjuntarLex = new javax.swing.JButton();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEntradaLex = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnAnalizadorSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSintactico = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Analizador Lexico"));

        btnAdjuntarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAdjuntarLex.setText("Adjuntar");
        btnAdjuntarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntarLexActionPerformed(evt);
            }
        });

        btnAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        txtEntradaLex.setColumns(20);
        txtEntradaLex.setRows(5);
        jScrollPane3.setViewportView(txtEntradaLex);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdjuntarLex)
                .addGap(43, 43, 43)
                .addComponent(btnAnalizarLex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiarLex)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarLex)
                    .addComponent(btnAdjuntarLex)
                    .addComponent(btnLimpiarLex))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Analizador Sintactico"));

        btnAnalizadorSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizadorSin.setText("Analizar");
        btnAnalizadorSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizadorSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        txtSintactico.setColumns(20);
        txtSintactico.setRows(5);
        jScrollPane2.setViewportView(txtSintactico);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnAnalizadorSin)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiarSin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizadorSin)
                    .addComponent(btnLimpiarSin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizadorSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizadorSinActionPerformed
        // TODO add your handling code here:
        String ST = txtEntradaLex.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtSintactico.setText("Analisis realizado correctamente");
            txtSintactico.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtSintactico.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"" + "\n" + "Proceso finalizado sin exito");
            txtSintactico.setForeground(Color.RED);
        }
    }//GEN-LAST:event_btnAnalizadorSinActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        // TODO add your handling code here:
        txtSintactico.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtResultado.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            // TODO add your handling code here:
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAdjuntarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntarLexActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());

        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtEntradaLex.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdjuntarLexActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjuntarLex;
    private javax.swing.JButton btnAnalizadorSin;
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtEntradaLex;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextArea txtSintactico;
    // End of variables declaration//GEN-END:variables
}
