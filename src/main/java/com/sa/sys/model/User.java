package com.sa.sys.model;

import org.springframework.stereotype.Component;

import com.sa.basic.model.BaseEntity;

@Component
@SuppressWarnings("unused")

public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String userId;  // <USER_ID> 表中主键
	
	private String userCode;	 //<USER_CODE> 
	
	private String userName;  //<USER_NAME>
	
	private String userPwd;  //<USER_PWD>
	
	private int payPwd; //<PAY_PWD>
	
	private  String realName;   //<REAL_NAME>
	
	private int userPhone;  // <USER_PHONE> 
	
	private String userEmail;	 //<USER_EMAIL> 
	
	private String userGrade;  //<USER_GRADE>
	
	private String userType;  //<USER_TYPE>普通/商家会员 类型
	
	private String userProvince; //<USER_PROVINCE>
	
	private  String roleName;   //<ROLE_NAME>
	
	private String userCity;  // <USER_CITY> 
	
	private String userCounty;	 //<USER_COUNTY> 
	
	private String userAddr;  //<USER_ADDR>
	
	private String recommend;  //<RECOMMEND>
	
	private String startTime; //<START_TIME>
	
	private  int state;   //<STATE>
	
	private String moneyWallet;  // <MONEY_WALLET> 
	
	private String shopScore;	 //<SHOP_SCORE> 
	
	private String blockScore;  //<BLOCK_SCORE>
	
	private String dealScore;  //<DEAL_SCORE>
	
	private int expendScore; //<EXPEND_SCORE>
	
	private  String selfLink;   //<SELF_LINK>

	private String idNumber;  //<ID_NUMBER>
	
	private String bankCard;  //<BANK_CARD>
	
	private String bankName; //<BANK_NAME>
	
	private  String bankAddr;   //<BANK_ADDR>
	
	private long sort; //<SORT>

	public String getUserId() {
		return getString("userId");
	}

	public void setUserId(String userId) {
		this.set("userId", userId);
	}

	public String getUserCode() {
		return getString("userCode");
	}

	public void setUserCode(String userCode) {
		this.set("userCode", userCode);
	}

	public String getUserName() {
		return getString("userName");
	}

	public void setUserName(String userName) {
		this.set("userName",userName);
	}

	public String getUserPwd() {
		return getString("userPwd");
	}

	public void setUserPwd(String userPwd) {
		this.set("userPwd",userPwd);
	}

	public int getPayPwd() {
		return getInteger("payPwd");
	}

	public void setPayPwd(int payPwd) {
		this.set("payPwd",payPwd);
	}

	public String getRealName() {
		return getString("realName");
	}

	public void setRealName(String realName) {
		this.set("realName",realName);
	}

	public int getUserPhone() {
		return getInteger("userPhone");
	}

	public void setUserPhone(int userPhone) {
		this.set("userPhone",userPhone);
	}

	public String getUserEmail() {
		return getString("userEmail");
	}

	public void setUserEmail(String userEmail) {
		this.set("userEmail",userEmail);
	}

	public String getUserGrade() {
		return getString("userGrade");
	}

	public void setUserGrade(String userGrade) {
		this.set("userGrade",userGrade);
	}

	public String getUserType() {
		return getString("userType");
	}

	public void setUserType(String userType) {
		this.set("userType",userType);
	}

	public String getUserProvince() {
		return getString("userProvince");
	}

	public void setUserProvince(String userProvince) {
		this.set("userProvince",userProvince);
	}

	public String getRoleName() {
		return getString("roleName");
	}

	public void setRoleName(String roleName) {
		this.set("roleName",roleName);
	}

	public String getUserCity() {
		return getString("userCity");
	}

	public void setUserCity(String userCity) {
		this.set("userCity",userCity);
	}

	public String getUserCounty() {
		return getString("userCounty");
	}

	public void setUserCounty(String userCounty) {
		this.set("userCounty",userCounty);
	}

	public String getUserAddr() {
		return getString("userAddr");
	}

	public void setUserAddr(String userAddr) {
		this.set("userAddr",userAddr);
	}

	public String getRecommend() {
		return getString("recommend");
	}

	public void setRecommend(String recommend) {
		this.set("recommend",recommend);
	}

	public String getStartTime() {
		return getString("startTime");
	}

	public void setStartTime(String startTime) {
		this.set("startTime",startTime);
	}

	public int getState() {
		return getInteger("state");
	}

	public void setState(int state) {
		this.set("state",state);
	}

	public String getMoneyWallet() {
		return getString("moneyWallet");
	}

	public void setMoneyWallet(String moneyWallet) {
		this.set("moneyWallet", moneyWallet);
	}

	public String getShopScore() {
		return getString("shopScore");
	}

	public void setShopScore(String shopScore) {
		this.set("shopScore",shopScore);
	}

	public String getBlockScore() {
		return getString("blockScore");
	}

	public void setBlockScore(String blockScore) {
		this.set("blockScore",blockScore);
	}

	public String getDealScore() {
		return getString("dealScore");
	}

	public void setDealScore(String dealScore) {
		this.set("dealScore",dealScore);
	}

	public int getExpendScore() {
		return getInteger("expendScore");
	}

	public void setExpendScore(int expendScore) {
		this.set("expendScore",expendScore);
	}

	public String getSelfLink() {
		return getString("selfLink");
	}

	public void setSelfLink(String selfLink) {
		this.set("selfLink",selfLink);
	}

	public String getIdNumber() {
		return getString("idNumber");
	}

	public void setIdNumber(String idNumber) {
		this.set("idNumber", idNumber);
	}

	public String getBankCard() {
		return getString("bankCard");
	}

	public void setBankCard(String bankCard) {
		this.set("bankCard",bankCard);
	}

	public String getBankName() {
		return getString("bankName");
	}

	public void setBankName(String bankName) {
		this.set("bankName",bankName);
	}

	public String getBankAddr() {
		return getString("bankAddr");
	}

	public void setBankAddr(String bankAddr) {
		this.set("bankAddr",bankAddr);
	}

	public long getSort() {
		return getLong("sort");
	}

	public void setSort(long sort) {
		this.set("sort",sort);
	}
	
}
