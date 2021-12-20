package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_id")
    private long id;

    @Column(name = "date_of_evaluation")
    private Calendar dateOfEvaluation;

    @Column(name = "manager_who_evaluates")
    private String managerWhoEvaluates;

    @Column(name = "summary")
    private String summary;
}
