package hospital.staff;

public class Employee {

  private String name;
  private Specialty specialty;
  private Position position;
  private int id;
  private static int nextId = 1;
  private int password;

  public Employee(String name, Specialty specialty, String position, int password) {
    this.name = name;
    this.specialty = specialty;
    this.id = nextId;
    nextId++;
    this.password = password;

    switch (position) {
      case "Medico":
        this.position = Position.MEDICO;
        break;
      case "Enfermeiro":
        this.position = Position.ENFERMEIRO;
        break;
      case "Administrativo":
        this.position = Position.ADMINISTRATIVO;
        break;
      default:
        System.out.println("Cargo inválido");
        break;
    }

  }

  public String toString() {
    return ("Nome: " +
        name +
        "\n" +
        "Especialidade: " +
        specialty +
        "\n" +
        "Cargo: " +
        position +
        "\n" +
        "ID: " +
        id);
  }

  public String getName() {
    return name;
  }

  public Specialty getSpecialty() {
    return specialty;
  }

  public Position getPosition() {
    return position;
  }

  public int getId() {
    return id;
  }

  public int getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSpecialty(Specialty specialty) {
    this.specialty = specialty;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setPassword(int password) {
    this.password = password;
  }
}
