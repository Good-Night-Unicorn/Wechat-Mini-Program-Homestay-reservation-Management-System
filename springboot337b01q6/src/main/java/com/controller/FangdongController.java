package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.FangdongEntity;
import com.entity.view.FangdongView;

import com.service.FangdongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 房东
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
@RestController
@RequestMapping("/fangdong")
public class FangdongController {
    @Autowired
    private FangdongService fangdongService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", username));
        // 当用户不存在或md5方式验证密码不通过时
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
        // 如果用户是待审核状态，返回请联系管理员审核提示
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"fangdong",  "房东" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody FangdongEntity fangdong){
    	//ValidatorUtils.validateEntity(fangdong);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同民宿名称，否则返回错误信息
        if(fangdongService.selectCount(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()))>0) {
            return R.error("民宿名称已存在");
        }
		Long uId = new Date().getTime();
		fangdong.setId(uId);
        //设置登录密码md5方式加密
        fangdong.setMima(EncryptUtil.md5(fangdong.getMima()));
        //保存用户
        fangdongService.insert(fangdong);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        FangdongEntity u = fangdongService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        fangdongService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangdongEntity fangdong,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();


        //查询结果
		PageUtils page = fangdongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FangdongEntity fangdong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();

        //查询结果
		PageUtils page = fangdongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangdong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangdongEntity fangdong){
       	EntityWrapper<FangdongEntity> ew = new EntityWrapper<FangdongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangdong, "fangdong")); 
        return R.ok().put("data", fangdongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangdongEntity fangdong){
        EntityWrapper< FangdongEntity> ew = new EntityWrapper< FangdongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangdong, "fangdong")); 
		FangdongView fangdongView =  fangdongService.selectView(ew);
		return R.ok("查询房东成功").put("data", fangdongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangdongEntity fangdong = fangdongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fangdong,deSens);
        return R.ok().put("data", fangdong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangdongEntity fangdong = fangdongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fangdong,deSens);
        return R.ok().put("data", fangdong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增房东") 
    public R save(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fangdongService.selectCount(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()))>0) {
            return R.error("民宿名称已存在");
        }
        //ValidatorUtils.validateEntity(fangdong);
        //验证账号唯一性，否则返回错误信息
        FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	fangdong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		fangdong.setId(new Date().getTime());
        //密码使用md5方式加密
        fangdong.setMima(EncryptUtil.md5(fangdong.getMima()));
        fangdongService.insert(fangdong);
        return R.ok().put("data",fangdong.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增房东")
    @RequestMapping("/add")
    public R add(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fangdongService.selectCount(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()))>0) {
            return R.error("民宿名称已存在");
        }
        //ValidatorUtils.validateEntity(fangdong);
        //验证账号唯一性，否则返回错误信息
        FangdongEntity u = fangdongService.selectOne(new EntityWrapper<FangdongEntity>().eq("minsumingcheng", fangdong.getMinsumingcheng()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	fangdong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		fangdong.setId(new Date().getTime());
        //密码使用md5方式加密
        fangdong.setMima(EncryptUtil.md5(fangdong.getMima()));
        fangdongService.insert(fangdong);
        return R.ok().put("data",fangdong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改房东")
    public R update(@RequestBody FangdongEntity fangdong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangdong);
        //验证字段唯一性，否则返回错误信息
        if(fangdongService.selectCount(new EntityWrapper<FangdongEntity>().ne("id", fangdong.getId()).eq("minsumingcheng", fangdong.getMinsumingcheng()))>0) {
            return R.error("民宿名称已存在");
        }
	    FangdongEntity fangdongEntity = fangdongService.selectById(fangdong.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(fangdong.getMima()) && !fangdong.getMima().equals(fangdongEntity.getMima())) {
            //密码使用md5方式加密
            fangdong.setMima(EncryptUtil.md5(fangdong.getMima()));
        }
        //全部更新
        fangdongService.updateById(fangdong);
        if(null!=fangdong.getMinsumingcheng())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(fangdong.getMinsumingcheng());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", fangdong.getId()));
        }
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核房东")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<FangdongEntity> list = new ArrayList<FangdongEntity>();
        for(Long id : ids) {
            FangdongEntity fangdong = fangdongService.selectById(id);
            fangdong.setSfsh(sfsh);
            fangdong.setShhf(shhf);
            list.add(fangdong);
        }
        fangdongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除房东")
    public R delete(@RequestBody Long[] ids){
        fangdongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
