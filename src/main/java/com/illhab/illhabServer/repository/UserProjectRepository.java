package com.illhab.illhabServer.repository;

import com.illhab.illhabServer.entity.UserProject;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProject, Long> {

    boolean existsByUserIdAndProjectId(Long userId, Long projectId);

    Optional<UserProject> findByUserIdAndProjectId(Long userId, Long projectId);
}
