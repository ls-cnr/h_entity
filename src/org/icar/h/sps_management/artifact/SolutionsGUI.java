package org.icar.h.sps_management.artifact;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author luca
 */
public class SolutionsGUI extends javax.swing.JFrame {
    private DefaultListModel solution_model;
    //private ActionListener execute_listener;
    private int selected = -1;
    //private int selected_to_be_executed = -1;

    public int getSelectedForExecution() {
        return selected;
    }

    /**
     * Creates new form SolutionsGUI
     * @param solution_model
     */
    public SolutionsGUI(DefaultListModel solution_model)  {
        this.solution_model = solution_model;
        //this.execute_listener = execute_listener;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SolutionList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        ExecuteButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        SelectedTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Commander GUI - Solution Selector");

        MainPanel.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 400));

        SolutionList.setModel(solution_model);
        SolutionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        SolutionList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                SolutionListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(SolutionList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        MainPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

        ExecuteButton.setText("Execute");
        jPanel2.add(ExecuteButton);

        MainPanel.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jLabel1.setText("selected:");
        jPanel3.add(jLabel1);

        SelectedTextField.setText("none");
        SelectedTextField.setPreferredSize(new java.awt.Dimension(150, 26));
        jPanel3.add(SelectedTextField);

        MainPanel.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DefaultListModel solution_model = new DefaultListModel();
                ActionListener execute_listener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Pressed");
                    }
                };
                solution_model.addElement("solution1");
                solution_model.addElement("solution2");
                solution_model.addElement("solution3");
                solution_model.addElement("solution4");
                SolutionsGUI frame = new SolutionsGUI(solution_model);

                frame.setVisible(true);
            }
        });
    }

    public javax.swing.JButton getSelectButton() {
        return ExecuteButton;
    }

    private void SolutionListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
        selected = SolutionList.getSelectedIndex();
        if (selected != -1) {
            SelectedTextField.setText(solution_model.elementAt(selected).toString());
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton ExecuteButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTextField SelectedTextField;
    private javax.swing.JList SolutionList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}