package com.entity.model;

import com.entity.MinsuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 民宿信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-19 10:22:20
 */
public class MinsuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
	 * 客房图片
	 */
	
	private String kefangtupian;
		
	/**
	 * 民宿星级
	 */
	
	private String minsuxingji;
		
	/**
	 * 民宿名称
	 */
	
	private String minsumingcheng;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 民宿地址
	 */
	
	private String minsudizhi;
		
	/**
	 * 民宿介绍
	 */
	
	private String minsujieshao;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
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
	 * 设置：民宿星级
	 */
	 
	public void setMinsuxingji(String minsuxingji) {
		this.minsuxingji = minsuxingji;
	}
	
	/**
	 * 获取：民宿星级
	 */
	public String getMinsuxingji() {
		return minsuxingji;
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
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
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
	 * 设置：民宿介绍
	 */
	 
	public void setMinsujieshao(String minsujieshao) {
		this.minsujieshao = minsujieshao;
	}
	
	/**
	 * 获取：民宿介绍
	 */
	public String getMinsujieshao() {
		return minsujieshao;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
