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
                String nachname = nachnameText.getText();
                String name = nameText.getText();
                if(nachname.matches("^[A-Za-z]+$") && name.matches("^[A-Za-z]+$")){
                    aufnehmen();
                    nachnameText.setText("");
                    nameText.setText("");
                }

                //nextPatientA.setText(nachnameText.getText()+", "+nameText.getText());

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
            blutCheckBox.setSelected(false);
        }
        if (arztCheckBox.isSelected()){
            aSchlange.enqueue(pPatient);
            nextPatientA.setText(aSchlange.front().getName()+", "+aSchlange.front().getVorname());
            arztCheckBox.setSelected(false);
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
        bSchlange.dequeue();
        if (!bSchlange.isEmpty()){
            nextPatientB.setText(bSchlange.front().getName()+", "+bSchlange.front().getVorname());
        }else nextPatientB.setText("");
        blutListeCheckBox.setSelected(false);
        }
        if(arztListeCheckBox.isSelected()){
            aSchlange.dequeue();
            if (!aSchlange.isEmpty()){
                nextPatientA.setText(aSchlange.front().getName()+", "+aSchlange.front().getVorname());
            }else nextPatientA.setText("");
            arztListeCheckBox.setSelected(false);
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
