package ua.ithillel.model;

import lombok.*;

@Data
@NoArgsConstructor
public class Employee {
    private Long id;
    private Long departmentId;
    private Long chiefId;
    private String name;
    private int salary;

    public Employee(Long departmentId, Long chiefId, String name, int salary) {
        this.departmentId = departmentId;
        this.chiefId = chiefId;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Long id, Long departmentId, Long chiefId, String name, int salary) {
        this.id = id;
        this.departmentId = departmentId;
        this.chiefId = chiefId;
        this.name = name;
        this.salary = salary;
    }
}
