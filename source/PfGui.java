import java.awt.BorderLayout;

import javax.swing.*;

public class PfGui {

    public static void main(String[] args) {
        var gui = new PfGui();
        gui.go();
    }

    public void go() {
        var pf = new Pf();
        var frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        var label = new JLabel();
        var comboNumber = new JComboBox<Integer>();
        for(int i = 1; i <= 187; i++) comboNumber.addItem(i);
        var comboOption = new JComboBox<String>();
        comboOption.addItem("X");
        comboOption.addItem("A");
        comboOption.addItem("B");
        comboOption.addItem("C");
        JButton buttonBack = new JButton("上一题");
        JButton buttonNext = new JButton("下一题");
        JButton buttonFin = new JButton("完成");

        comboNumber.addActionListener(event -> {/* TODO: comboNum listener */
            label.setText(pf.questionnaire[/**/].question);
            comboOption.setSelectedIndex(/**/);
        });
        comboOption.addActionListener(event -> {/* TODO: comboOption listener */
            pf.record(/**/, /**/);
        });
        buttonBack.addActionListener(event -> {/* TODO: buttonBack listener */
            comboNumber/* */
            label.setText(pf.questionnaire[/**/].question);
            comboOption.setSelectedIndex(/**/);
        });
        buttonNext.addActionListener(event -> {/* TODO: buttonNext listener */
            comboNumber/* */
            label.setText(pf.questionnaire[/**/].question);
            comboOption.setSelectedIndex(/**/);
        });
        buttonFin.addActionListener(event -> {/* TODO: buttonFin listener */

        });
        
        panel.add(buttonBack);
        panel.add(comboNumber);
        panel.add(comboOption);
        panel.add(buttonNext);
        panel.add(buttonFin);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}