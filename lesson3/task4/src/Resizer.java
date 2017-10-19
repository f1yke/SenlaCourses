public class Resizer {

    public static Patient[] resize(Patient[] patients) {
        Patient[] newPatients = new Patient[patients.length + 1];
        System.arraycopy(patients, 0, newPatients, 0, patients.length);
        return newPatients;
    }

    public static Doctor[] resize(Doctor[] doctors) {
        Doctor[] newDoctors = new Doctor[doctors.length + 1];
        System.arraycopy(doctors, 0, newDoctors, 0, doctors.length);
        return newDoctors;
    }
}
