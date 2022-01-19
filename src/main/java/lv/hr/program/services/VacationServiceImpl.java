package lv.hr.program.services;

import lv.hr.program.model.Vacation;
import lv.hr.program.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    public VacationServiceImpl(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    @Override
    public Vacation addNewVacation(Vacation vacation) {
        vacationRepository.save(vacation);
        return vacation;
    }
}
