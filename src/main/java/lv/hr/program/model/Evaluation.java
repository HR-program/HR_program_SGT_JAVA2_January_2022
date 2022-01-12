package lv.hr.program.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "employee_id",
            insertable = false,
            updatable = false,
            nullable = false)
    private Employee employee;
}
