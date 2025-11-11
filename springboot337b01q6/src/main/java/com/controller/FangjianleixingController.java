package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.FangjianleixingEntity;
import com.entity.view.FangjianleixingView;

import com.service.FangjianleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 房间类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
@RestController
@RequestMapping("/fangjianleixing")
public class FangjianleixingController {
    @Autowired
    private FangjianleixingService fangjianleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangjianleixingEntity fangjianleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();


        //查询结果
		PageUtils page = fangjianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangjianleixingEntity fangjianleixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();

        //查询结果
		PageUtils page = fangjianleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangjianleixingEntity fangjianleixing){
       	EntityWrapper<FangjianleixingEntity> ew = new EntityWrapper<FangjianleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangjianleixing, "fangjianleixing")); 
        return R.ok().put("data", fangjianleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangjianleixingEntity fangjianleixing){
        EntityWrapper< FangjianleixingEntity> ew = new EntityWrapper< FangjianleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangjianleixing, "fangjianleixing")); 
		FangjianleixingView fangjianleixingView =  fangjianleixingService.selectView(ew);
		return R.ok("查询房间类型成功").put("data", fangjianleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangjianleixingEntity fangjianleixing = fangjianleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fangjianleixing,deSens);
        return R.ok().put("data", fangjianleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangjianleixingEntity fangjianleixing = fangjianleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fangjianleixing,deSens);
        return R.ok().put("data", fangjianleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增房间类型") 
    public R save(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fangjianleixingService.selectCount(new EntityWrapper<FangjianleixingEntity>().eq("fangjianleixing", fangjianleixing.getFangjianleixing()))>0) {
            return R.error("房间类型已存在");
        }
        //ValidatorUtils.validateEntity(fangjianleixing);
        fangjianleixingService.insert(fangjianleixing);
        return R.ok().put("data",fangjianleixing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增房间类型")
    @RequestMapping("/add")
    public R add(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fangjianleixingService.selectCount(new EntityWrapper<FangjianleixingEntity>().eq("fangjianleixing", fangjianleixing.getFangjianleixing()))>0) {
            return R.error("房间类型已存在");
        }
        //ValidatorUtils.validateEntity(fangjianleixing);
        fangjianleixingService.insert(fangjianleixing);
        return R.ok().put("data",fangjianleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改房间类型")
    public R update(@RequestBody FangjianleixingEntity fangjianleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangjianleixing);
        //验证字段唯一性，否则返回错误信息
        if(fangjianleixingService.selectCount(new EntityWrapper<FangjianleixingEntity>().ne("id", fangjianleixing.getId()).eq("fangjianleixing", fangjianleixing.getFangjianleixing()))>0) {
            return R.error("房间类型已存在");
        }
        //全部更新
        fangjianleixingService.updateById(fangjianleixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除房间类型")
    public R delete(@RequestBody Long[] ids){
        fangjianleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
