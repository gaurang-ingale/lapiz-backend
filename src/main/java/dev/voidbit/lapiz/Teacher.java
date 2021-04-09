package dev.voidbit.lapiz;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Teacher {
    @GeneratedValue
    @Id
    private Long id;
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(Long id, String name) {
        this.id = id;
    }
}
