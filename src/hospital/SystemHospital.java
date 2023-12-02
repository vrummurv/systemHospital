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

        // Employee admin = new Admin("admin", "Administrativo", 1234, 1);
        // employees.add(admin);
    }



    public void addEmployee(Employee employee) {
        if (employee == null) {
            System.out.println("Funcionário não pode ser nulo!");
            return;
        }
        employees.add(employee);
    }

    public void addPatient(Patient patient) {
        if (patient == null) {
            System.out.println("Paciente não pode ser nulo!");
            return;
        }
        patients.add(patient);
    }

    public void addMedicalRecords(int id, MedicalRecords medicalRecords) {
        if (medicalRecords == null) {
            System.out.println("Prontuário não pode ser nulo!");
            return;
        }
        medicalRecordsMap.put(id, medicalRecords);
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