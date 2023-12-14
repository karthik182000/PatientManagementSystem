package org.application.repository;


import org.application.entity.Prescriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriberRepository extends JpaRepository<Prescriber, Long> {

}
