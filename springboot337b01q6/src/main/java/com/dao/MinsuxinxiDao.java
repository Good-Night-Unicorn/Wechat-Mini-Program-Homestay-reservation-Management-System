package com.dao;

import com.entity.MinsuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MinsuxinxiVO;
import com.entity.view.MinsuxinxiView;


/**
 * 民宿信息
 * 
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
public interface MinsuxinxiDao extends BaseMapper<MinsuxinxiEntity> {
	
	List<MinsuxinxiVO> selectListVO(@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);
	
	MinsuxinxiVO selectVO(@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);
	
	List<MinsuxinxiView> selectListView(@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);

	List<MinsuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);

	
	MinsuxinxiView selectView(@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MinsuxinxiEntity> wrapper);



}
