/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 30/03/2012, 15:50:08
 */

package codec;

import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author cristiano.strauss
 */
public class MainFrame extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    public MainFrame() {
   try {
        PlasticLookAndFeel.setPlasticTheme(new DesertBlue());
//        UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
        UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
   } catch (Exception e) {}
    initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        DecodeBinaryMenuItem = new javax.swing.JMenuItem();
        generateMD5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu2.setText("Edição");

        jMenu1.setText("Modo");

        buttonGroup1.add(jRadioButtonMenuItem1);
        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Editor");
        jRadioButtonMenuItem1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonMenuItem1StateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        buttonGroup1.add(jRadioButtonMenuItem2);
        jRadioButtonMenuItem2.setText("Arquivo");
        jMenu1.add(jRadioButtonMenuItem2);

        buttonGroup1.add(jRadioButtonMenuItem3);
        jRadioButtonMenuItem3.setText("Área de Transferência");
        jMenu1.add(jRadioButtonMenuItem3);

        jMenu2.add(jMenu1);
        jMenu2.add(jSeparator1);

        jMenu3.setText("Base64");

        jMenuItem2.setText("Encode");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem1.setText("Decode");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        DecodeBinaryMenuItem.setText("Decode - Arquivo");
        DecodeBinaryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecodeBinaryMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(DecodeBinaryMenuItem);

        jMenu2.add(jMenu3);

        generateMD5.setText("MD5");
        generateMD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateMD5ActionPerformed(evt);
            }
        });
        jMenu2.add(generateMD5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMenuItem1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1StateChanged
        // TODO add your handling code here:
        jTextArea1.setEditable(jRadioButtonMenuItem1.isSelected());
        jMenuItem1.setEnabled(jRadioButtonMenuItem1.isSelected());
    }//GEN-LAST:event_jRadioButtonMenuItem1StateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        byte[] encodeBase64Chunked = Base64.encodeBase64Chunked(sourceData());
        byte[] encodeBase64Chunked = Base64.encodeBase64(sourceData());
        jTextArea1.setText(new String(encodeBase64Chunked));
        //jTextArea1.setText(new String(Hex.encodeHex(encodeBase64Chunked)));
//        if (jRadioButtonMenuItem1.isSelected()) {
//            try {
//                byte[] encodeBase64Chunked = Base64.encodeBase64Chunked(jTextArea1.getText().getBytes("UTF-8"));
//                jTextArea1.setText(new String(Hex.encodeHex(encodeBase64Chunked)));
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void generateMD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateMD5ActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonMenuItem2.isSelected()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(false);
            int showOpenDialog = fileChooser.showOpenDialog(this);
            if (showOpenDialog == JFileChooser.CANCEL_OPTION) {
                return;
            }
            jTextArea1.setText(generateIdentity(fileChooser.getSelectedFile()));
            return;
        } 
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(sourceData());
            jTextArea1.setText(new String(Hex.encodeHex(digest)));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if (jRadioButtonMenuItem1.isSelected()) {
//            try {
//                byte[] digest = MessageDigest.getInstance("MD5").digest(jTextArea1.getText().getBytes("UTF-8"));
//                jTextArea1.setText(new String(Hex.encodeHex(digest)));
//            } catch (NoSuchAlgorithmException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (UnsupportedEncodingException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

    }//GEN-LAST:event_generateMD5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        if (jRadioButtonMenuItem1.isSelected()) {
            try {
                byte[] encodeBase64Chunked = Base64.decodeBase64(jTextArea1.getText().getBytes("UTF-8"));
                jTextArea1.setText(new String(encodeBase64Chunked));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
//            try {
//                byte[] encodeBase64Chunked = Base64.decodeBase64(Hex.decodeHex(jTextArea1.getText().toCharArray()));
//                jTextArea1.setText(new String(encodeBase64Chunked));
//            } catch (DecoderException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void DecodeBinaryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecodeBinaryMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(false);
            int showOpenDialog = fileChooser.showSaveDialog(this);
            if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
                if (fileChooser.getSelectedFile().exists()) {
                    if (JOptionPane.showConfirmDialog(this, "O arquivo selecionado já existe e será sobreposto. Deseja cancelar", "Salvar arquivo", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
                        return;
                    }
                }
                byte[] encodeBase64Chunked = Base64.decodeBase64(jTextArea1.getText().getBytes("UTF-8"));
                org.apache.commons.io.FileUtils.writeByteArrayToFile(fileChooser.getSelectedFile(), encodeBase64Chunked);//readFileToByteArray(fileChooser.getSelectedFile());
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DecodeBinaryMenuItemActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DecodeBinaryMenuItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem generateMD5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private byte[] sourceData() {
        if (jRadioButtonMenuItem1.isSelected()) {
            try {
                return jTextArea1.getText().getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (jRadioButtonMenuItem2.isSelected()) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(false);
            int showOpenDialog = fileChooser.showOpenDialog(this);
            if (showOpenDialog == JFileChooser.CANCEL_OPTION) {
                return new byte[0];
            }
            try {
                return org.apache.commons.io.FileUtils.readFileToByteArray(fileChooser.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return new byte[0];
    }
    public static String generateIdentity(java.io.File documentFile) {
        StringBuffer result = new StringBuffer();
        FileInputStream in = null;
        {
            DigestInputStream md5 = null;
            try {
                in = new FileInputStream(documentFile);
                md5 = new DigestInputStream(in, MessageDigest.getInstance("MD5"));
                byte[] block = new byte[1048576];
                while (md5.read(block, 0, 1048576) != -1) {
                }
                byte[] md5Result = null;
                md5Result = md5.getMessageDigest().digest();
                for (byte b : md5Result) {
                    result.append(String.format("%x", b));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    md5.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result.toString();
    }
}
