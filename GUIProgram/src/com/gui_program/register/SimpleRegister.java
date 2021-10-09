package com.gui_program.简易注册信息对话框;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleRegister extends WindowAdapter implements ActionListener {
    private JFrame frame;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JLabel nameLabel;
    private JLabel passLabel;
    private JPanel textPanel;
    private JPanel labelPanel;
    private JTextArea textArea;
    private JButton button;

    private void ininGUI() {
        frame = new JFrame("注册信息");
        frame.addWindowListener(this);

        button = new JButton("注册");
        button.addActionListener(this);

        textArea = new JTextArea("", 3, 10);

        Container container = frame.getContentPane();
        container.add(textArea, BorderLayout.CENTER);
        container.add(button, BorderLayout.NORTH);

        frame.setBounds(600, 400, 400, 300);
        frame.setVisible(true);
    }


    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        frame.setVisible(false);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final JDialog dialog = new JDialog(frame, "请填写注册信息");
        JButton confirmInfo = new JButton("确定");
        confirmInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                textArea.append("用户名:" + nameField.getText() + "\r\n");
                textArea.append("密码:" + new String(passwordField.getPassword()) + "\r\n");
                dialog.setVisible(true);
            }
        });

        nameField = new JTextField("", 10);
        passwordField = new JPasswordField("", 10);
        passwordField.setEchoChar('*');
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1, 10, 10));
        textPanel.add(nameField);
        textPanel.add(passwordField);

        nameLabel = new JLabel("用户名");
        passLabel = new JLabel("密码");
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1, 20, 20));
        labelPanel.add(nameLabel);
        labelPanel.add(passLabel);

        Container container = dialog.getContentPane();
        container.add(labelPanel, BorderLayout.WEST);
        container.add(textPanel, BorderLayout.CENTER);
        container.add(confirmInfo, BorderLayout.SOUTH);
        dialog.setSize(300, 180);
        dialog.setLocation(1000, 400);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleRegister register = new SimpleRegister();
        register.ininGUI();
    }
}