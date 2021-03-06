
package sirh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DocumAConsola extends javax.swing.JFrame {


    public DocumAConsola() {
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
        fecha.setText(fechaActual());
        usuario.setText(Acceso.getClaveUsuario());
        txtNombre.setText(Acceso.getNombreUsuario());
        txtEmpresa.setText(Acceso.getEmpresaUsuario());
        txtRfc.setText(TrabaA.getRfcUsuario());
        txtTrabaja.setText(TrabaA.getNomTrabaja());
        
        String RegFed = TrabaA.getRfcUsuario();
        Limpiar(tabladocum);
        DefaultTableModel modelo=(DefaultTableModel) tabladocum.getModel();
        DocumA e=new DocumA();
        e.LlenarDatos(modelo, RegFed);
        
        tipo.removeAllItems();
        tipo.addItem("");
        DocumA e1=new DocumA();
        e1.LlenarTipo(tipo);
        caracte.setText("");
        causa.removeAllItems();
        causa.addItem("");
        DocumA e2=new DocumA();
        e2.LlenarCausa(causa);
        finicio.setDate(null);
        ftermino.setDate(null);
        path.setText("FTP://SIRH.DYNDNS.ORG/DOCUMENTOS/DOCUMENTOS.GIF");
        observa.setText("");
        status.setText("");
        crear.setEnabled(true);
        tipo.setEnabled(true);
        caracte.setEnabled(true);
    }

    public static String fechaActual(){
        Date fecha= new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return formatoFecha.format(fecha);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladocum = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        caracte = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        causa = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        finicio = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        ftermino = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        path = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        observa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        crear = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEmpresa = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtRfc = new javax.swing.JTextField();
        txtTrabaja = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SNTIAISCRM Sistema de Recursos Humanos");
        setMaximumSize(new java.awt.Dimension(1054, 427));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        tabladocum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Características", "Causa s/Docto", "Inicio", "Término", "Path", "Observaciones", "Status", "Ultima Fecha", "Ultimo Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabladocum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladocumMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladocum);

        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Tipo de Documento:");

        jLabel3.setForeground(new java.awt.Color(204, 0, 51));
        jLabel3.setText("Características:");

        jLabel4.setText("Causa s/Docto:");

        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("Fecha Inicio:");

        jLabel6.setForeground(new java.awt.Color(204, 0, 51));
        jLabel6.setText("Fecha Término:");

        jLabel7.setText("Path Documento:");

        path.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pathMouseClicked(evt);
            }
        });

        jLabel8.setText("Observaciones:");

        jLabel9.setText("Status:");

        jLabel10.setText("Fecha:");

        fecha.setEditable(false);

        jLabel11.setText("Usuario:");

        usuario.setEditable(false);

        status.setEditable(false);

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
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(caracte)
                            .addComponent(causa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(finicio, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(ftermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(observa)
                                    .addComponent(fecha)
                                    .addComponent(usuario)
                                    .addComponent(status))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(caracte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(observa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(causa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(finicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(ftermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(crear)
                .addGap(18, 18, 18)
                .addComponent(actualizar)
                .addGap(18, 18, 18)
                .addComponent(eliminar)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addGap(18, 18, 18)
                .addComponent(salir)
                .addGap(311, 311, 311))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crear)
                    .addComponent(actualizar)
                    .addComponent(eliminar)
                    .addComponent(cancelar)
                    .addComponent(salir))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MOVIMIENTOS DE DOCUMENTACION (Aspirantes)");

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

        txtRfc.setEditable(false);

        txtTrabaja.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        DocumA e=new DocumA();
        String dtipo=tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            tipo.grabFocus();
        }
        else{
            String dcaracte=caracte.getText().toUpperCase();
            if(dcaracte.isEmpty()){
                JOptionPane.showMessageDialog(this, "Se requieren las características del documento (1), verifique .....");
                caracte.grabFocus();
            }
            else{
                if(dcaracte.trim().equals("")){
                    JOptionPane.showMessageDialog(this, "Se requieren las características del documento (2), verifique .....");
                    caracte.setText("");
                    caracte.grabFocus();
                }
                else{
                    if(finicio.getDate() == null){
                        JOptionPane.showMessageDialog(this, "Se requiere la fecha de inicio del documento, verifique .....");
                        finicio.grabFocus();
                    }
                    else{
                        if(ftermino.getDate() == null){
                            JOptionPane.showMessageDialog(this, "Se requiere la fecha de término del documento, verifique .....");
                            ftermino.grabFocus();
                        }
                        else{
                            String dcausa=causa.getSelectedItem().toString();        
                            int añoi=finicio.getCalendar().get(Calendar.YEAR);
                            int mesi=finicio.getCalendar().get(Calendar.MONTH)+1;
                            int diai=finicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                            String dfinicio=(añoi+"/"+mesi+"/"+diai); 
                            int añot=ftermino.getCalendar().get(Calendar.YEAR);
                            int mest=ftermino.getCalendar().get(Calendar.MONTH)+1;
                            int diat=ftermino.getCalendar().get(Calendar.DAY_OF_MONTH);
                            String dftermino=(añot+"/"+mest+"/"+diat);
                            String dpath=path.getText().toUpperCase();
                            String dobserva=observa.getText().toUpperCase();
                            e.Agregar(TrabaA.getRfcUsuario(), dtipo, dcaracte, dcausa, dfinicio, dftermino, dpath, dobserva, Acceso.getClaveUsuario());
                            JOptionPane.showMessageDialog(this, "Registro creado .....");
                            Iniciar();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_crearActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        DocumA e=new DocumA();
        String dtipo=tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            tipo.grabFocus();
        }
        else{
            String dcaracte=caracte.getText().toUpperCase();
            if(dcaracte.isEmpty()){
                JOptionPane.showMessageDialog(this, "Se requieren las características del documento (1), verifique .....");
                caracte.grabFocus();
            }
            else{
                if(dcaracte.trim().equals("")){
                    JOptionPane.showMessageDialog(this, "Se requieren las características del documento (2), verifique .....");
                    caracte.setText("");
                    caracte.grabFocus();
                }
                else{
                    if(finicio.getDate() == null){
                        JOptionPane.showMessageDialog(this, "Se requiere la fecha de inicio del documento, verifique .....");
                        finicio.grabFocus();
                    }
                    else{
                        if(ftermino.getDate() == null){
                            JOptionPane.showMessageDialog(this, "Se requiere la fecha de término del documento, verifique .....");
                            ftermino.grabFocus();
                        }
                        else{
                            String dcausa=causa.getSelectedItem().toString();        
                            int añoi=finicio.getCalendar().get(Calendar.YEAR);
                            int mesi=finicio.getCalendar().get(Calendar.MONTH)+1;
                            int diai=finicio.getCalendar().get(Calendar.DAY_OF_MONTH);
                            String dfinicio=(añoi+"/"+mesi+"/"+diai); 
                            int añot=ftermino.getCalendar().get(Calendar.YEAR);
                            int mest=ftermino.getCalendar().get(Calendar.MONTH)+1;
                            int diat=ftermino.getCalendar().get(Calendar.DAY_OF_MONTH);
                            String dftermino=(añot+"/"+mest+"/"+diat);
                            String dpath=path.getText().toUpperCase();
                            String dobserva=observa.getText().toUpperCase();
                            e.Actualizar(TrabaA.getRfcUsuario(), dtipo, dcaracte, dcausa, dfinicio, dftermino, dpath, dobserva, Acceso.getClaveUsuario());
                            JOptionPane.showMessageDialog(this, "Registro actualizado .....");
                            Iniciar();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        DocumA e=new DocumA();
        String dtipo=tipo.getSelectedItem().toString();
        if(dtipo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Se requiere un tipo de documento, verifique .....");
            Iniciar();
        }
        else{
            e.Eliminar(TrabaA.getRfcUsuario(), dtipo, Acceso.getClaveUsuario());
            JOptionPane.showMessageDialog(this, "Registro eliminado .....");
            Iniciar();
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Iniciar();
    }//GEN-LAST:event_cancelarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void tabladocumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladocumMouseClicked
        DefaultTableModel modelo= (DefaultTableModel) tabladocum.getModel();
        tipo.setSelectedItem(modelo.getValueAt(tabladocum.getSelectedRow(), 0)+"");
        caracte.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 1)+"");
        causa.setSelectedItem(modelo.getValueAt(tabladocum.getSelectedRow(), 2)+"");
        String fecini = (modelo.getValueAt(tabladocum.getSelectedRow(), 3)+"");
        if("null".equals(fecini)){
            System.out.println("La fecha de inicio esta vacia .....");
        }
        else{
            SimpleDateFormat formatofecha1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date fecha1 = formatofecha1.parse(fecini);
                finicio.setDate(fecha1);
            }
            catch(ParseException pe1){
            System.out.println("Error Parse1: "+pe1.getMessage());
            }
        }
        String fecter = (modelo.getValueAt(tabladocum.getSelectedRow(), 4)+"");
        if("null".equals(fecter)){
            System.out.println("La fecha de término esta vacia .....");
        }
        else{
            SimpleDateFormat formatofecha2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date fecha1 = formatofecha2.parse(fecter);
                ftermino.setDate(fecha1);
            }
            catch(ParseException pe2){
                System.out.println("Error Parse2: "+pe2.getMessage());
            }
        }
        path.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 5)+"");
        observa.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 6)+"");
        status.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 7)+"");
        fecha.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 8)+"");
        usuario.setText(modelo.getValueAt(tabladocum.getSelectedRow(), 9)+"");
        crear.setEnabled(false);
        tipo.setEnabled(false);
        caracte.setEnabled(false);
    }//GEN-LAST:event_tabladocumMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void pathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathMouseClicked
        DocumA.setPathUsuario(path.getText().toUpperCase());
        VDocumAConsola object=new VDocumAConsola();
        object.setVisible(true);
    }//GEN-LAST:event_pathMouseClicked

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
            java.util.logging.Logger.getLogger(DocumAConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocumAConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocumAConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocumAConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocumAConsola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField caracte;
    private javax.swing.JComboBox causa;
    private javax.swing.JButton crear;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField fecha;
    private com.toedter.calendar.JDateChooser finicio;
    private com.toedter.calendar.JDateChooser ftermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField observa;
    private javax.swing.JTextField path;
    private javax.swing.JButton salir;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabladocum;
    private javax.swing.JComboBox tipo;
    private javax.swing.JTextField txtEmpresa;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTrabaja;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
