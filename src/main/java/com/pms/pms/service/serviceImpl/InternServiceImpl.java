package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.InternDto;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Project;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.InternRepository;
import com.pms.pms.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Embedded;
import java.util.List;
import java.util.Optional;


@Service
public class InternServiceImpl implements InternService {
    @Embedded
    @Autowired

    InternRepository internDto;

    public Intern createIntern(Intern intern) {
        Intern intern1 = new Intern();
        intern1.setId(intern.getId());
        intern1.setFirstName(intern.getFirstName());
        intern1.setLastName(intern.getLastName());
        intern1.setEmail(intern.getEmail());
        intern1.setPassword(intern.getPassword());
        intern1.setPhone(intern.getPhone());

        return internDto.save(intern);

    }

    public List<Intern> getAllIntern() {
// TODO Auto-generated method stub
        return internDto.findAll();
    }

    @Override
    public Optional<Intern> getInternById(Long id) {

        Optional<Intern> intern = Optional.ofNullable(internDto.findById(id).get());
        if (intern.isPresent()) {
            return Optional.of(intern.get());
        } else {
            throw new ResourceNotFoundException("Intern", "id", id);
        }
    }

    @Override
    public Intern updateIntern(Intern intern, Long id) {

    Intern existingIntern = internDto.findById(id).get();
    existingIntern.setFirstName(intern.getFirstName());
    existingIntern.setLastName(intern.getLastName());
    existingIntern.setEmail(intern.getEmail());
    existingIntern.setPassword(intern.getPassword());
    existingIntern.setPhone(intern.getPhone());
    return internDto.save(intern);

    }

    @Override
    public void deleteIntern(Long id) {
        internDto.deleteById(id);
    }
}