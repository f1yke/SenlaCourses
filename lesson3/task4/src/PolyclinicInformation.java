public class PolyclinicInformation implements IPolyclinicInformation {

    private Polyclinic polyclinic;

    public PolyclinicInformation(Polyclinic polyclinic) {
        this.polyclinic = polyclinic;
    }

    public int patientsAtDoctor(Doctor doctor) {
        int count = 0;
        for (Patient patient : doctor.getPatients()) {
            if (patient != null) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfDoctors() {
        return polyclinic.getDoctors().length;
    }

    public int getNumberOfPatients() {
        return polyclinic.getPatients().length;
    }
}
