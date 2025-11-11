package com.dao;

import com.entity.YudingdingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YudingdingdanVO;
import com.entity.view.YudingdingdanView;


/**
 * 预定订单
 * 
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
public interface YudingdingdanDao extends BaseMapper<YudingdingdanEntity> {
	
	List<YudingdingdanVO> selectListVO(@Param("ew") Wrapper<YudingdingdanEntity> wrapper);
	
	YudingdingdanVO selectVO(@Param("ew") Wrapper<YudingdingdanEntity> wrapper);
	
	List<YudingdingdanView> selectListView(@Param("ew") Wrapper<YudingdingdanEntity> wrapper);

	List<YudingdingdanView> selectListView(Pagination page,@Param("ew") Wrapper<YudingdingdanEntity> wrapper);

	
	YudingdingdanView selectView(@Param("ew") Wrapper<YudingdingdanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YudingdingdanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YudingdingdanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YudingdingdanEntity> wrapper);



}
