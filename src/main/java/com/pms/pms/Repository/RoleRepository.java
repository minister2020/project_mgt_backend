package com.pms.pms.Repository;

import com.pms.pms.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM Role r WHERE r.role = 1", nativeQuery = true)
    Role findByRole(String role);
}
