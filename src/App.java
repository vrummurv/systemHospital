import java.util.*;

import javax.print.Doc;

import hospital.*;
import hospital.papers.Admin;
import hospital.papers.Doctor;
import hospital.papers.MedicalRecords;
import hospital.papers.Nurse;
import hospital.papers.Patient;
import hospital.staff.Employee;

// Por que preciso importar isso aqui sendo que ja importei anteriormente
import hospital.staff.Position;
import hospital.staff.Specialty;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SystemHospital system = new SystemHospital();
        Data data = new Data();

        // carregar informações do banco de dados

        for (Employee employee : data.loadEmployees()) {
            system.addEmployee(employee);
        }

        for (Patient patient : data.loadPatients()) {
            system.addPatient(patient);
        }

        for (Map.Entry<Integer, MedicalRecords> medicalRecords : data.loadMedicalRecordsMap().entrySet()) {
            system.addMedicalRecords(medicalRecords.getKey(), medicalRecords.getValue());
        }

        while (true) {
            System.out.println("\n====== Menu ======");
            System.out.println("1. Login");
            System.out.println("2. Salvar dados");
            System.out.println("0. Sair");
            System.out.println("==================");

            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:

                    System.out.print("\nID: ");
                    int id = scanner.nextInt();
                    System.out.print("Senha: ");
                    int senha = scanner.nextInt();

                    if (system.login(id, senha)) {
                        System.out.println("Login realizado com sucesso!");

                        Employee user = system.findEmployeeById(id);
                        if (user != null && user instanceof Admin) {
                            Admin adminUser = (Admin) user;

                            while (true) {
                                System.out.println("\n====== Menu ======");
                                System.out.println("1. Cadastrar Médico");
                                System.out.println("2. Atualizar Médico");
                                System.out.println("3. Excluir Médico");
                                System.out.println("4. Listar Médicos");
                                System.out.println("==================");
                                System.out.println("5. Cadastrar Enfermeiro");
                                System.out.println("6. Atualizar Enfermeiro");
                                System.out.println("7. Excluir Enfermeiro");
                                System.out.println("8. Listar Enfermeiros");
                                System.out.println("==================");
                                System.out.println("9. Cadastrar Paciente");
                                System.out.println("10. Atualizar Paciente");
                                System.out.println("11. Excluir Paciente");
                                System.out.println("12. Listar Pacientes");
                                System.out.println("==================");
                                System.out.println("13. Listar Funcionários");
                                System.out.println("==================");
                                System.out.println("14. Salvar dados");
                                System.out.println("==================");

                                System.out.println("0. Logout");

                                System.out.print("\nEscolha uma opção: ");

                                int opcaoAdm = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do teclado

                                switch (opcaoAdm) {

                                    /* CRUD DE MEDICO */

                                    case 0:
                                        system.logout();
                                        break;

                                    case 1:
                                        System.out.print("\nNome do Médico: ");
                                        String docName = scanner.nextLine();

                                        for (Specialty specialty : Specialty.values()) {
                                            System.out.println(specialty.getId() + " : " + specialty.name());
                                        }
                                        System.out.println("Selcione o número de umas dessas especialidades: ");
                                        int idSpecialty = scanner.nextInt();
                                        while (idSpecialty < 1 || idSpecialty > 12) {
                                            System.out.println("Opção inválida. Tente novamente.");
                                            for (Specialty spe : Specialty.values()) {
                                                System.out.println(spe.getId() + " : " + spe.name());
                                            }
                                            System.out.println("Selcione o número de umas dessas especialidades: ");
                                            idSpecialty = scanner.nextInt();
                                        }
                                        Specialty specialty = Specialty.valueOf(idSpecialty);

                                        System.out.println("Senha: ");
                                        int passDoc = scanner.nextInt();

                                        adminUser.createDoctor(system.getEmployees(), docName, specialty, "Medico",
                                                passDoc, system.getEmployees().size() + 1);
                                        break;

                                    case 2:
                                        System.out.println("====== Médicos cadastrados ======");
                                        system.listDoctors();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do médico que deseja atualizar: ");
                                        int idDocUpdate = scanner.nextInt();
                                        scanner.nextLine(); // Limpar o buffer do teclado

                                        if (system.findEmployeeById(idDocUpdate) == null || system
                                                .findEmployeeById(idDocUpdate).getPosition() != Position.MEDICO) {
                                            System.out.println("Funcionário nao encontrado ou ID invalido");
                                            break;
                                        }

                                        Doctor doctorUpdate = (Doctor) system.findEmployeeById(idDocUpdate);
                                        System.out.print("\nNome do Médico: ");
                                        String docNameUpdate = scanner.nextLine();

                                        System.out.println("Senha: ");
                                        int passDocUpdate = scanner.nextInt();

                                        adminUser.updateDoctor(system.getEmployees(), doctorUpdate, docNameUpdate,
                                                passDocUpdate);
                                        break;

                                    case 3:
                                        System.out.println("====== Médicos cadastrados ======");
                                        system.listDoctors();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do médico que deseja remover: ");
                                        int idDoc = scanner.nextInt();
                                        if (system.findEmployeeById(idDoc) == null || system
                                                .findEmployeeById(idDoc).getPosition() != Position.MEDICO) {
                                            System.out.println("Funcionário nao encontrado ou ID invalido");

                                            break;
                                        }
                                        Employee doctor = system.findEmployeeById(idDoc);
                                        adminUser.removeDoctor(system.getEmployees(), doctor);
                                        break;

                                    case 4:
                                        System.out.println("====== Médicos cadastrados ======");
                                        system.listDoctors();
                                        System.out.println("================================");
                                        break;

                                    /* CRUD DE ENFERMEIRO */

                                    case 5:
                                        System.out.print("\nNome do Enfermeiro: ");
                                        String nurseName = scanner.nextLine();

                                        for (Specialty spe : Specialty.values()) {
                                            System.out.println(spe.getId() + " : " + spe.name());
                                        }
                                        System.out.println("Selcione o número de umas dessas especialidades: ");
                                        int idSpecialtyNurse = scanner.nextInt();

                                        while (idSpecialtyNurse < 1 || idSpecialtyNurse > 12) {
                                            System.out.println("Opção inválida. Tente novamente.");
                                            for (Specialty spe : Specialty.values()) {
                                                System.out.println(spe.getId() + " : " + spe.name());
                                            }
                                            System.out.println("Selcione o número de umas dessas especialidades: ");
                                            idSpecialtyNurse = scanner.nextInt();
                                        }
                                        Specialty specialtyNurse = Specialty.valueOf(idSpecialtyNurse);

                                        System.out.println("Senha: ");
                                        int passNurse = scanner.nextInt();

                                        adminUser.createNurse(system.getEmployees(), nurseName, specialtyNurse,
                                                "Enfermeiro", passNurse, system.getEmployees().size() + 1);
                                        break;

                                    case 6:

                                        System.out.println("====== Enfermeiros cadastrados ======");
                                        system.listNurses();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do enfermeiro que deseja atualizar: ");
                                        int idNurseUpdate = scanner.nextInt();
                                        scanner.nextLine(); // Limpar o buffer do teclado

                                        if (system.findEmployeeById(idNurseUpdate) == null || system
                                                .findEmployeeById(idNurseUpdate).getPosition() != Position.ENFERMEIRO) {
                                            System.out.println("Funcionário nao encontrado ou ID invalido");

                                            break;
                                        }

                                        Nurse nurseUpdate = (Nurse) system.findEmployeeById(idNurseUpdate);
                                        System.out.print("\nNome do Enfermeiro: ");
                                        String nurseNameUpdate = scanner.nextLine();

                                        System.out.println("Senha: ");
                                        int passNurseUpdate = scanner.nextInt();

                                        adminUser.updateNurse(system.getEmployees(), nurseUpdate, nurseNameUpdate,
                                                passNurseUpdate);
                                        break;

                                    case 7:
                                        System.out.println("====== Enfermeiros cadastrados ======");
                                        system.listNurses();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do enfermeiro que deseja remover: ");
                                        int idNurse = scanner.nextInt();

                                        if (system.findEmployeeById(idNurse) == null || system
                                                .findEmployeeById(idNurse).getPosition() != Position.ENFERMEIRO) {
                                            System.out.println("Funcionário nao encontrado ou ID invalido");

                                            break;
                                        }
                                        Employee nurse = system.findEmployeeById(idNurse);
                                        adminUser.removeNurse(system.getEmployees(), nurse);
                                        break;

                                    case 8:
                                        System.out.println("====== Enfermeiros cadastrados ======");
                                        system.listNurses();
                                        System.out.println("================================");
                                        break;

                                    /* CRUD DE PACIENTE */

                                    case 9:
                                        System.out.print("\nNome do Paciente: ");
                                        String patientName = scanner.nextLine();

                                        System.out.print("Data de nascimento: ");
                                        String birthDate = scanner.nextLine();

                                        adminUser.createPatient(system.getMedicalRecordsMap(), system.getPatients(),
                                                patientName, birthDate, system.getPatients().size() + 1);
                                        break;

                                    case 10:
                                        System.out.println("====== Pacientes cadastrados ======");
                                        system.listPatients();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do paciente que deseja atualizar: ");
                                        int idPatientUpdate = scanner.nextInt();
                                        Patient patientUpdate = system.findPatientById(idPatientUpdate);
                                        scanner.nextLine(); // Limpar o buffer do teclado

                                        if (patientUpdate == null) {
                                            break;
                                        }

                                        System.out.print("\nNome do Paciente: ");
                                        String patientNameUpdate = scanner.nextLine();

                                        System.out.print("Data de nascimento: ");
                                        String birthDateUpdate = scanner.nextLine();

                                        adminUser.updatePatient(system.getPatients(), patientUpdate,
                                                patientNameUpdate, birthDateUpdate);
                                        break;

                                    case 11:
                                        System.out.println("====== Pacientes cadastrados ======");
                                        system.listPatients();
                                        System.out.println("================================");
                                        System.out.println("Digite o ID do paciente que deseja remover: ");
                                        int idPatient = scanner.nextInt();
                                        Patient patient = system.findPatientById(idPatient);
                                        if (patient == null) {
                                            break;
                                        }
                                        adminUser.removePatient(system.getPatients(), patient);
                                        break;

                                    case 12:
                                        System.out.println("====== Pacientes cadastrados ======");
                                        system.listPatients();
                                        System.out.println("================================");
                                        break;
                                    case 13:
                                        System.out.println("====== Funcionários cadastrados ======");
                                        system.listEmployees();
                                        System.out.println("================================");
                                        break;

                                    case 14:
                                        data.saveEmployees(system.getEmployees());
                                        data.savePatients(system.getPatients());
                                        data.saveMedicalRecordsMap(system.getMedicalRecordsMap());
                                        break;

                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }

                                if (opcaoAdm == 0) {
                                    System.out.println("Saindo do sistema. Até mais!");
                                    break;
                                }
                            }

                        } else if (user != null && user instanceof Doctor) {
                            Doctor doctorUser = (Doctor) user;

                            while (true) {
                                System.out.println("\n====== Menu ======");
                                System.out.println("1. Cadastrar Consulta");
                                System.out.println("2. Atualizar Consulta");
                                System.out.println("3. Excluir Consulta");
                                System.out.println("4. Listar Consultas");
                                System.out.println("5. Ver Consulta por ID de Paciente");
                                System.out.println("==================");
                                System.out.println("0. Logout");

                                System.out.print("\nEscolha uma opção: ");

                                int opcaoDoc = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do teclado

                                switch (opcaoDoc) {

                                    case 0:
                                        system.logout();
                                        break;

                                    case 1:
                                        doctorUser.appointment(system, system.getMedicalRecordsMap(), doctorUser);
                                        break;

                                    case 2:
                                        doctorUser.updateAppointment(system, system.getMedicalRecordsMap());
                                        break;

                                    case 3:
                                        doctorUser.removeAppointment(system, system.getMedicalRecordsMap());
                                        break;

                                    case 4:
                                        System.out.println("====== Consultas cadastradas ======");
                                        system.listMedicalRecords();
                                        System.out.println("================================");
                                        break;

                                    case 5:
                                        System.out.println("Digite o ID do paciente: ");
                                        int idPatient = scanner.nextInt();
                                        scanner.nextLine(); // Limpar o buffer do teclado

                                        Patient patient = system.findPatientById(idPatient);
                                        if (patient == null) {
                                            break;
                                        }

                                        System.out.println("====== Consultas cadastradas do paciente "
                                                + patient.getName() + " ======");
                                        system.listMedicalRecordsByPatientId(idPatient);
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }

                                if (opcaoDoc == 0) {
                                    System.out.println("Saindo do sistema. Até mais!");
                                    break;
                                }
                            }
                        } else if (user != null && user instanceof Nurse) {
                            Nurse nurseUser = (Nurse) user;

                            while (true) {
                                System.out.println("\n====== Menu ======");
                                System.out.println("1. Atualizar Prontuário");
                                System.out.println("2. Listar Consultas");
                                System.out.println("==================");
                                System.out.println("0. Logout");

                                System.out.print("\nEscolha uma opção: ");

                                int opcaoNurse = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer do teclado

                                switch (opcaoNurse) {

                                    case 0:
                                        system.logout();
                                        break;

                                    case 1:
                                        nurseUser.updateAppointment(system, system.getMedicalRecordsMap());
                                        break;

                                    case 2:
                                        System.out.println("====== Consultas cadastradas ======");
                                        system.listMedicalRecords();
                                        System.out.println("================================");
                                        break;

                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                        break;
                                }

                                if (opcaoNurse == 0) {
                                    System.out.println("Saindo do sistema. Até mais!");
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Login ou senha inválidos!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (opcao == 0) {
                break;
            }
        }
    }
}