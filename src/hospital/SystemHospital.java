package hospital;

import java.util.*;

import hospital.papers.*;
import hospital.staff.*;

public class SystemHospital {
    private List<Employee> employees;
    private List<Patient> patients;
    private Map<Integer, MedicalRecords> medicalRecordsMap;
    private boolean isLogged = false;

    public SystemHospital() {
        this.employees = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.medicalRecordsMap = new HashMap<>();

        // Admin admin = new Admin("admin", "Administrativo", 123, 1);
        // employees.add(admin);
    }



    public void addEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("Funcionário não pode ser nulo!");
        }
        employees.add(employee);
    }

    public void addPatient(Patient patient) throws Exception{
        if (patient == null) {
            throw new Exception("Paciente não pode ser nulo!");
        }
        patients.add(patient);
    }

    public void addMedicalRecords(int id, MedicalRecords medicalRecords) throws Exception{
        if (medicalRecords == null) {
            throw new Exception("Prontuário não pode ser nulo!");
        }
        medicalRecordsMap.put(id, medicalRecords);
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void setMedicalRecordsMap(Map<Integer, MedicalRecords> medicalRecordsMap) {
        this.medicalRecordsMap = medicalRecordsMap;
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

    public boolean getIsLogged() {
        return isLogged;
    }

    public Employee findEmployeeById(int id) throws Exception{
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new Exception("Funcionário não encontrado!");
    }

    public Patient findPatientById(int id) throws Exception{
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new Exception("Paciente não encontrado!");
    }

    public boolean login(int id, int password) {
        try {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }

    public void logout() throws Exception{
        if (isLogged) {
            isLogged = false;
            System.out.println("Logout realizado com sucesso!");
            return;
        } else {
            throw new Exception("Você não está logado!");
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

    public void listEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.getAll());
        }
    }

    public void listMedicalRecords() {
        for (MedicalRecords medicalRecords : medicalRecordsMap.values()) {
            System.out.println(medicalRecords);
        }
    }

    public void listMedicalRecordsByPatientId(int id) {
        for (MedicalRecords medicalRecords : medicalRecordsMap.values()) {
            if (medicalRecords.getPatient().getId() == id) {
                System.out.println(medicalRecords.toString());
            }
        }
    }

    public void listPatients(){
        for(Patient patient : patients){
            System.out.println(patient.toString());
            for(MedicalRecords medicalRecords : medicalRecordsMap.values()){
                if(medicalRecords.getPatient().getId() == patient.getId()){
                    System.out.println(medicalRecords.toString());
                }
            }
        }
    }
}