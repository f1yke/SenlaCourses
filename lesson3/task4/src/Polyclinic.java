public class Polyclinic implements IPolyclinic {

    private Doctor[] doctors;
    private Patient[] patients;

    public Polyclinic() {
        Printer.printCreatingPolyclinic();
        doctors = new Doctor[1];
        patients = new Patient[1];
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public Patient[] getPatients() {
        return patients;
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
        doctor.setPatient(patient);
    }

    public void cancelAppointment(Patient patient, Doctor doctor) {
        Printer.printCancelAppointment();
        doctor.cancelPatient(patient);
    }
}
