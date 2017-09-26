package com.turing.huiyuan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HyglHuiyuan {
	private String hyId;

	private String crfId;

	private String hyName;

	private String hyNo;

	private BigDecimal hyAge;

	private String hySex;

	private Date hyBirth;

	private String hyGongzhuodanwei;

	private String hyShenfenzheng;

	private String hyZhiye;

	private String hyXuexing;

	private Long hyShengao;

	private Long hyTizhong;

	private String hyYoubian;

	private String hyEmail;

	private String hyHunyinqingkuang;

	private Date hyInDate;

	private Date hyOutDate;

	private String hyPhone;

	private String hyInfo;

	private String hyPic;

	private String crfName;
	
	private Integer tianshu;

	public String getHyId() {
		return hyId;
	}

	public void setHyId(String hyId) {
		this.hyId = hyId == null ? null : hyId.trim();
	}

	public String getCrfId() {
		return crfId;
	}

	public void setCrfId(String crfId) {
		this.crfId = crfId == null ? null : crfId.trim();
	}

	public String getHyName() {
		return hyName;
	}

	public void setHyName(String hyName) {
		this.hyName = hyName == null ? null : hyName.trim();
	}

	public String getHyNo() {
		return hyNo;
	}

	public void setHyNo(String hyNo) {
		this.hyNo = hyNo == null ? null : hyNo.trim();
	}

	public BigDecimal getHyAge() {
		return hyAge;
	}

	public void setHyAge(BigDecimal hyAge) {
		this.hyAge = hyAge;
	}

	public String getHySex() {
		return hySex;
	}

	public void setHySex(String hySex) {
		this.hySex = hySex == null ? null : hySex.trim();
	}

	public Date getHyBirth() {
		return hyBirth;
	}

	public void setHyBirth(Date hyBirth) {
		this.hyBirth = hyBirth;
	}

	public String getHyGongzhuodanwei() {
		return hyGongzhuodanwei;
	}

	public void setHyGongzhuodanwei(String hyGongzhuodanwei) {
		this.hyGongzhuodanwei = hyGongzhuodanwei == null ? null
				: hyGongzhuodanwei.trim();
	}

	public String getHyShenfenzheng() {
		return hyShenfenzheng;
	}

	public void setHyShenfenzheng(String hyShenfenzheng) {
		this.hyShenfenzheng = hyShenfenzheng == null ? null : hyShenfenzheng
				.trim();
	}

	public String getHyZhiye() {
		return hyZhiye;
	}

	public void setHyZhiye(String hyZhiye) {
		this.hyZhiye = hyZhiye == null ? null : hyZhiye.trim();
	}

	public String getHyXuexing() {
		return hyXuexing;
	}

	public void setHyXuexing(String hyXuexing) {
		this.hyXuexing = hyXuexing == null ? null : hyXuexing.trim();
	}

	public Long getHyShengao() {
		return hyShengao;
	}

	public void setHyShengao(Long hyShengao) {
		this.hyShengao = hyShengao;
	}

	public Long getHyTizhong() {
		return hyTizhong;
	}

	public void setHyTizhong(Long hyTizhong) {
		this.hyTizhong = hyTizhong;
	}

	public String getHyYoubian() {
		return hyYoubian;
	}

	public void setHyYoubian(String hyYoubian) {
		this.hyYoubian = hyYoubian == null ? null : hyYoubian.trim();
	}

	public String getHyEmail() {
		return hyEmail;
	}

	public void setHyEmail(String hyEmail) {
		this.hyEmail = hyEmail == null ? null : hyEmail.trim();
	}

	public String getHyHunyinqingkuang() {
		return hyHunyinqingkuang;
	}

	public void setHyHunyinqingkuang(String hyHunyinqingkuang) {
		this.hyHunyinqingkuang = hyHunyinqingkuang == null ? null
				: hyHunyinqingkuang.trim();
	}

	public Date getHyInDate() {
		return hyInDate;
	}

	public void setHyInDate(Date hyInDate) {
		this.hyInDate = hyInDate;
	}

	public Date getHyOutDate() {
		return hyOutDate;
	}

	public void setHyOutDate(Date hyOutDate) {
		this.hyOutDate = hyOutDate;
	}

	public String getHyPhone() {
		return hyPhone;
	}

	public void setHyPhone(String hyPhone) {
		this.hyPhone = hyPhone == null ? null : hyPhone.trim();
	}

	public String getHyInfo() {
		return hyInfo;
	}

	public void setHyInfo(String hyInfo) {
		this.hyInfo = hyInfo == null ? null : hyInfo.trim();
	}

	public String getHyPic() {
		return hyPic;
	}

	public void setHyPic(String hyPic) {
		this.hyPic = hyPic == null ? null : hyPic.trim();
	}

	public String getCrfName() {
		return crfName;
	}

	public void setCrfName(String crfName) {
		this.crfName = crfName;
	}

	@Override
	public String toString() {
		return "HyglHuiyuan [hyId=" + hyId + ", crfId=" + crfId + ", hyName="
				+ hyName + ", hyNo=" + hyNo + ", hyAge=" + hyAge + ", hySex="
				+ hySex + ", hyBirth=" + hyBirth + ", hyGongzhuodanwei="
				+ hyGongzhuodanwei + ", hyShenfenzheng=" + hyShenfenzheng
				+ ", hyZhiye=" + hyZhiye + ", hyXuexing=" + hyXuexing
				+ ", hyShengao=" + hyShengao + ", hyTizhong=" + hyTizhong
				+ ", hyYoubian=" + hyYoubian + ", hyEmail=" + hyEmail
				+ ", hyHunyinqingkuang=" + hyHunyinqingkuang + ", hyInDate="
				+ hyInDate + ", hyOutDate=" + hyOutDate + ", hyPhone="
				+ hyPhone + ", hyInfo=" + hyInfo + ", hyPic=" + hyPic
				+ ", crfName=" + crfName + "]";
	}

	public Integer getTianshu() {
		return tianshu;
	}

	public void setTianshu(Integer tianshu) {
		this.tianshu = tianshu;
	}
}