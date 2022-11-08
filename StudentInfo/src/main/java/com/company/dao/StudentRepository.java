package com.company.dao;

import com.company.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface StudentRepository extends JpaRepository<Students, Integer> {
}
