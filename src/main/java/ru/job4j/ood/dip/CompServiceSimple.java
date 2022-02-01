package ru.job4j.ood.dip;


import java.util.ArrayList;
import java.util.List;

/*
В данном примере ремонта компьютеров, высокоуровневый класс CompService зависит от класса RepairComp,
а класс RepairComp в свою очередь зависит от класса CompDiagnostic. Это накладывает ограничение на работу класса только
для ремонта компьютеров. Если надо будет добавить в дальнейшем возможность ремонта, например телефонов, то необ-
ходимо будет дорабатывать классы RepairComp и CompDiagnostic и вводить дополнительное поле type.
 */

public class CompServiceSimple {
    public static void main(String[] args) {
        CompService service = new CompService();
        Comp pc1000 = new Comp("PC1000");
        service.compRegister(pc1000);
        System.out.println(service.getCompList().get(0).getModel());
        service.repair(pc1000);
        System.out.println(service.getCompList().get(0).getStatus());
    }
}

class CompService {
    private final List<Comp> compList = new ArrayList<>();

    public void compRegister(Comp comp) {
        compList.add(comp);
    }

    public List<Comp> getCompList() {
        return compList;
    }

    public void repair(Comp comp) {
        boolean repairResult = RepairComp.repair(comp);
        if (repairResult) {
            comp.setStatus("fixed");
        } else {
            System.out.println("Нельзя починить");
        }
    }
}

class Comp {
    private String model;
    private String status;

    public Comp(String model) {
        this.model = model;
        this.status = "broken";
    }

    public String getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String statRepair) {
        status = statRepair;
    }
}

class RepairComp {
    boolean result;

    public RepairComp(Comp comp) {
        this.result = false;
    }

    public static boolean repair(Comp comp) {
        boolean result = false;
        CompDiagnostic diagnostic = new CompDiagnostic();
        if (diagnostic.diagnose(comp).contains("видеокарта")) {
            System.out.println("Меняю видеокарту");
            result = true;
        }
        return result;
    }
}

class CompDiagnostic {
    public String diagnose(Comp comp) {
       return "У " + comp + " не работает видеокарта";
    }
}