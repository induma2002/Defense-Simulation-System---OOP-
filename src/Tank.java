import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tank extends JFrame implements Component , ActionListener{
    private JLabel areaNotClearedLabel = new JLabel("Area -- ");
    private JButton shootButton = new JButton("Shoot");
    private JButton missileButton = new JButton("Missile Operation");
    private JButton rorateButton = new JButton("Rotate Shooting");
    private JButton rederButton = new JButton("Reder");
    private JSpinner soldierSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
    private JLabel soldierLabel = new JLabel("Soldier Count:");
    private JSpinner ammoSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
    private JCheckBox positionCheckbox = new JCheckBox("Position");
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    private JButton sendButton = new JButton("Send");
    private JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 0);
    private JLabel ammoLabel = new JLabel("Ammo Count:");
    private MainController mainControllerob;
    private String smsg;
    private Obsever obsever;
    private String massage = "";
    JPanel panel = new JPanel();

    Tank() {

        System.out.println("Tank Object is created");
        this.obsever = obsever;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tank");
        setSize(550, 300);
        panel.setLayout(null);

        // Area Not Cleared label
        areaNotClearedLabel.setBounds(20, 20, 150, 25);
        panel.add(areaNotClearedLabel);

        // Shoot button

        shootButton.setBounds(20, 50, 100, 25);
        panel.add(shootButton);

        // Missile Operation button
        missileButton.setBounds(140, 50, 150, 25);
        missileButton.setEnabled(false);
        panel.add(missileButton);

        rorateButton.setBounds(140, 90,150, 25);
        panel.add(rorateButton);

        // Laser Operation button
        rederButton.setBounds(20, 90, 100, 25);
        rederButton.setEnabled(false);
        panel.add(rederButton);

        // Soldier Count label and spinner
        soldierLabel.setBounds(320, 20, 100, 25);
        panel.add(soldierLabel);


        soldierSpinner.setBounds(420, 20, 50, 25);
        panel.add(soldierSpinner);

        // Ammo Count label and spinner

        ammoLabel.setBounds(320, 60, 100, 25);
        panel.add(ammoLabel);


        ammoSpinner.setBounds(420, 60, 50, 25);
        panel.add(ammoSpinner);

        // Position checkbox

        positionCheckbox.setBounds(320, 100, 100, 25);
        positionCheckbox.addActionListener(this);
        panel.add(positionCheckbox);

        // Text area

        textArea.setBounds(20, 130, 450, 100);
        panel.add(textArea);

        // Text field and Send button

        textField.setBounds(20, 240, 350, 25);
        panel.add(textField);

        // Create send Button
        sendButton.setBounds(380, 240, 90, 25);
        panel.add(sendButton);
        sendButton.addActionListener(this);

        // Slider
        slider.setBounds(480, 20, 50, 245);
        slider.setInverted(true); // To invert the slider
        panel.add(slider);

        // Add panel to frame
        add(panel);

        // Set frame visibility
        setVisible(true);

        // hide all button 1st time
        shootButton.setEnabled(false);
        rederButton.setEnabled(false);
        missileButton.setEnabled(false);
        rorateButton.setEnabled(false);



    }

    public void areaInfo(String lblInfo){
        areaNotClearedLabel.setText(lblInfo);
        System.out.println("Set area lable [Tank]");
    }

    public void buttonHideer(int value) {
        if  (value > 50 & positionCheckbox.isSelected()){
            shootButton.setEnabled(true);
            rederButton.setEnabled(true);
            missileButton.setEnabled(true);
            rorateButton.setEnabled(true);

        }
        else if (value > 40 & positionCheckbox.isSelected()){
            shootButton.setEnabled(true);
            rederButton.setEnabled(true);
            missileButton.setEnabled(false);
            rorateButton.setEnabled(false);

        }
        else if (value > 20 & positionCheckbox.isSelected())  {
            shootButton.setEnabled(true);
            rederButton.setEnabled(false);
            missileButton.setEnabled(false);
            rorateButton.setEnabled(true);

        }
        else if (value > 10 & positionCheckbox.isSelected()) {
            shootButton.setEnabled(false);
            rederButton.setEnabled(false);
            missileButton.setEnabled(false);
            rorateButton.setEnabled(false);

        }
    }

    // Add ActionListener to the Position checkbox

    public void brodcast(String bmsg){

        if(bmsg!= " "){
            massage += bmsg + "\n";
            textArea.setText(massage);
            System.out.println("Display massage [Tank] ...");
        }

    }

    public String sendmsg(){
        return smsg;
    }

    public void mainConConnecter(MainController mainControllerob){
        this.mainControllerob = mainControllerob;
        System.out.println("Main Controller connected Successful ...");
    }
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==sendButton){
            smsg = textField.getText();
            mainControllerob.rsvmsg("Tank : - "+smsg);
            textField.setText("");
            System.out.println("sendButton Clicked ...");
        }

        // Check Box Actoon hear
        System.out.println("Tank checkbox is running ...");

    }
}
