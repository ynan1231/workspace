package cn.tianya.pay;

/**
 * @FileName: DsPayReturnDto.java <br>
 * @Creater: chencc <br>
 * @version V1.0 <br>
 * @Description: <br>
 */
public class PayReturnDto {

	private String versionId;	//版本号
	private String invokeType;	//支付接口类型,1 前台支付;2后台支付,33g支付
	private String merId;	//商家ID
	private String signType;	//签名类型,1:MD5		
	private String merOrder;	//商家订单号
	private String currency;	//货币类型,RMB人民币 ,TYB天涯贝,TYT天涯分
	private String payAmount;	//支付金额
	private String dealId;	//处理订单号
	private String dealTime;	
	private String channel;
	private String channelSubType;
	private String notify;
	private String payResult;
	private String errCode;
	private String ext1;
	private String ext2;
	private String signMsg;

	private String merKey;
	private Integer updateOrderStatus;

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

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getMerOrder() {
		return merOrder;
	}

	public void setMerOrder(String merOrder) {
		this.merOrder = merOrder;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannelSubType() {
		return channelSubType;
	}

	public void setChannelSubType(String channelSubType) {
		this.channelSubType = channelSubType;
	}

	public String getNotify() {
		return notify;
	}

	public void setNotify(String notify) {
		this.notify = notify;
	}

	public String getPayResult() {
		return payResult;
	}

	public void setPayResult(String payResult) {
		this.payResult = payResult;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
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

	public String getMerKey() {
		return merKey;
	}

	public void setMerKey(String merKey) {
		this.merKey = merKey;
	}

	public Integer getUpdateOrderStatus() {
		return updateOrderStatus;
	}

	public void setUpdateOrderStatus(Integer updateOrderStatus) {
		this.updateOrderStatus = updateOrderStatus;
	}

	@Override
	public String toString() {
		return "PayReturnDto [versionId=" + versionId + ", invokeType=" + invokeType + ", merId=" + merId
				+ ", signType=" + signType + ", merOrder=" + merOrder + ", currency=" + currency + ", payAmount="
				+ payAmount + ", dealId=" + dealId + ", dealTime=" + dealTime + ", channel=" + channel
				+ ", channelSubType=" + channelSubType + ", notify=" + notify + ", payResult=" + payResult
				+ ", errCode=" + errCode + ", ext1=" + ext1 + ", ext2=" + ext2 + ", signMsg=" + signMsg + ", merKey="
				+ merKey + ", updateOrderStatus=" + updateOrderStatus + "]";
	}
	
}
