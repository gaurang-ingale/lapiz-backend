package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Teacher {
    @GeneratedValue
    @Id
    private Long id;
    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
