package ru.javabegin.training.goldman.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import ru.javabegin.training.goldman.listeners.interfaces.CloseFrameListener;
import ru.javabegin.training.goldman.models.ScoreTableModel;
import ru.javabegin.training.goldman.objects.UserScore;

public class FrameStat extends BaseChildFrame implements ActionListener {

    private ArrayList<UserScore> list;
    private CloseFrameListener closeFrameListener;

    public FrameStat() {
        initComponents();
    }

    public FrameStat(CloseFrameListener closeFrameListener) {
        this.closeFrameListener = closeFrameListener;
        initComponents();
    }

    public void setList(ArrayList<UserScore> list) {
        this.list = list;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Статистика");

        jbtnBack.setText("<< назад");
        jbtnBack.setName("FrameStat"); // NOI18N
        jbtnBack.addActionListener(this);

        jTableStat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableStat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnBack)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-647)/2, (screenSize.height-399)/2, 647, 399);
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jbtnBack) {
            FrameStat.this.jbtnBackActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {
        closeFrame();
    }
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableStat;
    private javax.swing.JButton jbtnBack;

    @Override
    protected void showFrame(JFrame parent) {

        jTableStat.setModel(new ScoreTableModel(list));

        jTableStat.setRowHeight(40);

        super.showFrame(parent);

    }

    @Override
    protected void closeFrame() {
        super.closeFrame();
        if (closeFrameListener!=null){
            onClose(closeFrameListener);
        }

    }

    private void onClose(CloseFrameListener closeFrameListener) {
        closeFrameListener.onCloseAction();
    }
}
