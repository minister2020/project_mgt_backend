package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.AppointmentDto;
import com.pms.pms.Dto.CommentDto;
import com.pms.pms.Entity.Comment;
import com.pms.pms.Entity.Project;
import com.pms.pms.Entity.Staff;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.CommentRepository;
import com.pms.pms.Repository.ProjectRepository;
import com.pms.pms.Repository.StaffRepository;
import com.pms.pms.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

//    @Embedded
//    @Autowired

   // StaffRepository staffDto;
    private final StaffRepository staffDto;

    private final ProjectRepository projectRepository;

    private final StaffRepository staffRepository;

    private final CommentRepository commentRepository;

    public StaffServiceImpl(StaffRepository staffDto, ProjectRepository projectRepository, StaffRepository staffRepository, CommentRepository commentRepository) {
        this.staffDto = staffDto;
        this.projectRepository = projectRepository;
        this.staffRepository  = staffRepository;
        this.commentRepository = commentRepository;
    }

    public Staff createStaff(Staff staff) {
        Staff staff1 = new Staff();
        staff1.setId(staff.getId());
        staff1.setFirstName(staff.getFirstName());
        staff1.setLastName(staff.getLastName());
        staff1.setEmail(staff.getEmail());
        staff1.setPassword(staff.getPassword());
        staff1.setPhone(staff.getPhone());

        return staffDto.save(staff);

    }
    @Override
    public void createCommentToProject(CommentDto commentDto, Long id, Long projectId) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow(() ->
                new ResourceNotFoundException());
        Comment comment1 = new Comment();
        comment1.setTitle(comment1.getTitle());
        comment1.setMessage(commentDto.getMessage());
       comment1.setAuthor(staffRepository.getById(id));
        comment1.setProject(project);
        commentRepository.save(comment1);
    }

    @Override
    public void updateAppointmentStatus(Long appointmentId, AppointmentDto appointmentDto) {

    }


    public List<Staff> getAllStaff() {
// TODO Auto-generated method stub
        return staffDto.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {

        Optional<Staff> staff = Optional.ofNullable(staffDto.findById(id).get());
        if (staff.isPresent()) {
            return Optional.of(staff.get());
        } else {
            throw new ResourceNotFoundException("Staff", "id", id);
        }
    }

    @Override
    public Staff updateStaff(Staff staff, Long id) {

        Staff existingStaff = staffDto.findById(id).get();
        existingStaff.setFirstName(staff.getFirstName());
        existingStaff.setLastName(staff.getLastName());
        existingStaff.setEmail(staff.getEmail());
        existingStaff.setPassword(staff.getPassword());
        existingStaff.setPhone(staff.getPhone());
        return staffDto.save(staff);

    }

    @Override
    public void deleteStaff(Long id) {
        staffDto.deleteById(id);
    }
}
