package vista;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public final class Hola extends javax.swing.JFrame {

    
    public Hola() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        this.setUndecorated(true);
        initComponents();
        iniciarCarga();
        iniciarSplash();
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.pack();
        
    }

    public void iniciarCarga() { //Utilizando Hilos
        new Thread() {

            @Override
            public void run() {
                int i = 0;
                while (i <= 100) {
                    i++;
                    Progreso.setValue(i);
                    try {
                        sleep(100);
                        //Administrador admin = new Administrador();
                        //admin.setVisible(true);
                        dispose();
                    } catch (Exception e) {
                    }
                }

            }
        }.start();
    }
    //-----------
    public void iniciarSplash() {
        this.getjProgressBar().setBorderPainted(true);
        this.getjProgressBar().setForeground(new Color(100, 10, 150, 250));
        this.getjProgressBar().setStringPainted(true);
    }
    //--------
    public javax.swing.JProgressBar getjProgressBar() {
       return Progreso;
    }
    //--------
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Progreso = new org.edisoncor.gui.progressBar.ProgressBarRect();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(340, 170, 0, 0);
        getContentPane().add(Progreso, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lineas.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -140;
        gridBagConstraints.ipady = -198;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.progressBar.ProgressBarRect Progreso;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
