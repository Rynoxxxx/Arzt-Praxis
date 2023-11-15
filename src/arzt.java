import javax.swing.*;

public class arzt {
    Praxis praxis;
    Patient patient;


    private JPanel arzt;
    private JTextField textField1;
    private JTextField textField2;
    private JButton aufnehmenButton;
    private JTextField textField3;
    private JButton aufrufenButton;
    private JLabel name;
    private JLabel nachname;
    private JLabel patient2;

    public arzt(){

    }

    public void Test() {
        praxis=new Praxis();
        patient=new Patient("Winkler","Rainer");
        praxis.aufnehmen(patient);
        praxis.aufrufen();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("arzt");
        frame.setContentPane(new arzt().arzt);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
