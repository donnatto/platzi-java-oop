package app.model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

  // Attributes
  private String speciality;

  public Doctor(String name, String email) {
    super(name, email);
    System.out.println("Nombre del doctor: " + name);
  }

  // Behavior
  public void showName() {
    System.out.println(this.getName());
  }

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

  public void addAvailableAppintment(Date date, String time) {
    availableAppointments.add(new Doctor.AvailableAppointment(date, time));
  }

  public ArrayList<AvailableAppointment> getAvailableAppointments() {
    return availableAppointments;
  }

  @Override
  public String toString() {
    return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
  }

  public static class AvailableAppointment {
    private int id;
    private Date date;
    private String time;

    public AvailableAppointment(Date date, String time) {
      this.date = date;
      this.time = time;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    @Override
    public String toString() {
      return "Available Appointments \nDate: " + date + "\nTime: " + time;
    }
  }

  @Override
  public void showUserData() {
    System.out.println("Hospital: Cruz Roja");
    System.out.println("Departamento: Oncologia");

  }

}