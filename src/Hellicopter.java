import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hellicopter extends JFrame implements Component , ActionListener{
    private JLabel areaNotClearedLabel = new JLabel("Area -- ");
    private JButton shootButton = new JButton("Shoot");
    private JButton missileButton = new JButton("Missile Operation");
    private JButton Button = new JButton("Laser");
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

    Hellicopter() {

        System.out.println("Hellicopter Object is created");
        this.obsever = obsever;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hellicopter");
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



        // Laser Operation button
        Button.setBounds(20, 90, 100, 25);
        Button.setEnabled(false);
        panel.add(Button);

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
        Button.setEnabled(false);
        missileButton.setEnabled(false);




    }

    public void areaInfo(String lblInfo){
        areaNotClearedLabel.setText(lblInfo);
        System.out.println("Set area lable [Hellicopter]");
    }

    public void buttonHideer(int value) {
        if  (value > 75 & positionCheckbox.isSelected()){
            shootButton.setEnabled(true);
            Button.setEnabled(true);
            missileButton.setEnabled(true);

            System.out.println(" Strenth in maxmum range ...");
        }
        else if (value > 60 & positionCheckbox.isSelected()){
            shootButton.setEnabled(true);
            Button.setEnabled(true);
            missileButton.setEnabled(false);

            System.out.println(" Strenth set under 60 ...");
        }
        else if (value > 55 & positionCheckbox.isSelected())  {
            shootButton.setEnabled(true);
            Button.setEnabled(false);
            missileButton.setEnabled(false);

            System.out.println(" Strenth set under 50 ...");
        }
        else if (value > 35 & positionCheckbox.isSelected()) {
            shootButton.setEnabled(false);
            Button.setEnabled(false);
            missileButton.setEnabled(false);

            System.out.println(" Strenth set under 20 ...");
        }
    }

    // Add ActionListener to the Position checkbox

    public void brodcast(String bmsg){

        if(bmsg!= " "){
            massage += bmsg + "\n";
            textArea.setText(massage);
            System.out.println("Display massage [Hellicopter] ...");
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
            mainControllerob.rsvmsg("Hellicopter : - "+smsg);
            textField.setText("");
            System.out.println("sendButton Clicked ...");
        }

        // Check Box Actoon hear
        System.out.println("Hellicopter checkbox is running ...");

    }
}
