public interface IPolyclinic {

    public void addDoctor(Doctor doctor);

    public void addPatient(Patient patient);

    public void addToDoctor(Patient patient, Doctor doctor);

    public void cancelAppointment(Patient patient, Doctor doctor);
}
