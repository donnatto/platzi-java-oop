package app.model;

/**
 * Nurse
 */
public class Nurse extends User {

  private String speciality;

	public Nurse(String name, String email) {
		super(name, email);
	}

  public String getSpeciality() {
    return speciality;
  }

  public void setSpeciality(String speciality) {
    this.speciality = speciality;
  }

  @Override
  public void showUserData() {
    System.out.println("Hospital: Cruz Verde");
    System.out.println("Departamento: Oncología, Nutrición.");

  }

}