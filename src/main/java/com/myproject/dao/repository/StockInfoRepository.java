package com.myproject.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myproject.dao.entity.StockInfoEntity;

public interface StockInfoRepository extends JpaRepository<StockInfoEntity, Long> {

	List<StockInfoEntity> findAll();
	
	List<StockInfoEntity> findByStockId(String stockId);
	
	@Query(value = "SELECT * FROM stock_info WHERE stock_id = :id AND stock_name = :name", 
			nativeQuery = true)
	List<StockInfoEntity> testFind(@Param("id") String id, @Param("name") String name);

}
