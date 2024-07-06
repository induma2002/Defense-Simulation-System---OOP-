import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController extends JFrame implements ChangeListener, ActionListener {
    private JComboBox<String> defenseComboBox = new JComboBox<>(new String[]{"Select Defence"});
    private JButton collectInfoButton = new JButton("Collect Informations");
    private JCheckBox areaClearCheckbox = new JCheckBox("Area Clear");
    private JTextArea infoTextArea = new JTextArea();
    private JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
    private JLabel soldierCountLabel = new JLabel("Soldier Count");
    private JLabel fuelAmountLabel = new JLabel("Fuel Amount");
    private JLabel ammoAmountLabel = new JLabel("Ammo Amount");
    private JSlider positionSlider = new JSlider(0, 100, 0);
    private JLabel positionLabel = new JLabel("Position");
    private JCheckBox sendPrivateCheckbox = new JCheckBox("Send Private");
    private JButton sendButton = new JButton("Send");
    private JTextArea messageTextArea = new JTextArea();
    private JScrollPane messageScrollPane = new JScrollPane(messageTextArea);
    private JTextArea privateMessageTextArea = new JTextArea();
    private JScrollPane privateMessageScrollPane = new JScrollPane(privateMessageTextArea);
    private ObseverInterface obsever;

    public MainController(ObseverInterface obsever) {
        System.out.println("MainController Object is created");
        this.obsever = obsever;
        setTitle("MainController");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);

        // Adding components
        defenseComboBox.setBounds(20, 20, 150, 25);
        add(defenseComboBox);

        collectInfoButton.setBounds(180, 20, 150, 25);
        add(collectInfoButton);

        areaClearCheckbox.setBounds(350, 20, 100, 25);
        areaClearCheckbox.addActionListener(this);
        add(areaClearCheckbox);

        soldierCountLabel.setBounds(20, 60, 100, 25);
        add(soldierCountLabel);

        fuelAmountLabel.setBounds(20, 90, 100, 25);
        add(fuelAmountLabel);

        ammoAmountLabel.setBounds(20, 120, 100, 25);
        add(ammoAmountLabel);

        positionLabel.setBounds(20, 150, 100, 25);
        add(positionLabel);

        positionSlider.setBounds(20, 180, 200, 25);
        positionSlider.addChangeListener(this);
        add(positionSlider);

        sendPrivateCheckbox.setBounds(350, 180, 150, 25);
        add(sendPrivateCheckbox);

        sendButton.setBounds(450, 210, 100, 25);
        sendButton.addActionListener(this);
        add(sendButton);

        infoScrollPane.setBounds(350, 60, 200, 100);//1
        add(infoScrollPane);

        privateMessageScrollPane.setBounds(350, 240, 200, 100);//2
        add(privateMessageScrollPane);

        messageScrollPane.setBounds(20, 240, 300, 100);//3
        add(messageScrollPane);

        obsever.setMainControllerob(this);///////////////////tempory///////////////
        // Set frame visibility
        setVisible(true);
    }

//    positionSlider.addChangeListener(new ChangeListener() {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//            int value = positionSlider.getValue();
//            System.out.println("Slider Value: " + value);
//            // Additional actions based on the slider value can be added here
//        }
//    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int value = positionSlider.getValue();
        obsever.setStrenth(value);


    }
    private String massage = "";
    public void rsvmsg(String msg){

        massage+=msg+"\n";
        messageTextArea.setText(massage);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==areaClearCheckbox){
            if (areaClearCheckbox.isSelected()) {
                obsever.setarea("Area clear");
                System.out.println("Area CheckBox is Working [select]");
            } else {
                obsever.setarea("Area not clear");
                System.out.println("Area CheckBox is Working [not select]");

            }
        }

        if(e.getSource()==sendButton){

            String msg = infoTextArea.getText();
            obsever.setbmsg(msg);
            infoTextArea.setText("");
            System.out.println("Massage broadcast successful [ "+msg+" ]");
        }
    }
}
