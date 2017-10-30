public class Polyclinic implements IPolyclinic {

    private Doctor[] doctors;
    private Patient[] patients;

    public Polyclinic() {
        Printer.printCreatingPolyclinic();
        doctors = new Doctor[1];
        patients = new Patient[1];
    }

    public void addDoctor(Doctor doctor) {
        Printer.printAddDoctor();
        if (!Checker.checkLength(doctors)) {
            this.doctors = Resizer.resize(this.doctors);
        }
        int position = Checker.getPosition(doctors);
        doctors[position] = doctor;
    }

    public void addPatient(Patient patient) {
        Printer.printAddPatient();
        if (!Checker.checkLength(patients)) {
            this.patients = Resizer.resize(this.patients);
        }
        int position = Checker.getPosition(patients);
        patients[position] = patient;
    }

    public void addToDoctor(Patient patient, Doctor doctor) {
        Printer.printAddToDoctor();
        Patient[] patients = doctor.getPatients();
        if (Checker.checkLength(patients)) {
            patients = Resizer.resize(patients);
        }
        int position = Checker.getPosition(patients);
        patients[position] = patient;
        doctor.setPatients(patients);
    }

    public void cancelAppointment(Patient patient, Doctor doctor) {
        Printer.printCancelAppointment();
        Patient[] patients = doctor.getPatients();
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == patient) {
                patients[i] = null;
                break;
            }
        }
        doctor.setPatients(patients);
    }

    public int getPatientsAtDoctor(Doctor doctor) {
        int count = 0;
        for (Patient patient : doctor.getPatients()) {
            if (patient != null) {
                count++;
            }
        }
        return count;
    }

    public int getNumberOfDoctors() {
        return doctors.length;
    }

    public int getNumberOfPatients() {
        return patients.length;
    }
}
