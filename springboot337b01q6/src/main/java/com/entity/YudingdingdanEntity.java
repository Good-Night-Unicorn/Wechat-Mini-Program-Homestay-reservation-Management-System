package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 预定订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
@TableName("yudingdingdan")
public class YudingdingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YudingdingdanEntity() {
		
	}
	
	public YudingdingdanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 客房名称
	 */
					
	private String kefangmingcheng;
	
	/**
	 * 房间类型
	 */
					
	private String fangjianleixing;
	
	/**
	 * 客房价格
	 */
					
	private Double kefangjiage;
	
	/**
	 * 房间数量
	 */
					
	private Integer fangjianshuliang;
	
	/**
	 * 总金额
	 */
					
	private Double zongjine;
	
	/**
	 * 客房图片
	 */
					
	private String kefangtupian;
	
	/**
	 * 民宿名称
	 */
					
	private String minsumingcheng;
	
	/**
	 * 民宿地址
	 */
					
	private String minsudizhi;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	/**
	 * 预约时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date yuyueshijian;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：客房名称
	 */
	public void setKefangmingcheng(String kefangmingcheng) {
		this.kefangmingcheng = kefangmingcheng;
	}
	/**
	 * 获取：客房名称
	 */
	public String getKefangmingcheng() {
		return kefangmingcheng;
	}
	/**
	 * 设置：房间类型
	 */
	public void setFangjianleixing(String fangjianleixing) {
		this.fangjianleixing = fangjianleixing;
	}
	/**
	 * 获取：房间类型
	 */
	public String getFangjianleixing() {
		return fangjianleixing;
	}
	/**
	 * 设置：客房价格
	 */
	public void setKefangjiage(Double kefangjiage) {
		this.kefangjiage = kefangjiage;
	}
	/**
	 * 获取：客房价格
	 */
	public Double getKefangjiage() {
		return kefangjiage;
	}
	/**
	 * 设置：房间数量
	 */
	public void setFangjianshuliang(Integer fangjianshuliang) {
		this.fangjianshuliang = fangjianshuliang;
	}
	/**
	 * 获取：房间数量
	 */
	public Integer getFangjianshuliang() {
		return fangjianshuliang;
	}
	/**
	 * 设置：总金额
	 */
	public void setZongjine(Double zongjine) {
		this.zongjine = zongjine;
	}
	/**
	 * 获取：总金额
	 */
	public Double getZongjine() {
		return zongjine;
	}
	/**
	 * 设置：客房图片
	 */
	public void setKefangtupian(String kefangtupian) {
		this.kefangtupian = kefangtupian;
	}
	/**
	 * 获取：客房图片
	 */
	public String getKefangtupian() {
		return kefangtupian;
	}
	/**
	 * 设置：民宿名称
	 */
	public void setMinsumingcheng(String minsumingcheng) {
		this.minsumingcheng = minsumingcheng;
	}
	/**
	 * 获取：民宿名称
	 */
	public String getMinsumingcheng() {
		return minsumingcheng;
	}
	/**
	 * 设置：民宿地址
	 */
	public void setMinsudizhi(String minsudizhi) {
		this.minsudizhi = minsudizhi;
	}
	/**
	 * 获取：民宿地址
	 */
	public String getMinsudizhi() {
		return minsudizhi;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}
	/**
	 * 设置：预约时间
	 */
	public void setYuyueshijian(Date yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	/**
	 * 获取：预约时间
	 */
	public Date getYuyueshijian() {
		return yuyueshijian;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
