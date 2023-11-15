public class Patient {
    String name, vorname;

    Patient nachfolger;
    Patient(String pname, String pvorname) {
        name = pname;
        vorname = pvorname;

    }

    String getName() {
        return name;
    }

    String getVorname() {
        return vorname;
    }

    Patient getNachfolger(){
        return nachfolger;
    }

    public void setName(String pName){
        name=pName;
    }

    public void setVorname(String pVorname){
        vorname=pVorname;
    }

    public void setNachfolger(Patient pNachfolger) {
        nachfolger=pNachfolger;

        if(nachfolger == null){
            nachfolger=pNachfolger;
        }
        while (nachfolger!=null){
            nachfolger.setNachfolger(pNachfolger);
        }
    }
}
