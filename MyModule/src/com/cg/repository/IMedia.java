package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.domain.Media;

@Repository
public interface IMedia extends JpaRepository<Media,String>{

@Transactional
@Query("select m.mediaPath from Media m")	
	List<String> getMediaPath();

}
