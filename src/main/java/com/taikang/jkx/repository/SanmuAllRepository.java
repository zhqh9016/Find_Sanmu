package com.taikang.jkx.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.taikang.jkx.entity.SanmuAll;

public interface SanmuAllRepository extends PagingAndSortingRepository<SanmuAll, Integer> {
	
	@Query("select sm from SanmuAll sm where sm.pinyin like %?1%")
	public List<SanmuAll> findSanmuByPinYin(String pinyin,Pageable pageable);
	
	@Query("select count(1) from SanmuAll sm where sm.pinyin like %?1%")
	public Integer countSanmuByPinyin(String pinyin);
	
	public List<SanmuAll> findByXiangmubianma(String bianma);

}
