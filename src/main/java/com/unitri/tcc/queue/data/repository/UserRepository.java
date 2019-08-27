package com.unitri.tcc.queue.data.repository;

import com.unitri.tcc.queue.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository< User, Long > {
}
