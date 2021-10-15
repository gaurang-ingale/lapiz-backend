package dev.voidbit.lapiz;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Teacher {
    @GeneratedValue
    @Id
    @Column(name = "teacherId")
    private Long id;
    private String name;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
    private Calendar calendar = new Calendar(this);

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "Student_Teacher",
            joinColumns = { @JoinColumn(name="teacherId")},
            inverseJoinColumns = { @JoinColumn(name = "subjectId")}
    )
    @Setter(AccessLevel.NONE)
    private List<Subject> subjects = new ArrayList<>();

    private void composeNameFromFirstAndLastNames(){
        this.name = this.firstName + " " + this.lastName;
    }

    private void seperateFirstAndLastNamesFromName(){
        String[] names = name.split(" ");
        this.firstName = names[0];
        this.lastName = names[names.length - 1];
    }

    public Teacher(String name) {
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Teacher(Long id, String name){
        this.id = id;
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public Teacher(Long id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }

    public Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }

    public void setName(String name){
        this.name = name;
        seperateFirstAndLastNamesFromName();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
        composeNameFromFirstAndLastNames();
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
        composeNameFromFirstAndLastNames();
    }
}
