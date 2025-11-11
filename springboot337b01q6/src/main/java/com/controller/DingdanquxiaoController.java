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

import com.entity.DingdanquxiaoEntity;
import com.entity.view.DingdanquxiaoView;

import com.service.DingdanquxiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单取消
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
@RestController
@RequestMapping("/dingdanquxiao")
public class DingdanquxiaoController {
    @Autowired
    private DingdanquxiaoService dingdanquxiaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanquxiaoEntity dingdanquxiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			dingdanquxiao.setMinsumingcheng((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			dingdanquxiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();


        //查询结果
		PageUtils page = dingdanquxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanquxiao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanquxiaoEntity dingdanquxiao, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();

        //查询结果
		PageUtils page = dingdanquxiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanquxiao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanquxiaoEntity dingdanquxiao){
       	EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanquxiao, "dingdanquxiao")); 
        return R.ok().put("data", dingdanquxiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanquxiaoEntity dingdanquxiao){
        EntityWrapper< DingdanquxiaoEntity> ew = new EntityWrapper< DingdanquxiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanquxiao, "dingdanquxiao")); 
		DingdanquxiaoView dingdanquxiaoView =  dingdanquxiaoService.selectView(ew);
		return R.ok("查询订单取消成功").put("data", dingdanquxiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanquxiaoEntity dingdanquxiao = dingdanquxiaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(dingdanquxiao,deSens);
        return R.ok().put("data", dingdanquxiao);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanquxiaoEntity dingdanquxiao = dingdanquxiaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(dingdanquxiao,deSens);
        return R.ok().put("data", dingdanquxiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增订单取消") 
    public R save(@RequestBody DingdanquxiaoEntity dingdanquxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanquxiao);
        dingdanquxiaoService.insert(dingdanquxiao);
        return R.ok().put("data",dingdanquxiao.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增订单取消")
    @RequestMapping("/add")
    public R add(@RequestBody DingdanquxiaoEntity dingdanquxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanquxiao);
        dingdanquxiaoService.insert(dingdanquxiao);
        return R.ok().put("data",dingdanquxiao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改订单取消")
    public R update(@RequestBody DingdanquxiaoEntity dingdanquxiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanquxiao);
        //全部更新
        dingdanquxiaoService.updateById(dingdanquxiao);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核订单取消")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<DingdanquxiaoEntity> list = new ArrayList<DingdanquxiaoEntity>();
        for(Long id : ids) {
            DingdanquxiaoEntity dingdanquxiao = dingdanquxiaoService.selectById(id);
            dingdanquxiao.setSfsh(sfsh);
            dingdanquxiao.setShhf(shhf);
            list.add(dingdanquxiao);
        }
        dingdanquxiaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除订单取消")
    public R delete(@RequestBody Long[] ids){
        dingdanquxiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_dingdanquxiao_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                                    if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
                    if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
                                        //获取结果
        List<Map<String, Object>> result = dingdanquxiaoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_dingdanquxiao_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = dingdanquxiaoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_dingdanquxiao_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = dingdanquxiaoService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_dingdanquxiao_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = dingdanquxiaoService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_dingdanquxiao_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = dingdanquxiaoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,DingdanquxiaoEntity dingdanquxiao, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            dingdanquxiao.setMinsumingcheng((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            dingdanquxiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<DingdanquxiaoEntity> ew = new EntityWrapper<DingdanquxiaoEntity>();
        int count = dingdanquxiaoService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanquxiao), params), params));
        return R.ok().put("data", count);
    }

}
