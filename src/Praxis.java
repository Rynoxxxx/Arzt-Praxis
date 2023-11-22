import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Praxis {

    Patient erster;

    private JPanel arzt;
    private JTextField nameText;
    private JTextField nachnameText;
    private JButton aufnehmenButton;
    private JTextField nextPatient;
    private JButton aufrufenButton;
    private JLabel name;
    private JLabel nachname;
    private JLabel patient2;

    public Praxis(){

        aufnehmenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aufnehmen();
                nachnameText.setText("");
                nameText.setText("");
                nextPatient.setText(erster.getName()+", "+erster.getVorname());

            }
        });
        aufrufenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            aufrufen();
            nachnameText.setText("");
            nameText.setText("");
            if(erster!=null) {


                nextPatient.setText(erster.getName()+", "+erster.getVorname());
            }
            else{
                nextPatient.setText("");
            }
            }

        });

    }
    public void aufnehmen() {
        Patient pPatient=new Patient(nachnameText.getText(),nameText.getText());
        if (erster == null) {
            erster = pPatient;
        }else{
            erster.setNachfolger(pPatient);
        }
        if (erster != null) {
            nextPatient.setText(erster.getName()+","+" "+erster.getVorname());
        }else {
            nextPatient.setText("");
        }
    }

    public Patient aufrufen() {
        if (erster != null) {
            Patient temp=erster;
            erster=erster.getNachfolger();
            return temp;
        }

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
