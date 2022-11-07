package com.pms.pms.service.serviceImpl;

import com.pms.pms.Dto.StaffDto;
import com.pms.pms.Entity.Intern;
import com.pms.pms.Entity.Staff;
import com.pms.pms.Exception.ResourceNotFoundException;
import com.pms.pms.Repository.InternRepository;
import com.pms.pms.Repository.StaffRepository;
import com.pms.pms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Embedded;
import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {

    @Embedded
    @Autowired

    StaffRepository staffDto;

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
