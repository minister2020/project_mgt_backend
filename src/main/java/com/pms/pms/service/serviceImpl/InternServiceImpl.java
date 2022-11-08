package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Appointment;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Project;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.AppointmentRepository;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.Repository.InternRepository;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.service.InternService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InternServiceImpl implements InternService {


    private final InternRepository internDto;

    private final ProjectRepository projectRepository;

    private final InternRepository internRepository;

    private final CommentRepository commentRepository;
    private final AppointmentRepository appointmentRepository;

    public InternServiceImpl(InternRepository internDto, ProjectRepository projectRepository, InternRepository internRepository, CommentRepository commentRepository, AppointmentRepository appointmentRepository) {
        this.internDto = internDto;
        this.projectRepository = projectRepository;
        this.internRepository = internRepository;
        this.commentRepository = commentRepository;
        this.appointmentRepository = appointmentRepository;
    }

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

    @Override
    public void createCommentToProject(CommentDto commentDto, Long id, Long projectId) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow(() ->
                new ResourceNotFoundException());
        Comment comment1 = new Comment();
        comment1.setTitle(comment1.getTitle());
        comment1.setMessage(commentDto.getMessage());
       // comment1.setAuthor(internRepository.getById(id));
        comment1.setProject(project);
        commentRepository.save(comment1);
    }

    @Override
    public Appointment checkAppointmentStatus() {

        Appointment appointmentList = (Appointment) appointmentRepository.findAll();
        System.out.println(appointmentList);

        return (Appointment) appointmentList.getIntern().getAppointments();
    }

    @Override
    public List<Comment> viewALlComment() {
        return commentRepository.findAll();
    }


    public List<Intern> getAllIntern() {
// TODO Auto-generated method stub
        return internDto.findAll();
    }

    public List<Comment> viewAllComment(){
        return commentRepository.findAll();
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