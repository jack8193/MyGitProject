package com.myproject.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myproject.dao.entity.NBATeamEntity;

@Repository
public interface NBATeamRepository extends JpaRepository<NBATeamEntity, Long> {

	List<NBATeamEntity> findAll();

	List<NBATeamEntity> findBySeason(String season);

	List<NBATeamEntity> findBySeasonAndTeamId(String season, String teamId);

}
