package jsetemplate.application.presentation.users;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import jsetemplate.application.business.BusinessFactory;
import jsetemplate.application.business.UserBusiness;
import jsetemplate.application.business.util.datatypes.UserDataType;
import jsetemplate.application.presentation.otros.About;

/**
 *
 * @author mauricio
 */
public class MainUsers extends javax.swing.JFrame {

    //PSeudoAtributos
    private UserBusiness userBusiness = null;
    private List<UserDataType> usersList = null;
    
    private javax.swing.JTable usersTable;
    
    public MainUsers() {
        initComponents();        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //Custom settings
        this.setLocationRelativeTo(null);              
        
        userBusiness = BusinessFactory.getUserBusiness();        
        
        setUpUserTable();
        loadUserTable();
    }
    
    private void setUpUserTable(){
        usersTable = new JTable()
        {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);
                
                if (!isRowSelected(row))
                {

                }
                
                this.setBackground(Color.GREEN);
                return c;
            }
        };
        scrollerPanelUsersTable.setViewportView(usersTable);
    }
    
    private void loadUserTable(){
        
        usersList = userBusiness.findAllUsers();
        List<Object[]> datos = new ArrayList<>();
        for (UserDataType d : this.usersList){
            datos.add(new Object[] {d, d.getName(), d.getSurname(), d.getRole().getName()});
        }
        
        updateTablaCertificados(datos.toArray(new Object[][] {}));        
    }
    
    private void updateTablaCertificados(Object datos[][]){
        usersTable.setModel(
            new DefaultTableModel(datos, new String [] {"User Id", "Name", "Surname", "Role"}) {
            Class[] types = new Class[] {String.class,UserDataType.class,String.class,String.class}; 
            boolean[] canEdit = new boolean[] {false,false,false,false};
            @Override
            public Class getColumnClass(int columnIndex){ return types [columnIndex];}
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit [columnIndex];}
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        scrollerPanelUsersTable = new javax.swing.JScrollPane();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        informacionSoftware = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CertificAlert! v1.0");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        PanelPrincipal.setBackground(new java.awt.Color(76, 85, 121));

        scrollerPanelUsersTable.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N

        newButton.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 250, 250));
        titulo.setText("System Users");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(scrollerPanelUsersTable, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newButton)
                    .addComponent(titulo))
                .addGap(27, 27, 27)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollerPanelUsersTable, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(PanelPrincipal);

        jMenuBar1.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N

        menuArchivo.setText("File");
        menuArchivo.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuArchivo.add(jMenuItem1);

        jMenuBar1.add(menuArchivo);

        menuAyuda.setText("Help");
        menuAyuda.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N

        informacionSoftware.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        informacionSoftware.setText("About...");
        informacionSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionSoftwareActionPerformed(evt);
            }
        });
        menuAyuda.add(informacionSoftware);

        jMenuBar1.add(menuAyuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit(){
        int result = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you wanna go??",
            "Close JSE desktop template",
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
            this.dispose();
            System.exit(0);
        }        
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exit();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        exit();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void informacionSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionSoftwareActionPerformed
        About acd = new About(this, true);
        acd.setVisible(true);
    }//GEN-LAST:event_informacionSoftwareActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
       NewUser cc = new NewUser(this, true);
       cc.setVisible(true);
       loadUserTable();
    }//GEN-LAST:event_newButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if (usersTable.getSelectedRow() != -1){
            
            UserDataType dt = (UserDataType)usersTable.getValueAt(usersTable.getSelectedRow(), 0);   
            UpdateUser nu = new UpdateUser(this, true, dt);
            nu.setVisible(true);
            
            usersList = userBusiness.findAllUsers();
            loadUserTable();
        } else {
            JOptionPane.showMessageDialog((Frame)this.getParent(), "Select a user to edit");
        }        
    }//GEN-LAST:event_editButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton editButton;
    private javax.swing.JMenuItem informacionSoftware;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JButton newButton;
    private javax.swing.JScrollPane scrollerPanelUsersTable;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
