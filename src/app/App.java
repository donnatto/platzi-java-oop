package app;

import app.model.Doctor;
import app.model.Patient;
import app.model.User;

public class App {
    public static void main(String[] args) throws Exception {

        Doctor myDoctor = new Doctor("Edwin Dominguez", "edominguez@hotmail.com");

        System.out.println(myDoctor);

        User user = new Doctor("Anahi", "ana@ana.com");
        user.showUserData();

        User patient = new Patient("Edwin", "edwin@gmail.com");
        patient.showUserData();

        User user1 = new User("Edwin", "edwin@gmail.com"){

            @Override
            public void showUserData() {
                System.out.println("Doctor");
                System.out.println("Hospital: Cruz Verde");
                System.out.println("Departamento: Geriatria");
            }
        };

        user1.showUserData();

        /* for (Doctor.AvailableAppointment aa : myDoctor.getAvailableAppointments()) {
            System.out.println(aa.getDate() + " " + aa.getTime());
        } */

        /* Patient patient = new Patient("Alejandra", "alejandra@gmail.com");
        System.out.println(patient); */

    }

}