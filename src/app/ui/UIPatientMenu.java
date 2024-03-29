package app.ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import app.model.Doctor;

/**
 * UIPatientMenu
 */
public class UIPatientMenu {

  public static void showPatientMenu() {
    int response = 0;
    do {
      System.out.println("\n\n");
      System.out.println("Patient");
      System.out.println("Welcome: " + UIMenu.patientLogged.getName());
      System.out.println("1. Book an appointment");
      System.out.println("2. My Appointments");
      System.out.println("0. Logout");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());

      switch (response) {
      case 1:
        showBookAppointmentMenu();
        break;
      case 2:
        showPatientAppointments();
        break;
      case 0:
        UIMenu.showMenu();
        break;
      default:
        break;
      }
    } while (response != 0);
  }

  private static void showBookAppointmentMenu() {
    int response = 0;
    do {
      System.out.println("::Book an appointment");
      System.out.println("::Select date");
      // Numeracion de la lista de fechas
      // Indice de la fecha seleccionada
      // [doctors]
      // 1. doctor1
      // 1 fecha1
      // 2 fecha2
      Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
      int k = 0;
      for (int i = 0, n = UIDoctorMenu.doctorAvailableAppointments.size(); i < n; i++) {
        ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorAvailableAppointments.get(i)
            .getAvailableAppointments();

        Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

        for (int j = 0, size = availableAppointments.size(); j < size; j++) {
          k++;
          System.out.println(k + ". " + availableAppointments.get(j).getDate());
          doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorAvailableAppointments.get(i));
          doctors.put(Integer.valueOf(k), doctorAppointments);
        }
      }

      Scanner sc = new Scanner(System.in);
      int responseDateSelected = Integer.valueOf(sc.nextLine());
      Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
      Integer indexDate = 0;
      Doctor doctorSelected = new Doctor("", "");

      for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
        indexDate = doc.getKey();
        doctorSelected = doc.getValue();
      }

      System.out.println(
          doctorSelected.getName() + ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate()
              + ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
      System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
      response = Integer.valueOf(sc.nextLine());

      if (response == 1)
        UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
            doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
            doctorSelected.getAvailableAppointments().get(indexDate).getTime());
        showBookAppointmentMenu();
    } while (response != 0);
  }

  private static void showPatientAppointments() {
    int response = 0;
    do {
      System.out.println("::My Appointments");
      if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
        System.out.println("Don't have appointments");
        break;
      }

      for (int i = 0, n = UIMenu.patientLogged.getAppointmentDoctors().size(); i < n; i++) {
        int j = i + 1;
        System.out.println(j + ". Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() + " Time: "
            + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() + "\nDoctor: "
            + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor());
      }

      System.out.println("0. Return");
    } while (response != 0);
  }
}