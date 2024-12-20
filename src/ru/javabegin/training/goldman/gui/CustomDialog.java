package ru.javabegin.training.goldman.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ru.javabegin.training.goldman.validators.NameValidator;
import ru.javabegin.training.goldman.validators.StringValidator;

public class CustomDialog extends javax.swing.JDialog implements ActionListener, PropertyChangeListener {

    private StringValidator nameValidator = new NameValidator();
    private String typedText = null;
    private JTextField textField;
    private JOptionPane optionPane;
    private static final String OK_BUTTON = "ОК";
    private static final String CANCEL_BUTTON = "Отмена";

    public String getValidatedText() {
        return typedText;
    }

    public void setUsername(String username) {
        textField.setText(username);
        textField.selectAll();
        textField.requestFocus();
    }

    public CustomDialog(java.awt.Frame parent, String title, String message, boolean modal) {
        super(parent, modal);
        initComponents();


        textField = new JTextField(10);
        setTitle(title);

        Object[] array = {message, textField};


        Object[] options = {OK_BUTTON, CANCEL_BUTTON};


        optionPane = new JOptionPane(array,
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION,
                null,
                options,
                options[0]);


        setContentPane(optionPane);


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                optionPane.setValue(new Integer(
                        JOptionPane.CLOSED_OPTION));
            }
        });


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });


        textField.addActionListener(this);
        optionPane.addPropertyChangeListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(OK_BUTTON);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (isVisible()
                && (e.getSource() == optionPane)
                && (JOptionPane.VALUE_PROPERTY.equals(prop)
                || JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }

            optionPane.setValue(JOptionPane.UNINITIALIZED_VALUE);

            if (OK_BUTTON.equals(value)) {
                typedText = textField.getText();
                if (nameValidator.isValid(typedText.toUpperCase())) {

                    clearAndHide();
                } else {

                    textField.selectAll();
                    JOptionPane.showMessageDialog(
                            CustomDialog.this,
                            "Имя \"" + typedText + "\" использовать нельзя. Пожалуйста введите другое имя.",
                            "Ошибка",
                            JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else {
                typedText = null;
                clearAndHide();
            }
        }
    }

    public void clearAndHide() {
        textField.setText(null);
        setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-375)/2, (screenSize.height-176)/2, 375, 176);
    }// </editor-fold>//GEN-END:initComponents
}
