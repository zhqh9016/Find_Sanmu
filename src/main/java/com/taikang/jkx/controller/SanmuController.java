package com.taikang.jkx.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.jkx.entity.DatagridEntity;
import com.taikang.jkx.entity.SanmuAll;
import com.taikang.jkx.repository.SanmuAllRepository;
import com.taikang.jkx.tools.PinYinTools;

@RestController
@RequestMapping("sanmu")
public class SanmuController {
	
	@Autowired
	private SanmuAllRepository sanmuAllRepository;
	
	/**
	 * 根据项目编码查询记录
	 * @param bianma
	 * @return
	 */
	@RequestMapping(path="/bianma",method=RequestMethod.POST)
	public DatagridEntity getSanmuByBianma(String bianma){
		List<SanmuAll> findByXiangmubianma = sanmuAllRepository.findByXiangmubianma(bianma);
		DatagridEntity result = new DatagridEntity();
		if(findByXiangmubianma!=null){
			result.setTotal(1);
			result.getRows().addAll(findByXiangmubianma);
		}else{
			result.setTotal(0);
		}
		return result;
	}
	
	/**
	 * 初始化数据库中的pinyin字段
	 * @return
	 */
	@RequestMapping("/initial")
	public String initialPinyin(){
		long count = sanmuAllRepository.count();
		
		for(int i = 0,j = 0;i<count;j++){
			int pageSize = (int) (count-i>1000 ? 1000 : count-i);
			PageRequest pageable = new PageRequest(j, pageSize);
			Iterable<SanmuAll> findAll = sanmuAllRepository.findAll(pageable );
			Iterator<SanmuAll> iterator = findAll.iterator();
			while(iterator.hasNext()){
				SanmuAll next = iterator.next();
				String mingcheng = next.getXiangmumingcheng();
				String strFirst2Pinyin = PinYinTools.strFirst2Pinyin(mingcheng);
				next.setPinyin(strFirst2Pinyin);
			}
			sanmuAllRepository.save(findAll);
			if(count-i>1000){
				i+=1000;
			}else{
				i = (int) count;
			}
			System.out.println(i);
		}
		return "success";
	}
	
	/**
	 * 根据药品名称首字母查询
	 * @param pinyin
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(path="/pinyin",method=RequestMethod.POST)
	public DatagridEntity getSanmuByPin(String pinyin,int page,int rows){
		String strFirst2Pinyin = "";
		
		if(!StringUtils.isEmpty(pinyin)){
			strFirst2Pinyin = PinYinTools.strFirst2Pinyin(pinyin);
		}
		Integer countSanmuByPinyin = sanmuAllRepository.countSanmuByPinyin(strFirst2Pinyin);
		Pageable pageable = new PageRequest(page-1, rows);
		List<SanmuAll> findSanmuByPinYin = sanmuAllRepository.findSanmuByPinYin(strFirst2Pinyin,pageable );
		DatagridEntity result = new DatagridEntity();
		result.setRows(findSanmuByPinYin);
		result.setTotal(countSanmuByPinyin);
		return result;
	}
}
