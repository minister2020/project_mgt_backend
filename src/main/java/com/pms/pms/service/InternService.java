package com.pms.pms.service;

import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Project;

import java.util.List;
import java.util.Optional;

public interface InternService {

    Intern createIntern(Intern intern);


    List<Intern> getAllIntern();
    Optional<Intern> getInternById(Long id);

    Intern updateIntern(Intern intern, Long id);

    void deleteIntern(Long id);

}
