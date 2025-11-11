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
import com.utils.UserBasedCollaborativeFiltering;

import com.entity.MinsuxinxiEntity;
import com.entity.view.MinsuxinxiView;

import com.service.MinsuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 民宿信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
@RestController
@RequestMapping("/minsuxinxi")
public class MinsuxinxiController {
    @Autowired
    private MinsuxinxiService minsuxinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MinsuxinxiEntity minsuxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("fangdong")) {
			minsuxinxi.setMinsumingcheng((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();


        //查询结果
		PageUtils page = minsuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,MinsuxinxiEntity minsuxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();

        //查询结果
		PageUtils page = minsuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MinsuxinxiEntity minsuxinxi){
       	EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( minsuxinxi, "minsuxinxi")); 
        return R.ok().put("data", minsuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MinsuxinxiEntity minsuxinxi){
        EntityWrapper< MinsuxinxiEntity> ew = new EntityWrapper< MinsuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( minsuxinxi, "minsuxinxi")); 
		MinsuxinxiView minsuxinxiView =  minsuxinxiService.selectView(ew);
		return R.ok("查询民宿信息成功").put("data", minsuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MinsuxinxiEntity minsuxinxi = minsuxinxiService.selectById(id);
        if(null==minsuxinxi.getClicknum()){
            minsuxinxi.setClicknum(0);
        }
		minsuxinxi.setClicknum(minsuxinxi.getClicknum()+1);
		minsuxinxiService.updateById(minsuxinxi);
        minsuxinxi = minsuxinxiService.selectView(new EntityWrapper<MinsuxinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(minsuxinxi,deSens);
        return R.ok().put("data", minsuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MinsuxinxiEntity minsuxinxi = minsuxinxiService.selectById(id);
        if(null==minsuxinxi.getClicknum()){
            minsuxinxi.setClicknum(0);
        }
		minsuxinxi.setClicknum(minsuxinxi.getClicknum()+1);
		minsuxinxiService.updateById(minsuxinxi);
        minsuxinxi = minsuxinxiService.selectView(new EntityWrapper<MinsuxinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(minsuxinxi,deSens);
        return R.ok().put("data", minsuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增民宿信息") 
    public R save(@RequestBody MinsuxinxiEntity minsuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(minsuxinxi);
        minsuxinxiService.insert(minsuxinxi);
        return R.ok().put("data",minsuxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增民宿信息")
    @RequestMapping("/add")
    public R add(@RequestBody MinsuxinxiEntity minsuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(minsuxinxi);
        minsuxinxiService.insert(minsuxinxi);
        return R.ok().put("data",minsuxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改民宿信息")
    public R update(@RequestBody MinsuxinxiEntity minsuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(minsuxinxi);
        //全部更新
        minsuxinxiService.updateById(minsuxinxi);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核民宿信息")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<MinsuxinxiEntity> list = new ArrayList<MinsuxinxiEntity>();
        for(Long id : ids) {
            MinsuxinxiEntity minsuxinxi = minsuxinxiService.selectById(id);
            minsuxinxi.setSfsh(sfsh);
            minsuxinxi.setShhf(shhf);
            list.add(minsuxinxi);
        }
        minsuxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除民宿信息")
    public R delete(@RequestBody Long[] ids){
        minsuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MinsuxinxiEntity minsuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");

		PageUtils page = minsuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuxinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（基于用户收藏的协同算法）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,MinsuxinxiEntity minsuxinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("tablename", "minsuxinxi"));
        // 创建协同过滤对象
        UserBasedCollaborativeFiltering filter = new UserBasedCollaborativeFiltering();

        // 为指定用户推荐物品
        String targetUser = userId;
        int numRecommendations = limit;
        List<String> recommendations = filter.recommendItems(storeups, "userid", "refid", userId, numRecommendations);

        // 输出推荐结果
        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println(item);
        }

        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        ew.in("id", String.join(",", recommendations));
        if(recommendations!=null && recommendations.size()>0 && recommendations.size()>0) {
            ew.last("order by FIELD(id, "+"'"+String.join("','", recommendations)+"'"+")");
        }

        // 根据协同结果查询结果并返回
        PageUtils page = minsuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuxinxi), params), params));;
        List<MinsuxinxiEntity> pageList = (List<MinsuxinxiEntity>)page.getList();
        if(recommendations!=null && recommendations.size()>0 && pageList.size()<limit) {
            int toAddNum = limit-pageList.size();
            ew = new EntityWrapper<MinsuxinxiEntity>();
            ew.notIn("id", recommendations);
            ew.orderBy("id", false);
            ew.last("limit "+toAddNum);
            pageList.addAll(minsuxinxiService.selectList(ew));
        } else if(pageList.size()>limit) {
            pageList = pageList.subList(0, limit);
        }
        page.setList(pageList);

        return R.ok().put("data", page);
    }




    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_minsuxinxi_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
                                    if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
                                                    //获取结果
        List<Map<String, Object>> result = minsuxinxiService.selectValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_minsuxinxi_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
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
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = minsuxinxiService.selectValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_minsuxinxi_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = minsuxinxiService.selectTimeStatValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("value_minsuxinxi_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
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
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = minsuxinxiService.selectTimeStatValue(params, ew);
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
        java.nio.file.Path path = java.nio.file.Paths.get("group_minsuxinxi_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            ew.eq("minsumingcheng", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = minsuxinxiService.selectGroup(params, ew);
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
    public R count(@RequestParam Map<String, Object> params,MinsuxinxiEntity minsuxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("fangdong")) {
            minsuxinxi.setMinsumingcheng((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<MinsuxinxiEntity> ew = new EntityWrapper<MinsuxinxiEntity>();
        int count = minsuxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, minsuxinxi), params), params));
        return R.ok().put("data", count);
    }

}
