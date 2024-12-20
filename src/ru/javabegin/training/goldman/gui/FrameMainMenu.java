package ru.javabegin.training.goldman.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import ru.javabegin.training.goldman.collections.impl.MapCollection;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.gamemap.adapters.HybridMapLoader;
import ru.javabegin.training.goldman.gamemap.facades.GameFacade;
import ru.javabegin.training.goldman.gamemap.impl.JTableGameMap;
import ru.javabegin.training.goldman.objects.MapInfo;
import ru.javabegin.training.goldman.objects.User;
import ru.javabegin.training.goldman.score.impl.DbScoreSaver;
import ru.javabegin.training.goldman.score.interfaces.ScoreSaver;
import ru.javabegin.training.goldman.sound.impl.WavPlayer;
import ru.javabegin.training.goldman.sound.interfaces.SoundPlayer;

public class FrameMainMenu extends javax.swing.JFrame {

    private JDialog splashDialog;
    private FrameGame frameGame;
    private FrameStat frameStat;
    private FrameSavedGames frameSavedGames;
    private ScoreSaver scoreSaver = new DbScoreSaver();
    private CustomDialog usernameDialog = new CustomDialog(this, "Имя пользователя", "Введите имя:", true);
    private JTableGameMap gameMap = new JTableGameMap(new MapCollection());
    private HybridMapLoader mapLoader = new HybridMapLoader(gameMap);
    private SoundPlayer soundPlayer = new WavPlayer();
    private static final int MAP_LEVEL_ONE = 1;
    private User user;
    private GameFacade gameFacade = new GameFacade(mapLoader, soundPlayer, scoreSaver);


    public FrameMainMenu() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlMainMenu = new javax.swing.JPanel();
        jbtnNewGame = new javax.swing.JButton();
        jbtnLoadGame = new javax.swing.JButton();
        jbtnStatistics = new javax.swing.JButton();
        jbtnExit = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Игра");
        setName("FrameMainMenu"); // NOI18N
        setResizable(false);

        jpnlMainMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbtnNewGame.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/new.png"))); // NOI18N
        jbtnNewGame.setText("Новая игра");
        jbtnNewGame.setToolTipText("Создать новую игру");
        jbtnNewGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnNewGame.setIconTextGap(10);
        jbtnNewGame.addActionListener(formListener);

        jbtnLoadGame.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnLoadGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/load.png"))); // NOI18N
        jbtnLoadGame.setText("Загрузить игру");
        jbtnLoadGame.setToolTipText("Загрузить сохраненную игру ");
        jbtnLoadGame.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnLoadGame.setIconTextGap(10);
        jbtnLoadGame.addActionListener(formListener);

        jbtnStatistics.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/stat.png"))); // NOI18N
        jbtnStatistics.setText("Статистика");
        jbtnStatistics.setToolTipText("Посмотреть статистику по игрокам");
        jbtnStatistics.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnStatistics.setIconTextGap(10);
        jbtnStatistics.addActionListener(formListener);

        jbtnExit.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jbtnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ru/javabegin/training/goldman/images/exit.png"))); // NOI18N
        jbtnExit.setText("Выход");
        jbtnExit.setToolTipText("Выйти из игры");
        jbtnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnExit.setIconTextGap(10);
        jbtnExit.addActionListener(formListener);

        javax.swing.GroupLayout jpnlMainMenuLayout = new javax.swing.GroupLayout(jpnlMainMenu);
        jpnlMainMenu.setLayout(jpnlMainMenuLayout);
        jpnlMainMenuLayout.setHorizontalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnLoadGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlMainMenuLayout.setVerticalGroup(
            jpnlMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMainMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnLoadGame, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-267)/2, (screenSize.height-310)/2, 267, 310);
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jbtnNewGame) {
                FrameMainMenu.this.jbtnNewGameActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnLoadGame) {
                FrameMainMenu.this.jbtnLoadGameActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnStatistics) {
                FrameMainMenu.this.jbtnStatisticsActionPerformed(evt);
            }
            else if (evt.getSource() == jbtnExit) {
                FrameMainMenu.this.jbtnExitActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewGameActionPerformed

        if (!saveUser()) {
            return;
        }


        showSplash();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {

                MapInfo mapInfo = new MapInfo();
                mapInfo.setLevelId(MAP_LEVEL_ONE);

                if (!mapLoader.loadMap(mapInfo, LocationType.FS)) {
                    throw new Exception("Error loading map!");
                }

                gameFacade.setMapLoader(mapLoader);

                createFrameGame();

                Thread.sleep(1000);
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {}

            @Override
            protected void done() {
                hideSplash();
                FrameMainMenu.this.frameGame.showFrame(FrameMainMenu.this);
            }
        };
        worker.execute();




    }

    private void createFrameGame() {
        if (frameGame == null) {
            frameGame = new FrameGame(gameFacade);
        }
    }

    private void jbtnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {
        if (frameStat == null) {
            frameStat = new FrameStat();
        }

        frameStat.setList(scoreSaver.getScoreList());
        frameStat.showFrame(this);
    }

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {
        quit();
    }

    private void jbtnLoadGameActionPerformed(java.awt.event.ActionEvent evt) {

        if (!saveUser()) {
            return;
        }

        createFrameGame();

        if (frameSavedGames == null) {
            frameSavedGames = new FrameSavedGames(mapLoader, frameGame);
        }

        frameSavedGames.showFrame(this);
    }
    private void quit() {
        System.exit(0);

    }


    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameMainMenu().setVisible(true);
            }
        });
    }

    javax.swing.JButton jbtnExit;
    javax.swing.JButton jbtnLoadGame;
    javax.swing.JButton jbtnNewGame;
    javax.swing.JButton jbtnStatistics;
    javax.swing.JPanel jpnlMainMenu;


    private String getUserNameDialog() {

        if (user != null && user.getUsername() != null) {
            usernameDialog.setUsername(user.getUsername());
        }

        usernameDialog.setVisible(true);

        return usernameDialog.getValidatedText();
    }

    private boolean saveUser() {

        String username = getUserNameDialog();

        if (username != null && !username.trim().equals("")) {

            if (user != null && user.getUsername().equals(username)) {
                return true;
            }

            user = new User();
            user.setUsername(username);
            user.setId(mapLoader.getPlayerId(username));

            gameMap.getMapInfo().setUser(user);

            return true;
        }

        return false;
    }

    private void hideSplash() {
        splashDialog.setVisible(false);
        splashDialog.getParent().setEnabled(true);
    }

    public void showSplash() {

        if (splashDialog == null) {
            splashDialog = new JDialog(FrameMainMenu.this);

            splashDialog.setSize(200, 100);
            splashDialog.setUndecorated(true);
            splashDialog.setModal(false);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));

            JLabel text = new JLabel("Загрузка...");
            text.setFont(new Font("Tahoma", Font.BOLD, 15));
           
            panel.setBackground(Color.LIGHT_GRAY);


            panel.add(text);
            splashDialog.add(panel);
            splashDialog.setLocationRelativeTo(FrameMainMenu.this);
        }

        splashDialog.getParent().setEnabled(false);
        splashDialog.setVisible(true);
    }
}
