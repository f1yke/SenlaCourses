public class Doctor extends Person {

    private Patient[] patients;

    public Doctor(String name) {
        super(name);
        patients = new Patient[1];
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatients(Patient[] patients) {
        this.patients = patients;
    }
}
