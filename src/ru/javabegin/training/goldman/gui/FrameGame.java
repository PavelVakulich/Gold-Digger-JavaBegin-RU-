package ru.javabegin.training.goldman.gui;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gamemap.facades.GameFacade;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.listeners.interfaces.CloseFrameListener;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultListener;
import ru.javabegin.training.goldman.utils.MessageManager;

public class FrameGame extends ConfirmCloseFrame implements ActionListener, MoveResultListener {

    private static final String MESSAGE_SAVE = "Сохранить игру перед выходом?";
    private static final String MESSAGE_SAVED_SUCCESS = "Игра сохранена!";
    private static final String MESSAGE_DIE = "Вы проиграли!";
    private static final String MESSAGE_WIN = "Вы выиграли! Количество очков:";
    private FrameStat frameStat;
    private GameFacade gameFacade;

    public FrameGame(GameFacade resultFacade) {
        this.gameFacade = resultFacade;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanelMap = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnLeft = new javax.swing.JButton();
        jbtnUp = new javax.swing.JButton();
        jbtnRight = new javax.swing.JButton();
        jbtnDown = new javax.swing.JButton();
        jlabelScoreText = new javax.swing.JLabel();
        jlabelTurnsLeftText = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();
        jlabelScore = new javax.swing.JLabel();
        jlabelTurnsLeft = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuFile = new javax.swing.JMenu();
        jmenuSave = new javax.swing.JMenuItem();
        jmenuExit = new javax.swing.JMenuItem();
        jmenuService = new javax.swing.JMenu();
        jmenuStat = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setName("FrameGame"); // NOI18N

        jPanelMap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelMap.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbtnLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/left.png"))); // NOI18N
        jbtnLeft.setName("jbtnLeft"); // NOI18N
        jbtnLeft.addActionListener(this);

        jbtnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/up.png"))); // NOI18N
        jbtnUp.setName("jbtnUp"); // NOI18N
        jbtnUp.addActionListener(this);

        jbtnRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/right.png"))); // NOI18N
        jbtnRight.setName("jbtnRight"); // NOI18N
        jbtnRight.addActionListener(this);

        jbtnDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/down.png"))); // NOI18N
        jbtnDown.setName("jbtnDown"); // NOI18N
        jbtnDown.addActionListener(this);

        jlabelScoreText.setText("Количество очков:");
        jlabelScoreText.setName("jlabelScoreText"); // NOI18N

        jlabelTurnsLeftText.setText("Осталось ходов:");
        jlabelTurnsLeftText.setToolTipText("");
        jlabelTurnsLeftText.setName("jlabelTurnsLeftText"); // NOI18N

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/save.png"))); // NOI18N
        jbtnSave.setText("Сохранить");
        jbtnSave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnSave.setName("jbtnUp"); // NOI18N
        jbtnSave.addActionListener(this);

        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/exit.png"))); // NOI18N
        jbtnExit.setText("Выйти из игры");
        jbtnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnExit.setName("jbtnUp"); // NOI18N
        jbtnExit.addActionListener(this);

        jlabelScore.setText("0");
        jlabelScore.setName("jlabelScore"); // NOI18N

        jlabelTurnsLeft.setText("0");
        jlabelTurnsLeft.setToolTipText("");
        jlabelTurnsLeft.setName("jlabelTurnsLeft"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelScoreText)
                    .addComponent(jlabelTurnsLeftText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelScore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTurnsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jbtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jbtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnRight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelScoreText)
                    .addComponent(jlabelScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabelTurnsLeftText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTurnsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMap, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelMap, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jmenuFile.setText("Файл");
        jmenuFile.setName("jmenuFile"); // NOI18N

        jmenuSave.setText("Сохранить игру");
        jmenuSave.addActionListener(this);
        jmenuFile.add(jmenuSave);

        jmenuExit.setText("Выйти из игры");
        jmenuExit.setActionCommand("Выйти");
        jmenuExit.addActionListener(this);
        jmenuFile.add(jmenuExit);

        jMenuBar1.add(jmenuFile);

        jmenuService.setText("Сервис");

        jmenuStat.setText("Статистика");
        jmenuStat.addActionListener(this);
        jmenuService.add(jmenuStat);

        jMenuBar1.add(jmenuService);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(534, 397));
        setLocationRelativeTo(null);
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == jbtnLeft) {
            FrameGame.this.jbtnLeftActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnUp) {
            FrameGame.this.jbtnUpActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnRight) {
            FrameGame.this.jbtnRightActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnDown) {
            FrameGame.this.jbtnDownActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnSave) {
            FrameGame.this.jbtnSaveActionPerformed(evt);
        }
        else if (evt.getSource() == jbtnExit) {
            FrameGame.this.jbtnExitActionPerformed(evt);
        }
        else if (evt.getSource() == jmenuExit) {
            FrameGame.this.jmenuExitActionPerformed(evt);
        }
        else if (evt.getSource() == jmenuStat) {
            FrameGame.this.jmenuStatActionPerformed(evt);
        }
        else if (evt.getSource() == jmenuSave) {
            FrameGame.this.jmenuSaveActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnUpActionPerformed(java.awt.event.ActionEvent evt) {
        gameFacade.moveObject(MovingDirection.UP, GameObjectType.GOLDMAN);
    }

    private void jbtnLeftActionPerformed(java.awt.event.ActionEvent evt) {
        gameFacade.moveObject(MovingDirection.LEFT, GameObjectType.GOLDMAN);
    }

    private void jbtnDownActionPerformed(java.awt.event.ActionEvent evt) {
        gameFacade.moveObject(MovingDirection.DOWN, GameObjectType.GOLDMAN);
    }

    private void jbtnRightActionPerformed(java.awt.event.ActionEvent evt) {
        gameFacade.moveObject(MovingDirection.RIGHT, GameObjectType.GOLDMAN);
    }

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        saveMap();
    }

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {
        if (allowExit()) {
            closeFrame();
        }
    }

    private void jmenuStatActionPerformed(java.awt.event.ActionEvent evt) {
        gameFacade.stopGame();
        if (frameStat == null) {
            frameStat = new FrameStat(new CloseFrameListener() {
                @Override
                public void onCloseAction() {
                    gameFacade.startGame();
                }
            });

        }

        frameStat.setList(gameFacade.getScoreSaver().getScoreList());
        frameStat.showFrame(this);

    }

    private void jmenuExitActionPerformed(java.awt.event.ActionEvent evt) {
        if (allowExit()) {
            closeFrame();
        }
    }

    private void jmenuSaveActionPerformed(java.awt.event.ActionEvent evt) {
        saveMap();
    }

    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelMap;
    private javax.swing.JButton jbtnDown;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLeft;
    private javax.swing.JButton jbtnRight;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnUp;
    private javax.swing.JLabel jlabelScore;
    private javax.swing.JLabel jlabelScoreText;
    private javax.swing.JLabel jlabelTurnsLeft;
    private javax.swing.JLabel jlabelTurnsLeftText;
    private javax.swing.JMenuItem jmenuExit;
    private javax.swing.JMenu jmenuFile;
    private javax.swing.JMenuItem jmenuSave;
    private javax.swing.JMenu jmenuService;
    private javax.swing.JMenuItem jmenuStat;


    @Override
    protected void showFrame(JFrame parent) {
        initMap();
        super.showFrame(parent);
    }

    private void initMap() {
        gameFacade.addMoveListener(this);

        jPanelMap.removeAll();
        jPanelMap.add(gameFacade.getMap());

        jlabelTurnsLeft.setText(String.valueOf(gameFacade.getTurnsLeftCount()));
        jlabelScore.setText(String.valueOf(gameFacade.getTotalScore()));

        gameFacade.startGame();
    }

    @Override
    public void notifyActionResult(ActionResult actionResult, AbstractGameObject movingObject, AbstractGameObject targetObject) {

        if (movingObject.getType().equals(GameObjectType.GOLDMAN)) {
            checkGoldManActions(actionResult);
        }

        checkCommonActions(actionResult);
        gameFacade.updateObjects(movingObject, targetObject);

    }

    private void checkGoldManActions(ActionResult actionResult) {
        switch (actionResult) {
            case MOVE: {

                jlabelTurnsLeft.setText(String.valueOf(gameFacade.getTurnsLeftCount()));

                if (gameFacade.getTurnsLeftCount() == 0) {
                    closeFrame(MESSAGE_DIE);
                }

                break;
            }

            case WIN: {
                closeFrame(MESSAGE_WIN + gameFacade.getTotalScore());
                gameFacade.saveScore();
            }


            case COLLECT_TREASURE: {
                jlabelScore.setText(String.valueOf(gameFacade.getTotalScore()));
                jlabelTurnsLeft.setText(String.valueOf(gameFacade.getTurnsLeftCount()));
                break;
            }
                
            case HIDE_IN_TREE:{
                jlabelTurnsLeft.setText(String.valueOf(gameFacade.getTurnsLeftCount()));
            }

        }

    }

    private void checkCommonActions(ActionResult actionResult) {
        switch (actionResult) {

            case DIE: {
                closeFrame(MESSAGE_DIE);
                break;
            }
        }

    }

    @Override
    protected boolean acceptCloseAction() {

        return allowExit();



    }

    @Override
    protected void closeFrame() {
        gameFacade.stopGame();
        super.closeFrame();
    }

    private void closeFrame(final String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MessageManager.showInformMessage(null, message);
            }
        });

        closeFrame();
    }

    private boolean allowExit() {
        gameFacade.stopGame();


        int result = MessageManager.showYesNoCancelMessage(this, MESSAGE_SAVE);
        switch (result) {
            case JOptionPane.YES_OPTION: {
                gameFacade.saveMap();
                MessageManager.showInformMessage(this, MESSAGE_SAVED_SUCCESS);
                break;
            }
            case JOptionPane.NO_OPTION: {
                closeFrame();
                break;
            }
            case JOptionPane.CANCEL_OPTION: {
                gameFacade.startGame();
                return false;
            }

        }

        return true;
    }

    private void saveMap() {
        gameFacade.saveMap();
        closeFrame(MESSAGE_SAVED_SUCCESS);
    }
}
