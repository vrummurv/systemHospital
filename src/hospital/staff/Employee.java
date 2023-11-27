package hospital.staff;

import java.io.Serializable;

public class Employee implements Serializable {

  private String name;
  private Position position;
  private int id;
  private int password;
  private double salary = 1000;

  public Employee(String name, String position, int password, int id) {
    this.name = name;
    this.id = id;
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

  public double getSalary() {
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
