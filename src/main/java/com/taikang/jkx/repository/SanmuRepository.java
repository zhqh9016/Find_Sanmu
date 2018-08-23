package com.taikang.jkx.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.taikang.jkx.entity.Sanmu;

public interface SanmuRepository extends CrudRepository<Sanmu, String> {

	@Query("select sm from Sanmu sm where sm.pinyin like %?1%")
	public List<Sanmu> findSanmuByPinYin(String pinyin,Pageable pageable);
	
	@Query("select count(1) from Sanmu sm where sm.pinyin like %?1%")
	public Integer countSanmuByPinyin(String pinyin);

}
