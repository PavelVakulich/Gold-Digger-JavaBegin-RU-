package ru.javabegin.training.goldman.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.gamemap.adapters.HybridMapLoader;
import ru.javabegin.training.goldman.models.SaveGameTableModel;
import ru.javabegin.training.goldman.objects.MapInfo;
import ru.javabegin.training.goldman.objects.SavedMapInfo;
import ru.javabegin.training.goldman.utils.MessageManager;

public class FrameSavedGames extends BaseChildFrame {

    private HybridMapLoader mapLoader;
    private SaveGameTableModel model;
    private FrameGame frameGame;
    private ArrayList<SavedMapInfo> list;

    public FrameSavedGames(HybridMapLoader mapLoader, FrameGame frameGame) {
        initComponents();
        this.mapLoader = mapLoader;
        this.frameGame = frameGame;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSaves = new javax.swing.JTable();
        btnLoadGame = new javax.swing.JButton();
        jbtnReturn = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jTableSaves.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableSaves.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableSaves);

        btnLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/load_small.png"))); // NOI18N
        btnLoadGame.setText("Загрузить");
        btnLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadGameActionPerformed(evt);
            }
        });

        jbtnReturn.setText("<< в меню");
        jbtnReturn.setName("FrameStat"); // NOI18N
        jbtnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnReturnActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/delete.png"))); // NOI18N
        btnDelete.setText("Удалить");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnReturn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoadGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadGame)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-662)/2, (screenSize.height-420)/2, 662, 420);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnReturnActionPerformed(java.awt.event.ActionEvent evt) {
        closeFrame();
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        int index = jTableSaves.getSelectedRow();

        if (index < 0) {
            return;
        }

        int result = MessageManager.showYesNoMessage(this, "Подтверждаете удаление?");
        switch (result) {
            case JOptionPane.YES_OPTION: {



                MapInfo mapInfo = model.getMapInfo(index);

                mapLoader.deleteSavedMap(mapInfo,LocationType.DB);

                model.deleteMapInfo(index);
                model.refresh();


                break;
            }
            case JOptionPane.NO_OPTION:
            case JOptionPane.CANCEL_OPTION:

        }
    }

    private void btnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {

        int index = jTableSaves.getSelectedRow();

        if (index < 0) {
            return;
        }

        MapInfo mapInfo = model.getMapInfo(index);

        mapLoader.loadMap(mapInfo, LocationType.DB);

        closeFrame();

        frameGame.showFrame(getParentFrame());

    }
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoadGame;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSaves;
    private javax.swing.JButton jbtnReturn;


    @Override
    protected void showFrame(JFrame parent) {

        list = mapLoader.getSavedMapList(mapLoader.getGameMap().getMapInfo().getUser(), LocationType.DB);

        model = new SaveGameTableModel(list);

        jTableSaves.setModel(model);

        jTableSaves.setRowHeight(40);



        super.showFrame(parent);

        if (list.isEmpty()) {
            MessageManager.showErrorMessage(this, "Сохраненных игр не найдено!");
        }

    }
}
