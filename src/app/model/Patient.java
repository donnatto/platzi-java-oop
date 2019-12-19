package app.model;

public class Patient extends User {

  // Atributos
  private String birthday;
  private double weigth;
  private double heigth;
  private String blood;

  public Patient(String name, String email) {
    super(name, email);
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getWeigth() {
    return weigth + " Kg.";
  }

  public void setWeigth(double weigth) {
    this.weigth = weigth;
  }

  public String getHeigth() {
    return heigth + " Mts.";
  }

  public void setHeigth(double heigth) {
    this.heigth = heigth;
  }

  public String getBlood() {
    return blood;
  }

  public void setBlood(String blood) {
    this.blood = blood;
  }

  @Override
  public String toString() {
    return super.toString() + "\nAge: " + birthday + "\nWeight: " + getWeigth() + "\nHeight: " + getHeigth() + "\nBlood: " + blood;
  }

  @Override
  public void showUserData() {
    System.out.println("Paciente");
    System.out.println("Historial completo desde nacimiento");

  }
}