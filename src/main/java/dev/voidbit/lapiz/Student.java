package dev.voidbit.lapiz;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Student {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Student(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }
}
