package dev.voidbit.lapiz;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String firstName;
    private String lastName;

    public Student(String name){
        this.name = name;
    }

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
