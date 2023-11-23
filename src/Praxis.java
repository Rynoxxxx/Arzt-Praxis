import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Praxis {

    Patient erster;

    Queue <Patient>bSchlange;
    Queue <Patient>aSchlange;
    private JPanel arzt;
    private JTextField nameText;
    private JTextField nachnameText;
    private JButton aufnehmenButton;
    private JTextField nextPatientA;
    private JButton aufrufenButton;
    private JLabel name;
    private JLabel nachname;
    private JLabel patient2;
    private JCheckBox arztCheckBox;
    private JCheckBox blutCheckBox;
    private JTextField nextPatientB;
    private JCheckBox blutListeCheckBox;
    private JCheckBox arztListeCheckBox;

    public Praxis(){

        aSchlange= new Queue<Patient>();
        bSchlange= new Queue<Patient>();

        aufnehmenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aufnehmen();

                nextPatientA.setText(nachnameText.getText()+", "+nameText.getText());
                nachnameText.setText("");
                nameText.setText("");
            }
        });
        aufrufenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            aufrufen();
            nachnameText.setText("");
            nameText.setText("");
            /*if(erster!=null) {


                nextPatientA.setText(erster.getName()+", "+erster.getVorname());
            }
            else{
                nextPatientA.setText("");
            }*/
            }

        });

    }
    public void aufnehmen() {
        Patient pPatient=new Patient(nachnameText.getText(),nameText.getText());
        if (blutCheckBox.isSelected()){
            bSchlange.enqueue(pPatient);
            nextPatientB.setText(bSchlange.front().getName()+", "+bSchlange.front().getVorname());

        }
        if (arztCheckBox.isSelected()){
            aSchlange.enqueue(pPatient);
            nextPatientA.setText(aSchlange.front().getName()+", "+aSchlange.front().getVorname());
        }

        /*if (erster == null) {
            erster = pPatient;
        }else{
            erster.setNachfolger(pPatient);
        }
        if (erster != null) {
            nextPatientA.setText(erster.getName()+","+" "+erster.getVorname());
        }else {
            nextPatientA.setText("");
        }*/
    }

    public Patient aufrufen() {
        if(blutListeCheckBox.isSelected()){

        }
        /*if (erster != null) {
            Patient temp=erster;
            erster=erster.getNachfolger();
            return temp;
        }

        return null;*/
        return null;
    }




    public static void main(String[] args) {
        JFrame frame = new JFrame("arzt");
        frame.setContentPane(new Praxis().arzt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }



}
