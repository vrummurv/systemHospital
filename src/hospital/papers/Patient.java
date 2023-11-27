package hospital.papers;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Patient implements Serializable {
    private String name;
    private String birthDate;
    private int id;

    public Patient(String name, String birthDate, int id) {
        this.name = name;
        this.birthDate = birthDate; // ddMMaaaa
        this.id = id;
    }

    public String toString() {
        return "Paciente: " + this.getName() + "\nIdade: " + this.getAge() + "\n" + "Id: " + this.getId() + "\n";
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public int getId(){
        return this.id;
    }

    public int getAge() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Defino formato
        
        LocalDate dateBirth = LocalDate.parse(this.getBirthDate(), formatter); // Converto String para LocalDate e formata
        LocalDate now = LocalDate.now(); // Data atual
        
        Period age = Period.between(dateBirth, now); // Calculo a idade

        return age.getYears();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Defino formato
        
        LocalDate dateBirth = LocalDate.parse(birthDate, formatter); // Converto String para LocalDate e formata
        LocalDate now = LocalDate.now(); // Data atual
        
        Period age = Period.between(dateBirth, now); // Calculo a idade

        if (age.getYears() < 0) {
            System.out.println("Data de nascimento inválida!");
            return;
        }

        this.birthDate = birthDate;
    }

}