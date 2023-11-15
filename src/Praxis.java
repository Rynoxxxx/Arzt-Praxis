public class Praxis {

    Patient erster;

    Praxis() {

    }

    public void aufnehmen(Patient pPatient) {
        if (erster == null) {
            erster = pPatient;
        }
        while (erster != null) {
            erster.getNachfolger().setNachfolger(pPatient);
        }
    }

    public Patient aufrufen() {
        if (erster != null) {

            return erster;
        }

        return null;
    }
}