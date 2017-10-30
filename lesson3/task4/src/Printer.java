public class Printer {

    public static void printDoctors(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("Doctors: ");
        sb.append(count);
        System.out.println(sb.toString());
    }

    public static void printPatients(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("Patients: ");
        sb.append(count);
        System.out.println(sb.toString());
    }

    public static void printPatientsAtDoctor(Doctor doctor, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of patient at doctor [");
        sb.append(doctor.getName());
        sb.append("] : ");
        sb.append(count);
        System.out.println(sb.toString());
    }

    public static void printAddToDoctor() {
        System.out.println("Add to doctor ..");
    }

    public static void printCancelAppointment() {
        System.out.println("Cancel appointment ..");
    }

    public static void printAddPatient() {
        System.out.println("Add patient ..");
    }

    public static void printAddDoctor() {
        System.out.println("Add doctor ..");
    }

    public static void printCreatingPolyclinic() {
        System.out.println("Creating polyclinic ..");
    }
}
