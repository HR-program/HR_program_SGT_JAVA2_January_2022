package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private long id;

    @Column(name = "date_of_evaluation")
    private LocalDate dateOfEvaluation;

    @Column(name = "summary")
    private String summary;

//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            optional = false)
//    @JoinColumn(name = "employee_id",
//            insertable = false,
//            updatable = false,
//            nullable = false)
//    private Employee employee;

    public Evaluation() {
    }

    public Evaluation(LocalDate dateOfEvaluation, String summary, Employee employee) {
        this.dateOfEvaluation = dateOfEvaluation;
        this.summary = summary;
//        this.employee = employee;
    }
}