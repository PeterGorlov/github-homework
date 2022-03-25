package ua.ithillel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
