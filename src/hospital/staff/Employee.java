package hospital.staff;

public class Employee {

  private String name;
  private Position position;
  private int id;
  private static int nextId = 1;
  private int password;
  private int salary = 1000;

  public Employee(String name, String position, int password) {
    this.name = name;
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
        "Cargo: " +
        position +
        "\n" +
        "ID: " +
        id);
  }

  public String getAll() {
    return ("Nome: " +
        name +
        "\n" +
        "Cargo: " +
        position +
        "\n" +
        "ID: " +
        id +
        "\n" +
        "Salário: " +
        salary);
  }

  public String getName() {
    return name;
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

  public int getSalary() {
    return salary;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setPassword(int password) {
    this.password = password;
  }
}
