import javax.swing.*;

public class PfGui {

    public static void main(String[] args) {
        var gui = new PfGui();
        gui.go();
    }

    public void go() {
        var frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        var comboNumer = new JComboBox<Integer>();
        for(int i = 1; i <= 187; i++) comboNumer.addItem(i);
        comboNumer.addActionListener(event -> {/* TODO: comboNum listener */});

        var comboOption = new JComboBox<String>();
        comboOption.addItem("X");
        comboOption.addItem("A");
        comboOption.addItem("B");
        comboOption.addItem("C");
        comboOption.addActionListener(event -> {/* TODO: comboOption listener */});

        JButton buttonBack = new JButton("上一题");
        buttonBack.addActionListener(event -> {/* TODO: buttonBack listener */});
        
        JButton buttonNext = new JButton("下一题");
        buttonNext.addActionListener(event -> {/* TODO: buttonNext listener */});
        
        // TODO: bind panel->frame, omponent->panel
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}