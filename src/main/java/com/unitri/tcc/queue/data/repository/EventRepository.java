package com.unitri.tcc.queue.data.repository;

import com.unitri.tcc.queue.data.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository< Event, Long > {
}
