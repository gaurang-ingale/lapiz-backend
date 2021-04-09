package dev.voidbit.lapiz;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Calendar {
    @GeneratedValue
    @Id
    private Long id;
    @OneToOne
    private Student student;
    public Calendar(Long id) {
        this.id = id;
    }

    public Calendar(Student student) {
        this.student = student;
    }

    public Calendar(Long id, Student student) {
    }

    public Calendar(Long id, Teacher teacher) {
    }
}
