package hospital;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.Serializable;

import hospital.papers.MedicalRecords;
import hospital.papers.Patient;
import hospital.staff.Employee;

public class Data implements Serializable {
    public void saveEmployees(List<Employee> employees) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/hospital/employees.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(employees);
            out.close();
            fileOut.close();
            System.out.println("Funcionários salvos com sucesso!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void savePatients(List<Patient> patients) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/hospital/patients.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(patients);
            out.close();
            fileOut.close();
            System.out.println("Pacientes salvos com sucesso!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void saveMedicalRecordsMap(Map<Integer, MedicalRecords> medicalRecordsMap) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/hospital/medicalRecordsMap.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(medicalRecordsMap);
            out.close();
            fileOut.close();
            System.out.println("Prontuários salvos com sucesso!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            employees = (List<Employee>) new ObjectInputStream(new FileInputStream("src/hospital/employees.ser"))
                    .readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            patients = (List<Patient>) new ObjectInputStream(new FileInputStream("src/hospital/patients.ser"))
                    .readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public Map<Integer, MedicalRecords> loadMedicalRecordsMap() {
        Map<Integer, MedicalRecords> medicalRecordsMap = new HashMap<>();
        try {
            medicalRecordsMap = (Map<Integer, MedicalRecords>) new ObjectInputStream(
                    new FileInputStream("src/hospital/medicalRecordsMap.ser")).readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return medicalRecordsMap;
    }

}
