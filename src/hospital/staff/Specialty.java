package hospital.staff;

import java.util.*;

public enum Specialty {
    CIRURGIAO_GERAL(1), 
    CLINICO_GERAL(2), 
    DERMATOLOGISTA(3), 
    ENDOCRINOLOGISTA(4), 
    GINECOLOGISTA(5), 
    NEUROLOGISTA(6), 
    OFTALMOLOGISTA(7), 
    ORTOPEDISTA(8), 
    OTORRINOLARINGOLOGISTA(9), 
    PEDIATRA(10), 
    PSIQUIATRA(11), 
    UROLOGISTA(12), 
    ADMINISTRATIVO(13);
    
    private final int id;
    private static final Map<Integer, Specialty> map = new HashMap<>();

    static {
        for (Specialty specialty : Specialty.values()) {
            map.put(specialty.id, specialty);
        }
    }

    Specialty(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Specialty valueOf(int id) {
        return map.get(id);
    }

    public static Specialty[] toArray() {
        return Specialty.values();
    }
}