/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ConexionMySQL;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arkanakin
 */
public class ConsultaMaestros extends javax.swing.JFrame {
    DefaultTableModel modelo; //Modelo de la tabla
    ConexionMySQL mysql;
    String encabezados[] ={"Nombre", "Dirección", "Telefono", "Correo", "País", "Edad", "Sexo"};
    Connection conexion;
    String fila[];
    /**
     * Creates new form ConsultaMaestros
     */
    public ConsultaMaestros() {
        initComponents();
        consulta(); //Llamamos al metodo Yito
    }
    
    public void consulta(){
        String encabezados[] = {"Nombre", "Dirección", "Telefono", "Correo", "País", "Edad", "Sexo"};
        String fila[] = new String[7];
        
        modelo = new DefaultTableModel(null, encabezados);
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM maestros";
        
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            //Valida un unico registro del query
            //rs.first(); //jalar el valor del query
            
            while(rs.next()){
            
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("direccion");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("pais");
                fila[5] = rs.getString("edad");
                fila[6] = rs.getString("sexo");

                modelo.addRow(fila); //asignamos el arreglo al modelo
            } //while
            tblMaestros.setModel(modelo); //asignamos el arreglo a la tabla
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    public void consultaNombre(String nombre){
        
        fila = new String[7];
        
        modelo = new DefaultTableModel(null, encabezados);
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM maestros WHERE nombre LIKE '%"+nombre+"%'";
        
        Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            //Valida un unico registro del query
            //rs.first(); //jalar el valor del query
            
            while(rs.next()){
            
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("direccion");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("pais");
                fila[5] = rs.getString("edad");
                fila[6] = rs.getString("sexo");

                modelo.addRow(fila); //asignamos el arreglo al modelo
            } //while
            tblMaestros.setModel(modelo); //asignamos el arreglo a la tabla
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void consultaEdad(String orden){
        String encabezados[] = {"Nombre", "Dirección", "Telefono", "Correo", "País", "Edad", "Sexo"};
        String fila[] = new String[7];        
        modelo = new DefaultTableModel(null, encabezados);
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection conexion = mysql.conectar();
        
        String query = "SELECT * FROM maestros ORDER BY edad "+orden;
        
       
        
    }
    
    /* Se establecen los metodos generales */
    
    public void definirTabla()
    {
         
         fila = new String[7];        
        modelo = new DefaultTableModel(null, encabezados);
    }
    
    public void conexionMysql()
    {
        mysql = new ConexionMySQL();
         conexion = mysql.conectar();
    }
    
    public void ejecutarQuery(String query)
    {
    
         Statement st;
        try {
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            //Valida un unico registro del query
            //rs.first(); //jalar el valor del query
            
            while(rs.next()){
            
                fila[0] = rs.getString("nombre");
                fila[1] = rs.getString("direccion");
                fila[2] = rs.getString("telefono");
                fila[3] = rs.getString("correo");
                fila[4] = rs.getString("pais");
                fila[5] = rs.getString("edad");
                fila[6] = rs.getString("sexo");

                modelo.addRow(fila); //asignamos el arreglo al modelo
            } //while
            tblMaestros.setModel(modelo); //asignamos el arreglo a la tabla
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        pnlTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaestros = new javax.swing.JTable();
        pnlEncabezado = new javax.swing.JPanel();
        pnlFiltros = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEdad = new javax.swing.JLabel();
        cbxEdad = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEditarNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Maestros");

        pnlTabla.setToolTipText("");

        tblMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaestrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaestros);

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlEncabezado.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout pnlEncabezadoLayout = new javax.swing.GroupLayout(pnlEncabezado);
        pnlEncabezado.setLayout(pnlEncabezadoLayout);
        pnlEncabezadoLayout.setHorizontalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlEncabezadoLayout.setVerticalGroup(
            pnlEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );

        lblNombre.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        lblEdad.setText("Edad");

        cbxEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascendente", "Descendente" }));
        cbxEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEdadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFiltrosLayout = new javax.swing.GroupLayout(pnlFiltros);
        pnlFiltros.setLayout(pnlFiltrosLayout);
        pnlFiltrosLayout.setHorizontalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEdad)
                .addGap(18, 18, 18)
                .addComponent(cbxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlFiltrosLayout.setVerticalGroup(
            pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFiltrosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(cbxEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtEditarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEditarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        consultaNombre(txtNombre.getText()); //con el evento release en el cuadro de texto va buscando cada tecla presionada
    }//GEN-LAST:event_txtNombreKeyReleased

    private void cbxEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEdadActionPerformed
        if(cbxEdad.getSelectedIndex() == 0){
            consultaEdad("ASC");
        }
        if(cbxEdad.getSelectedIndex() == 1){
            consultaEdad("DESC");
        }
    }//GEN-LAST:event_cbxEdadActionPerformed

    private void tblMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaestrosMouseClicked
        //Al seleccionar una fila jala la informacion al campo de texto
        txtEditarNombre.setText(tblMaestros.getModel().getValueAt(tblMaestros.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tblMaestrosMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultaMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaMaestros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxEdad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFiltros;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tblMaestros;
    private javax.swing.JTextField txtEditarNombre;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
