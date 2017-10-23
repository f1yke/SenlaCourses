public class Runner {

    public static void main(String[] args) {

        Polyclinic polyclinic = new Polyclinic();

        Doctor doctor1 = new Doctor("doctor1");
        Doctor doctor2 = new Doctor("doctor2");
        Patient patient1 = new Patient("patient1");
        Patient patient2 = new Patient("patient2");

        polyclinic.addDoctor(doctor1);
        polyclinic.addDoctor(doctor2);
        Printer.printDoctors(polyclinic.getNumberOfDoctors());
        polyclinic.addPatient(patient1);
        polyclinic.addPatient(patient2);
        Printer.printPatients(polyclinic.getNumberOfPatients());

        polyclinic.addToDoctor(patient1, doctor1);
        polyclinic.addToDoctor(patient2, doctor1);
        Printer.printPatientsAtDoctor(doctor1, polyclinic.getPatientsAtDoctor(doctor1));
        polyclinic.cancelAppointment(patient1, doctor1);
        Printer.printPatientsAtDoctor(doctor1, polyclinic.getPatientsAtDoctor(doctor1));
    }
}
