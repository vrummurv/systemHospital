package hospital.papers;

import java.util.*;

import hospital.staff.Employee;
import hospital.staff.Specialty;

public class Admin extends Employee {

  public Admin(String name, String position, int password) {
    super(name, position, password);
  }

  public void addEmployee(List employees, Employee employee) {
    employees.add(employee);
  }

  public void removeEmployee(List employees, Employee employee) {
    employees.remove(employee);
  }

  /* CRUD DE MEDICO */

  public void createDoctor(List employees, String name, Specialty specialty, String position, int password) {
    Employee doctor = new Doctor(name, specialty, position, password);
    addEmployee(employees, doctor);
    System.out.println("====== Médico cadastrado com sucesso! ======");
  }

  public void removeDoctor(List employees, Employee doctor) {
    removeEmployee(employees, doctor);
    System.out.println("====== Médico removido com sucesso! ======");
  }

  public void updateDoctor(List employees, Doctor doctor, String name, int password) {
    Scanner scanner = new Scanner(System.in);

    if (employees.contains(doctor)) {
      int aux = employees.indexOf(doctor);

      doctor.setName(name);

      for (Specialty specialty : Specialty.values()) {
        System.out.println(specialty.getId() + " : " + specialty.name());
      }
      System.out.println("Selcione o número de umas dessas especialidades: ");
      int idSpecialty = scanner.nextInt();

      while (idSpecialty < 1 || idSpecialty > 13) {
        System.out.println("Opção inválida. Tente novamente.");
        for (Specialty spe : Specialty.values()) {
          System.out.println(spe.getId() + " : " + spe.name());
        }
        System.out.println("Selcione o número de umas dessas especialidades: ");
        idSpecialty = scanner.nextInt();
      }

      Specialty specialty = Specialty.valueOf(idSpecialty);
      doctor.setSpecialty(specialty);

      doctor.setPassword(password);
      employees.set(aux, doctor);
      System.out.println("====== Médico atualizado com sucesso! ======");
      return;
    }
  }

  /* CRUD DE ENFERMEIRO */

  public void createNurse(List employees, String name, Specialty specialty, String position, int password) {
    Employee nurse = new Nurse(name, specialty, position, password);
    addEmployee(employees, nurse);
    System.out.println("====== Enfermeiro cadastrado com sucesso! ======");
  }

  public void removeNurse(List employees, Employee nurse) {
    removeEmployee(employees, nurse);
    System.out.println("====== Enfermeiro removido com sucesso! ======");
  }

  public void updateNurse(List employees, Nurse nurse, String name, int password) {
    Scanner scanner = new Scanner(System.in);

    if (employees.contains(nurse)) {
      int aux = employees.indexOf(nurse);

      nurse.setName(name);

      for (Specialty specialty : Specialty.values()) {
        System.out.println(specialty.getId() + " : " + specialty.name());
      }
      System.out.println("Selcione o número de umas dessas especialidades: ");
      int idSpecialty = scanner.nextInt();

      while (idSpecialty < 1 || idSpecialty > 13) {
        System.out.println("Opção inválida. Tente novamente.");
        for (Specialty spe : Specialty.values()) {
          System.out.println(spe.getId() + " : " + spe.name());
        }
        System.out.println("Selcione o número de umas dessas especialidades: ");
        idSpecialty = scanner.nextInt();
      }

      Specialty specialty = Specialty.valueOf(idSpecialty);
      nurse.setSpecialty(specialty);

      nurse.setPassword(password);
      employees.set(aux, nurse);
      System.out.println("====== Enfermeiro atualizado com sucesso! ======");
      return;
    }
  }

  /* CRUD DE PACIENTE */

  // Dentro do método createPatient em Admin.java
  public void createPatient(Map<Integer, MedicalRecords> medicalRecordsMap, List<Patient> patients, String patientName,
      String birthDate) {

    Patient newPatient = new Patient(patientName, birthDate); // Crie um novo paciente
    MedicalRecords newMedicalRecords = new MedicalRecords(newPatient); // Associe um novo prontuário médico ao paciente
    medicalRecordsMap.put(newPatient.getId(), newMedicalRecords); // Armazene a associação no mapa medicalRecordsMap
    patients.add(newPatient); // Adicione o paciente à lista de pacientes
    System.out.println("====== Paciente cadastrado com sucesso! ======");
  }

  public void removePatient(List patients, Patient patient) {
    patients.remove(patient);
    System.out.println("====== Paciente removido com sucesso! ======");
  }

  public void updatePatient(List patients, Patient patient, String name, String birthDate) {
    Scanner scanner = new Scanner(System.in);

    if (patients.contains(patient)) {
      int aux = patients.indexOf(patient);

      patient.setName(name);
      patient.setBirthDate(birthDate);

      patients.set(aux, patient);
      System.out.println("====== Paciente atualizado com sucesso! ======");
      return;
    }

  }

}
