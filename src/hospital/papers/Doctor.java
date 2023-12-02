package hospital.papers;

import java.util.Map;
import java.util.Scanner;

import hospital.SystemHospital;
import hospital.staff.*;

public class Doctor extends Employee {
    Specialty specialty;

    public Doctor(String name, Specialty specialty, String position, int password, int id) {
        super(name, position, password, id);
        this.specialty = specialty;
    }

    public String toString() {
        return ("Nome: " + getName() + "\n" + "Especialidade: " + getSpecialty() + "\n" + "Cargo: " + getPosition()
                + "\n" + "ID: " + getId());
    }

    @Override
    public String getAll() {
        return ("Nome: " + getName() + "\n" + "Especialidade: " + getSpecialty() + "\n" + "Cargo: " + getPosition()
                + "\n" + "ID: " + getId() + "\n" + "Salário: " + getSalary());
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public double getSalary() {
        return 1000 + 1000 * specialty.getId();
    }

    public void appointment(SystemHospital system, Map<Integer, MedicalRecords> medicalRecordsMap, Doctor doctor) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("\nId do paciente: ");
            int idPatient = input.nextInt();
            input.nextLine(); // Consumir a quebra de linha pendente

            Patient patient = system.findPatientById(idPatient);

            int idConsulta = medicalRecordsMap.get(idPatient).getAppointments().size() + 1;

            System.out.println("\nMotivo da consulta: ");
            String reasonOfAppointment = input.nextLine();

            System.out.println("\nSintomas: ");
            String symptoms = input.nextLine();

            System.out.println("\nDiagnóstico: ");
            String diagnosis = input.nextLine();

            System.out.println("\nPrescrição: ");
            String prescription = input.nextLine();

            System.out.println("\nExame: ");
            String test = input.nextLine();

            System.out.println("\nResultado do exame: ");
            String testResults = input.nextLine();

            MedicalRecords medicalRecords = medicalRecordsMap.get(idPatient);

            if (medicalRecords == null) {
                MedicalRecords newMedicalRecords = new MedicalRecords(patient, idPatient);

                newMedicalRecords.createAppointment(doctor, reasonOfAppointment, symptoms, diagnosis, prescription,
                        test,
                        testResults, idConsulta);
                medicalRecordsMap.put(idPatient, newMedicalRecords);
                System.out.println("====== Consulta cadastrada com sucesso! ======");

                return;
            } else {
                medicalRecords.createAppointment(doctor, reasonOfAppointment, symptoms, diagnosis, prescription, test,
                        testResults, idConsulta);
                medicalRecordsMap.put(idPatient, medicalRecords);

                System.out.println("====== Consulta cadastrada com sucesso! ======");

                return;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeAppointment(SystemHospital system, Map<Integer, MedicalRecords> medicalRecordsMap)
            throws Exception {

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("\nId do paciente: ");
            int idPatient = input.nextInt();
            Patient patient = system.findPatientById(idPatient);

            MedicalRecords medicalRecords = medicalRecordsMap.get(idPatient);

            if (medicalRecords == null || patient == null) {
                throw new Exception("Prontuário não encontrado ou paciente não encontrado!");
            }

            medicalRecords.toString();
            System.out.println("\nId da consulta: ");
            int idAppointment = input.nextInt();
            Appointment appointment = medicalRecords.findAppointmentById(idAppointment);

            medicalRecords.removeAppointment(appointment);
            medicalRecordsMap.put(idPatient, medicalRecords);

            System.out.println("====== Consulta removida com sucesso! ======");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAppointment(SystemHospital system, Map<Integer, MedicalRecords> medicalRecordsMap)
            throws Exception {
        try {

            Scanner input = new Scanner(System.in);

            System.out.println("\nId do paciente: ");
            int idPatient = input.nextInt();
            input.nextLine(); // Consumindo o \n
            Patient patient = system.findPatientById(idPatient);

            MedicalRecords medicalRecords = medicalRecordsMap.get(idPatient);

            if (patient == null || medicalRecords == null) {
                throw new Exception("Paciente não encontrado ou conulta não encontrada.");
            }

            medicalRecords.toString();
            System.out.println("\nId da consulta: ");
            int idAppointment = input.nextInt();
            input.nextLine(); // Consumindo o \n
            Appointment appointment = medicalRecords.findAppointmentById(idAppointment);

            System.out.println("\nMotivo da consulta: ");
            String reasonOfAppointment = input.nextLine();

            System.out.println("\nSintomas: ");
            String symptoms = input.nextLine();

            System.out.println("\nDiagnóstico: ");
            String diagnosis = input.nextLine();

            System.out.println("\nPrescrição: ");
            String prescription = input.nextLine();

            System.out.println("\nExame: ");
            String test = input.nextLine();

            System.out.println("\nResultado do exame: ");
            String testResults = input.nextLine();

            appointment.setReasonOfAppointment(reasonOfAppointment);
            appointment.setSymptoms(symptoms);
            appointment.setDiagnosis(diagnosis);
            appointment.setPrescription(prescription);
            appointment.setTest(test);
            appointment.setTestResults(testResults);

            System.out.println("====== Consulta atualizada com sucesso! ======");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
