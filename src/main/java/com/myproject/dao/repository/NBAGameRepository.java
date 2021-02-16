package com.myproject.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.dao.entity.NBAGameEntity;

@Repository
public interface NBAGameRepository extends JpaRepository<NBAGameEntity, Long> {

	List<NBAGameEntity> findAll();

	List<NBAGameEntity> findByGameId(String gameId);

	List<NBAGameEntity> findByGameDate(Date gameDate);

	List<NBAGameEntity> findByGameDateAndGameId(Date gameDate, String gameId);

}
