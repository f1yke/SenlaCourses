public interface IPolyclinic {

    public void addDoctor(Doctor doctor);

    public void addPatient(Patient patient);

    public void addToDoctor(Patient patient, Doctor doctor);

    public void cancelAppointment(Patient patient, Doctor doctor);

    public int getPatientsAtDoctor(Doctor doctor);

    public int getNumberOfDoctors();

    public int getNumberOfPatients();
}
