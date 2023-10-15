package de.telran.g10170123ebeshop.repository.jpa;

import de.telran.g10170123ebeshop.domain.entity.jpa.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository <Task, Integer> {
}
