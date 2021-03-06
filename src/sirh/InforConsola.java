
package sirh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InforConsola extends javax.swing.JFrame {


    public InforConsola() {
        initComponents();
        setDefaultCloseOperation(0);
        Iniciar();
    }
    
    private void Limpiar(JTable tabla){
        while(tabla.getRowCount()>0){
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    }
    
    private void Iniciar(){
        Limpiar(tablainfor);
        DefaultTableModel modelo=(DefaultTableModel) tablainfor.getModel();
        Infor e1=new Infor();
        e1.LlenarDatos(modelo);
        tipo.removeAllItems();
        tipo.addItem("");
        Infor e2=new Infor();
        e2.LlenarTipo(tipo);
        fecdoc.setDate(null);
        cveemp.removeAllItems();
        cveemp.addItem("");
        Infor e3=new Infor();
        e3.LlenarCveemp(cveemp);
        nomemp.setText("");
        resumen.setText("");
        path.setText("FTP://SIRH.DYNDNS.ORG/INFORMACION/INFORMACION.GIF");
        
        fecha.setText(fechaActual());
        usuario.setText(Acceso.getClaveUsuario());
        txtNombre.setText(Acceso.getNombreUsuario());
        txtEmpresa.setText(Acceso.getEmpresaUsuario());
        crear.setEnabled(true);
        tipo.setEnabled(true);
        fecdoc.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablainfor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        fecdoc = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cveemp = new javax.swing.JComboBox();
        nomemp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        resumen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        crear = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNTIAISCRM Sistema de Recursos Humanos");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MOVIMIENTOS DE INFORMACION");

        txtEmpresa.setEditable(false);
        txtEmpresa.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtEmpresa.setForeground(new java.awt.Color(204, 0, 0));
        txtEmpresa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtEmpresa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(204, 0, 0));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tablainfor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Fecha Docto", "Clave Empresa", "Nombre Empresa", "Resumen", "Path Docto", "Status", "Ultima Fecha", "Ultimo Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablainfor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablainforMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablainfor);

        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Tipo de Documento:");

        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Fecha Documento:");

        jLabel4.setText("Empresa:");

        cveemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cveempActionPerformed(evt);
            }
        });

        nomemp.setEditable(false);

        jLabel5.setText("Resumen Documento:");

        jLabel6.setText("Path Documento:");

        path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathMouseClicked(evt);
            }
        });

        jLabel8.setText("Fecha:");

        fecha.setEditable(false);

        jLabel9.setText("Usuario:");

        usuario.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecdoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cveemp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomemp))
                            .addComponent(resumen)
                            .addComponent(path)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(usuario)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(fecdoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cveemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(resumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        crear.setText("Crear");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(crear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crear)
                    .addComponent(actualizar)
                    .addComponent(eliminar)
                    .addComponent(cancelar)
                    .addComponent(salir))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablainforMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablainforMouseClicked
        DefaultTableModel modelo= (DefaultTableModel) tablainfor.getModel();
        tipo.setSelectedItem(modelo.getValueAt(tablainfor.getSelectedRow(), 0)+"");
        String finf = (modelo.getValueAt(tablainfor.getSelectedRow(), 1)+"");
        if("null".equals(finf)){
            System.out.println("La fecha de la información esta vacia .....");
        }
        else{
            SimpleDateFormat formatofecha1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date fecha1 = formatofecha1.parse(finf);
                fecdoc.setDate(fecha1);
            }
            catch(ParseException pe1){
            System.out.println("Error Parse1: "+pe1.getMessage());
            }
        }
        cveemp.setSelectedItem(modelo.getValueAt(tablainfor.getSelectedRow(), 2)+"");
        nomemp.setText(modelo.getValueAt(tablainfor.getSelectedRow(), 3)+"");
        resumen.setText(modelo.getValueAt(tablainfor.getSelectedRow(), 4)+"");
        path.setText(modelo.getValueAt(tablainfor.getSelectedRow(), 5)+"");
        fecha.setText(modelo.getValueAt(tablainfor.getSelectedRow(), 7)+"");
        usuario.setText(modelo.getValueAt(tablainfor.getSelectedRow(), 8)+"");
        crear.setEnabled(false);
        tipo.setEnabled(false);
        fecdoc.setEnabled(false);
    }//GEN-LAST:event_tablainforMouseClicked

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        Infor e=new Infor();
        String dtipo = tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            tipo.grabFocus();
        }
        else{
            String dcveemp = cveemp.getSelectedItem().toString();
            if(dcveemp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Se requiere una empresa, verifique .....");
                cveemp.grabFocus();
            }
            else{
                if(fecdoc.getDate() == null){
                    JOptionPane.showMessageDialog(this, "Se requiere la fecha del documento, verifique .....");
                    fecdoc.grabFocus();
                }
                else{
                    int año=fecdoc.getCalendar().get(Calendar.YEAR);
                    int mes=fecdoc.getCalendar().get(Calendar.MONTH)+1;
                    int dia=fecdoc.getCalendar().get(Calendar.DAY_OF_MONTH);
                    String dfecdoc=(año+"/"+mes+"/"+dia);
                    String dnomemp=nomemp.getText().toUpperCase();
                    String dresumen=resumen.getText().toUpperCase();
                    String dpath=path.getText().toUpperCase();
                    e.Agregar(dtipo, dfecdoc, dcveemp, dnomemp, dresumen, dpath, Acceso.getClaveUsuario());
                    JOptionPane.showMessageDialog(this, "Registro creado .....");
                    Iniciar();
                }
            }
        }
    }//GEN-LAST:event_crearActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        Infor e=new Infor();
        String dtipo = tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            tipo.grabFocus();
        }
        else{
            String dcveemp = cveemp.getSelectedItem().toString();
            if(dcveemp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Se requiere una empresa, verifique .....");
                cveemp.grabFocus();
            }
            else{
                if(fecdoc.getDate() == null){
                    JOptionPane.showMessageDialog(this, "Se requiere la fecha del documento, verifique .....");
                    fecdoc.grabFocus();
                }
                else{
                    int año=fecdoc.getCalendar().get(Calendar.YEAR);
                    int mes=fecdoc.getCalendar().get(Calendar.MONTH)+1;
                    int dia=fecdoc.getCalendar().get(Calendar.DAY_OF_MONTH);
                    String dfecdoc=(año+"/"+mes+"/"+dia);
                    String dnomemp=nomemp.getText().toUpperCase();
                    String dresumen=resumen.getText().toUpperCase();
                    String dpath=path.getText().toUpperCase();
                    e.Actualizar(dtipo, dfecdoc, dcveemp, dnomemp, dresumen, dpath, Acceso.getClaveUsuario());
                    JOptionPane.showMessageDialog(this, "Registro actualizado .....");
                    Iniciar();
                }
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Infor e=new Infor();
        String dtipo = tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            tipo.grabFocus();
        }
        else{
            String dcveemp = cveemp.getSelectedItem().toString();
            if(dcveemp.isEmpty()){
                JOptionPane.showMessageDialog(this, "Se requiere una empresa, verifique .....");
                cveemp.grabFocus();
            }
            else{
                if(fecdoc.getDate() == null){
                    JOptionPane.showMessageDialog(this, "Se requiere la fecha del documento, verifique .....");
                    fecdoc.grabFocus();
                }
                else{
                    int año=fecdoc.getCalendar().get(Calendar.YEAR);
                    int mes=fecdoc.getCalendar().get(Calendar.MONTH)+1;
                    int dia=fecdoc.getCalendar().get(Calendar.DAY_OF_MONTH);
                    String dfecdoc=(año+"/"+mes+"/"+dia);
                    e.Eliminar(dtipo, dfecdoc, dcveemp, Acceso.getClaveUsuario());
                    JOptionPane.showMessageDialog(this, "Registro eliminado .....");
                    Iniciar();
                }
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Iniciar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void cveempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cveempActionPerformed
        String claveseleccionada=cveemp.getSelectedItem()+"";
        Infor e=new Infor();
        Object[] datos=e.Datos(claveseleccionada);
        nomemp.setText(datos[0]+"");
    }//GEN-LAST:event_cveempActionPerformed

    private void pathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathMouseClicked
        Infor.setPathUsuario(path.getText().toUpperCase());
        VInforConsola object=new VInforConsola();
        object.setVisible(true);
    }//GEN-LAST:event_pathMouseClicked

    public static String fechaActual(){
        Date fecha= new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatoFecha.format(fecha);
    }
    
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
            java.util.logging.Logger.getLogger(InforConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InforConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InforConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InforConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InforConsola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton crear;
    private javax.swing.JComboBox cveemp;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fecdoc;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomemp;
    private javax.swing.JTextField path;
    private javax.swing.JTextField resumen;
    private javax.swing.JButton salir;
    private javax.swing.JTable tablainfor;
    private javax.swing.JComboBox tipo;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
