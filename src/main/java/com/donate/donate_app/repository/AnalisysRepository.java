package com.donate.donate_app.repository;

import com.donate.donate_app.entity.Analisys;
import com.donate.donate_app.enums.StatusAnalisys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnalisysRepository extends JpaRepository<Analisys, Long> {

    @Query("SELECT a FROM Analisys a WHERE a.status = :status")
    List<Analisys> findAnalisysByStatus(@Param("status") StatusAnalisys status);

}
