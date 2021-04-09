package dev.voidbit.lapiz;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Calendar {
    @GeneratedValue
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL)
    @Setter(AccessLevel.NONE)
    private Teacher teacher;
    public Calendar(Long id) {
        this.id = id;
    }

    public Calendar(Student student) {
        this.student = student;
    }

    public Calendar(Teacher teacher){
        this.teacher = teacher;
    }

    public Calendar(Long id, Student student) {
        this.id = id;
        this.student = student;
    }

    public Calendar(Long id, Teacher teacher) {
        this.id = id;
        this.teacher = teacher;
    }
}
