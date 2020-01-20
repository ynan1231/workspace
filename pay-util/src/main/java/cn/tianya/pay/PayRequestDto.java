package cn.tianya.pay;

/**
 * @FileName: DsPayRequestDto.java <br>
 * @Creater: chencc <br>
 * @Date: 2013-7-19 <br>
 * @version V1.0 <br>
 * @Description: <br>
 */
public class PayRequestDto {
	/** 版本 非空 */
	private String versionId;
	
	/** 支付接口类型,1 前台支付;2后台支付,33g支付 非空 */
	private String invokeType;
	
	/** 商家类型 由支付平台分配 */
	private String merId;
	
	/** 商家订单号 非空 不能包含特殊字符 */
	private String merOrder;
	
	/** 支付商品名称 非空 需encode */
	private String merPrdName;
	
	/** 货币类型,RMB人民币 ,TYB天涯贝,TYT天涯分 非空 */
	private String currency;
	
	/** 支付金额,最多两位小数 非空 */
	private String merAmount;
	
	/** 合作商家请求时间 固定格式 yyyyMMddHHmmss 非空 */
	private String merDate;
	
	/** 支付类型 天涯分为77 */
	private String payType;
	
	/** 子支付类型 选填 */
	private String paySubType;
	
	/** 签名类型,1:MD5 非空 */
	private String signType;
	
	/** 通知地址 非空 */
	private String merBackurl;
	/** 编码 */
	private String encode;

	private String userId;
	private String userName;
	private String remark;
	
	/** 扩展字段1 选填 */
	private String ext1;
	
	/** 扩展字段2 选填 */
	private String ext2;
	
	private String signMsg;

	private String accountNo;
	private String accountPwd;

	private String key;
	
	/** 收银台展示地址，支付后跳转的页面 */
	private String productUrl;
	private String bgUrl;

	private String subMerId;

	private String payReqUrl;

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getInvokeType() {
		return invokeType;
	}

	public void setInvokeType(String invokeType) {
		this.invokeType = invokeType;
	}

	public String getMerId() {
		return merId;
	}

	public void setMerId(String merId) {
		this.merId = merId;
	}

	public String getMerOrder() {
		return merOrder;
	}

	public void setMerOrder(String merOrder) {
		this.merOrder = merOrder;
	}

	public String getMerPrdName() {
		return merPrdName;
	}

	public void setMerPrdName(String merPrdName) {
		this.merPrdName = merPrdName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerAmount() {
		return merAmount;
	}

	public void setMerAmount(String merAmount) {
		this.merAmount = merAmount;
	}

	public String getMerDate() {
		return merDate;
	}

	public void setMerDate(String merDate) {
		this.merDate = merDate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getPaySubType() {
		return paySubType;
	}

	public void setPaySubType(String paySubType) {
		this.paySubType = paySubType;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getMerBackurl() {
		return merBackurl;
	}

	public void setMerBackurl(String merBackurl) {
		this.merBackurl = merBackurl;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getSignMsg() {
		return signMsg;
	}

	public void setSignMsg(String signMsg) {
		this.signMsg = signMsg;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBgUrl() {
		return bgUrl;
	}

	public void setBgUrl(String bgUrl) {
		this.bgUrl = bgUrl;
	}

	public String getSubMerId() {
		return subMerId;
	}

	public void setSubMerId(String subMerId) {
		this.subMerId = subMerId;
	}

	public String getProductUrl() {
		return productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getPayReqUrl() {
		return payReqUrl;
	}

	public void setPayReqUrl(String payReqUrl) {
		this.payReqUrl = payReqUrl;
	}

}
