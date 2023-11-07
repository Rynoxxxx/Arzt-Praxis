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

}
