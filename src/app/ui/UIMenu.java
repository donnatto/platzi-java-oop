package app.ui;

import java.util.ArrayList;
import java.util.Scanner;

import app.model.Doctor;
import app.model.Patient;

/**
 * UIMenu
 */
public class UIMenu {

  public static String[] MONTHS = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
  public static Doctor doctorLogged;
  public static Patient patientLogged;

  public static void showMenu() {
    System.out.println("Welcome to My appointments");
    System.out.println("Selecciona la opcion deseada");

    int response = 0;
    do {
      System.out.println("1. Doctor");
      System.out.println("2. Patient");
      System.out.println("0. Salir");

      Scanner sc = new Scanner(System.in);
      response = Integer.valueOf(sc.nextLine());
      sc.close();

      switch (response) {
        case 1:
          System.out.println("Doctor");
          response = 0;
          authUser(1);
          break;
        case 2:
          response = 0;
          authUser(2);
          break;
        case 0:
          System.out.println("Thank you for your visit");
          break;
        default:
          System.out.println("Please select a correct answer");
          break;
      }
    } while (response != 0);
  }

  private static void authUser(int userType) {
    // userType == 1 Doctor
    // userType == 2 Patient

    ArrayList<Doctor> doctors = new ArrayList<>();
    doctors.add(new Doctor("Alejandro Martinez", "alejandro@gmail.com"));
    doctors.add(new Doctor("Karen Sosa", "karen@gmail.com"));
    doctors.add(new Doctor("Rocio Gomez", "rocio@gmail.com"));

    ArrayList<Patient> patients = new ArrayList<>();
    patients.add(new Patient("Anahi Salgado", "anahi@gmail.com"));
    patients.add(new Patient("Roberto Rodriguez", "roberto@gmail.com"));
    patients.add(new Patient("Carlos Sanchez", "carlos@gmail.com"));

    boolean emailCorrect = false;
    do {
      System.out.println("Insert your email: [a@a.com]");
      Scanner sc = new Scanner(System.in);
      String email = sc.nextLine();
      sc.close();

      if (userType == 1) {
        for (Doctor d: doctors) {
          if (d.getEmail().equals(email)) {
            emailCorrect = true;
            // Obtener datos de usuario logeado
            doctorLogged = d;
            // Show Doctor Menu
          }
        }
      }
      if (userType == 2) {
        for (Patient p : patients) {
          if (p.getEmail().equals(email)) {
            emailCorrect = true;
            patientLogged = p;
            // Show Patient Menu
          }
        }
      }

    } while (!emailCorrect);
  }

}