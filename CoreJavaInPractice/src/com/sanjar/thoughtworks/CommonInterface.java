package com.sanjar.thoughtworks;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public abstract class CommonInterface {
    protected CommonInterface(final String title) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                makeGUI(title);
                showGUI();
            }
        });
    }

    protected JFrame frame;
    protected JTextArea textArea;
    protected JButton button;
    protected JLabel label;

    protected String originalInputText, inputText, outputText = "";

    protected void makeGUI(final String title) {
        frame = new JFrame(title + " : By Aman Agnihotri");
        textArea = new JTextArea(30, 40);
        button = new JButton("Compute");
        label = new JLabel("Test Input:");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(5, 5, 2, 5));
        panel.add(label, BorderLayout.WEST);
        panel.add(button, BorderLayout.EAST);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(new EmptyBorder(2, 5, 5, 5));

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Compute")) {
                    refresh();
                    computeOutput();
                    button.setText("Back");
                    label.setText("Test Output:");
                    textArea.setText(outputText);
                } else {
                    button.setText("Compute");
                    label.setText("Test Input:");
                    textArea.setText(originalInputText);
                }
            }
        });
    }

    protected abstract void refresh();

    protected abstract void computeOutput();

    protected void showGUI() {
        frame.setVisible(true);
    }
}