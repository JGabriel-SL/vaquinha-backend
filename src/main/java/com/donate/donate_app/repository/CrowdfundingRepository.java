package com.donate.donate_app.repository;
import com.donate.donate_app.entity.Crowdfunding;
import com.donate.donate_app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrowdfundingRepository extends JpaRepository<Crowdfunding, Long> {


    @Query("SELECT c FROM Crowdfunding c WHERE users_id = :usersId")
    List<Crowdfunding> findByUsersId(@Param("usersId") Users usersId);
}
