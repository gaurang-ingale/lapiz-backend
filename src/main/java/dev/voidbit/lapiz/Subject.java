package dev.voidbit.lapiz;

import lombok.*;

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
    @Setter(AccessLevel.NONE)
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    @Setter(AccessLevel.NONE)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private List<Topic> topics = new ArrayList<>();

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
}
