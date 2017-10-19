public class Runner {

    public static void main(String[] args) {

        Polyclinic polyclinic = new Polyclinic();
        PolyclinicInformation information = new PolyclinicInformation(polyclinic);

        Doctor doctor1 = new Doctor("doctor1");
        Doctor doctor2 = new Doctor("doctor2");
        Patient patient1 = new Patient("patient1");
        Patient patient2 = new Patient("patient2");

        polyclinic.addDoctor(doctor1);
        polyclinic.addDoctor(doctor2);
        Printer.printDoctors(information.getNumberOfDoctors());
        polyclinic.addPatient(patient1);
        polyclinic.addPatient(patient2);
        Printer.printPatients(information.getNumberOfPatients());

        polyclinic.addToDoctor(patient1, doctor1);
        polyclinic.addToDoctor(patient2, doctor1);
        Printer.printPatientsAtDoctor(doctor1, information.patientsAtDoctor(doctor1));
        polyclinic.cancelAppointment(patient1, doctor1);
        Printer.printPatientsAtDoctor(doctor1, information.patientsAtDoctor(doctor1));

    }
}
