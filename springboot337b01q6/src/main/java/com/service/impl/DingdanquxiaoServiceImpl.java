package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DingdanquxiaoDao;
import com.entity.DingdanquxiaoEntity;
import com.service.DingdanquxiaoService;
import com.entity.vo.DingdanquxiaoVO;
import com.entity.view.DingdanquxiaoView;

@Service("dingdanquxiaoService")
public class DingdanquxiaoServiceImpl extends ServiceImpl<DingdanquxiaoDao, DingdanquxiaoEntity> implements DingdanquxiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanquxiaoEntity> page = this.selectPage(
                new Query<DingdanquxiaoEntity>(params).getPage(),
                new EntityWrapper<DingdanquxiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanquxiaoEntity> wrapper) {
		  Page<DingdanquxiaoView> page =new Query<DingdanquxiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DingdanquxiaoVO> selectListVO(Wrapper<DingdanquxiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanquxiaoVO selectVO(Wrapper<DingdanquxiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanquxiaoView> selectListView(Wrapper<DingdanquxiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanquxiaoView selectView(Wrapper<DingdanquxiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<DingdanquxiaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<DingdanquxiaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<DingdanquxiaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
