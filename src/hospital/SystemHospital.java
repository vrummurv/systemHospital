package hospital;

import java.net.PasswordAuthentication;
import java.util.*;

import hospital.papers.*;
import hospital.staff.*;

import hospital.staff.Specialty;

public class SystemHospital {
    private List<Employee> employees;
    private List<Patient> patients;
    private Map<Integer, MedicalRecords> medicalRecordsMap;
    private boolean isLogged = false;

    public SystemHospital() {
        this.employees = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.medicalRecordsMap = new HashMap<>();

        Employee admin = new Admin("admin", Specialty.ADMINISTRATIVO, "Administrativo", 1234);
        employees.add(admin);
        System.out.println(admin.toString());

        Employee doctor = new Doctor("doctor", Specialty.CIRURGIAO_GERAL, "Medico", 1234);
        employees.add(doctor);
        System.out.println(doctor.toString());

        Employee nurse = new Nurse("nurse", Specialty.DERMATOLOGISTA, "Enfermeiro", 1234);
        employees.add(nurse);
        System.out.println(nurse.toString());

        Patient patient = new Patient("patient", "18/11/1999");
        patients.add(patient);
        System.out.println(patient.toString());


    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public Map<Integer, MedicalRecords> getMedicalRecordsMap() {
        return medicalRecordsMap;
    }

    public boolean login(int id, int password) {
        if (isLogged) {
            System.out.println("Você já está logado como " + findEmployeeById(id).getName() + "!");
            return true;
        }

        for (Employee employee : employees) {
            if (employee.getId() == id && employee.getPassword() == password) {
                isLogged = true;
                return true;
            }
        }
        return false;
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        System.out.println("Funcionário não encontrado!");
        return null;
    }

    public Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        System.out.println("Paciente não encontrado!");
        return null;
    }

    public void logout() {
        if (isLogged) {
            isLogged = false;
            System.out.println("Logout realizado com sucesso!");
            return;
        } else {
            System.out.println("Você não está logado!");
            return;
        }
    }

    public void listDoctors() {
        for (Employee employee : employees) {
            if (employee instanceof Doctor) {
                System.out.println(employee.toString());
            }
        }
    }

    public void listNurses() {
        for (Employee employee : employees) {
            if (employee instanceof Nurse) {
                System.out.println(employee.toString());
            }
        }
    }

    public void listPatients() {
        for (Patient patient : patients) {
                System.out.println(patient.toString());
                for(MedicalRecords medicalRecords : medicalRecordsMap.values()) {
                    if(medicalRecords.getPatient().getId() == patient.getId()) {
                        System.out.println(medicalRecords.toString());
                    }
                }
        }

    }

    public void listMedicalRecords() {
        for (MedicalRecords medicalRecords : medicalRecordsMap.values()) {
            System.out.println(medicalRecords);
        }
    }
}