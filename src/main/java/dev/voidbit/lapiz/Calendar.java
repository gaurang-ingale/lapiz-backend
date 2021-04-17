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
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="calendar", insertable = false, updatable = false)
    private Student student = null;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="calendar", insertable = false, updatable = false)
    private Teacher teacher = null;
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
