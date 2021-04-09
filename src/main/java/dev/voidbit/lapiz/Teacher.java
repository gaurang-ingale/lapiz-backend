package dev.voidbit.lapiz;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Teacher {
    @GeneratedValue
    @Id
    private Long id;
    public Teacher(Long id, String name) {
    }

    public String getName() {
        return null;
    }

    public Long getId() {
        return null;
    }
}
