import java.awt.BorderLayout;
import java.util.Map;

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
        var text = new JTextArea();
        var comboNumber = new JComboBox<Integer>();
        for(int i = 1; i <= 187; i++) comboNumber.addItem(i);
        var comboOption = new JComboBox<String>();
        comboOption.addItem("X");
        comboOption.addItem("A");
        comboOption.addItem("B");
        comboOption.addItem("C");
        var buttonBack = new JButton("上一题");
        var buttonNext = new JButton("下一题");
        var buttonFin = new JButton("完成");
        var optionPane = new JOptionPane();

        comboNumber.addActionListener(event -> {
            int num = (int) comboNumber.getSelectedItem();
            PfQuestion q = pf.get(num);
            text.setText(q.question);
            switch(q.userAnswer) {
                case "A" : comboOption.setSelectedIndex(1); break;
                case "B" : comboOption.setSelectedIndex(2); break;
                case "C" : comboOption.setSelectedIndex(3); break;
                default :  comboOption.setSelectedIndex(0);
            }
        });
        buttonBack.addActionListener(event -> {
            int num = ((int) comboNumber.getSelectedItem()) - 1;
            if(num > 0) {
                PfQuestion q = pf.get(num);
                text.setText(q.question);
                comboNumber.setSelectedIndex(num - 1);
                switch(q.userAnswer) {
                    case "A" : comboOption.setSelectedIndex(1); break;
                    case "B" : comboOption.setSelectedIndex(2); break;
                    case "C" : comboOption.setSelectedIndex(3); break;
                    default :  comboOption.setSelectedIndex(0);
                }
            } else {
                optionPane.showMessageDialog(null, "已经是第一题", "注意", JOptionPane.WARNING_MESSAGE);
            }
        });
        buttonNext.addActionListener(event -> {
            int num = ((int) comboNumber.getSelectedItem()) + 1;
            if(num < 188) {
                PfQuestion q = pf.get(num);
                text.setText(q.question);
                comboNumber.setSelectedIndex(num - 1);
                switch(q.userAnswer) {
                    case "A" : comboOption.setSelectedIndex(1); break;
                    case "B" : comboOption.setSelectedIndex(2); break;
                    case "C" : comboOption.setSelectedIndex(3); break;
                    default :  comboOption.setSelectedIndex(0);
                }
            } else {
                optionPane.showMessageDialog(null, "已经是最后一题", "注意", JOptionPane.WARNING_MESSAGE);
            }
        });
        comboOption.addActionListener(event -> {
            int num = (int) comboNumber.getSelectedItem();
            String op = (String) comboOption.getSelectedItem();
            pf.record(num, op);
        });
        buttonFin.addActionListener(event -> {
            int ret = pf.check();
            if(ret != 0) {
                String message = "第" + Integer.toString(ret) + "题未完成";
                optionPane.showMessageDialog(null, message, "注意", JOptionPane.WARNING_MESSAGE);
            } else {
                String message = "";
                Map<String,Integer> result = pf.finish();
                message += ("A乐群性：" + Integer.toString(result.get("A")) + "\n");
                message += ("B聪慧性：" + Integer.toString(result.get("B")) + "\n");
                message += ("C稳定性：" + Integer.toString(result.get("C")) + "\n");
                message += ("E恃强性：" + Integer.toString(result.get("E")) + "\n");
                message += ("F兴奋性：" + Integer.toString(result.get("F")) + "\n");
                message += ("G有恒性：" + Integer.toString(result.get("G")) + "\n");
                message += ("H敢为性：" + Integer.toString(result.get("H")) + "\n");
                message += ("I敏感性：" + Integer.toString(result.get("I")) + "\n");
                message += ("L怀疑性：" + Integer.toString(result.get("L")) + "\n");
                message += ("M幻想性：" + Integer.toString(result.get("M")) + "\n");
                message += ("N世故性：" + Integer.toString(result.get("N")) + "\n");
                message += ("O忧虑性：" + Integer.toString(result.get("O")) + "\n");
                message += ("Q1革新性：" + Integer.toString(result.get("Q1")) + "\n");
                message += ("Q2独立性：" + Integer.toString(result.get("Q2")) + "\n");
                message += ("Q1自律性：" + Integer.toString(result.get("Q3")) + "\n");
                message += ("Q1紧张性：" + Integer.toString(result.get("Q4")) + "\n");
                optionPane.showMessageDialog(null, message, "结果", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        panel.add(buttonBack);
        panel.add(comboNumber);
        panel.add(comboOption);
        panel.add(buttonNext);
        panel.add(buttonFin);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, text);

        PfQuestion q = pf.get(1);
        text.setText(q.question);
        frame.setSize(600, 200);
        frame.setVisible(true);
    }
}