package com.dao;

import com.entity.DingdanquxiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanquxiaoVO;
import com.entity.view.DingdanquxiaoView;


/**
 * 订单取消
 * 
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
public interface DingdanquxiaoDao extends BaseMapper<DingdanquxiaoEntity> {
	
	List<DingdanquxiaoVO> selectListVO(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
	
	DingdanquxiaoVO selectVO(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
	
	List<DingdanquxiaoView> selectListView(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);

	List<DingdanquxiaoView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);

	
	DingdanquxiaoView selectView(@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DingdanquxiaoEntity> wrapper);



}
