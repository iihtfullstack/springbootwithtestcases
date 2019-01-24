package com.sunil.springData.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sunil.springData.model.Subject;
@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>  {
	
	@Query("from Subject where subTitle like %:subTitle%")
	public List<Subject> findSubjectsBySubTitle (@Param("subTitle") String subTitle);

}
