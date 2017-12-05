
package vistas;

import administrador.admCurso;
import clases.Curso;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class vistaPantallaAjuste extends javax.swing.JFrame {
    admCurso Ajuste= new admCurso ();
    DefaultTableModel modelo = new DefaultTableModel();
    int codigo = 0;
    
    
  
    public vistaPantallaAjuste() {
        initComponents(); 
        modelo.addColumn("codigo"); //le pusimos nombre a la tabla
        modelo.addColumn("curso");
         cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCursoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCurso);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Curso", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
       String nombre = JOptionPane.showInputDialog("Ingrese el Curso");
       if(nombre !=null){
          
       Curso curso= new Curso(0,nombre );
       Ajuste.Agregar(curso);
       modelo.setRowCount(0);
       Ajuste.getListaCurso().clear();
       cargarTabla();
    }    
        
       
       
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCursoMouseClicked
        codigo =Integer.parseInt(modelo.getValueAt(tblCurso.getSelectedRow(), 0).toString()) ;
        
        
    }//GEN-LAST:event_tblCursoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(codigo != 0){
        Ajuste.eliminar(codigo);
        codigo=0; 
        cargarTabla();
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(codigo!=0){
            String curso= JOptionPane.showInputDialog("Ingrese el nuevo nombre");
            if (curso!=null){
            Ajuste.modificar(codigo, curso);
            cargarTabla();
        }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCurso;
    // End of variables declaration//GEN-END:variables
    public void cargarTabla(){ //definimos el metodo
          String[] datos = new String[2]; //creamos un array
          modelo.setRowCount(0);
          Ajuste.ListaCurso().clear();
          for(Curso i:Ajuste.ListaCurso()){ //se utiliza para recorrer una lista
          datos[0]=String.valueOf(i.getId_Curso());
          datos[1]= i.getCurso();
          modelo.addRow(datos);
          
        }
         tblCurso.setModel(modelo);
        }
    public void LimpiarTabla(){
        try {
            Ajuste.getListaCurso().clear();
           for(int i =0; i<=100;i++){
            modelo.removeRow(i);
        }  
        } catch (Exception e) {
        }
       
    }
}
