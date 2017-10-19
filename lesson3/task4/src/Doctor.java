public class Doctor extends Person {

    private Patient[] patients;

    public Doctor(String name) {
        super(name);
        patients = new Patient[1];
    }

    public Patient[] getPatients() {
        return patients;
    }

    public void setPatient(Patient patient) {
        if (Checker.checkLength(patients)) {
            patients = Resizer.resize(patients);
        }
        int position = Checker.getPosition(patients);
        patients[position] = patient;
    }

    public void cancelPatient(Patient patient) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == patient) {
                patients[i] = null;
                break;
            }
        }
    }
}
