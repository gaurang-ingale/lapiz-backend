package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subjectId")
    private Long id;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

    public Subject(String name){
        this.name = name;
    }

    public Subject(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Subject(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Subject(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
