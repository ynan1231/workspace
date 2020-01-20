package cn.tianya.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tianya.util.HttpUtil;
import cn.tianya.util.StringUtil;

/**
 * @FileName: DsPayOrderQueryApi.java <br>
 * @Creater: chencc <br>
 * @version V1.0   
 * <br>
 * @Description: <br>
 */
public class PayOrderQueryHandle {

	private static Logger logger = LoggerFactory.getLogger(PayOrderQueryHandle.class);
	
	public final static String PAYORDER_STATUS_SUCCESS1 = "pay";
	public final static String PAYORDER_STATUS_SUCCESS2 = "notify";
	public final static String PAYORDER_STATUS_FAIL = "cancel";
	public final static String PAYORDER_STATUS_NOEXIST = "noexist";
	
	public final static String PAYINTERFACE_PAYRESULT_SUCCESS = "10";
	public final static String PAYINTERFACE_PAYRESULT_FAIL = "11";
	/**
	  * @Title: queryPayOrderStatus
	  * @Creater: chencc <br>
	  * @Date: 2013-7-20 <br>
	  * @Description: 查询支付订单状态
	  * @param @param orderId
	  * @param @return
	  * @return String
	  * @throws
	 */
	public static String queryPayOrderStatus(String orderId){
		try {
			if(!StringUtil.isNullOrBlank(orderId)){
				/**直接跳转*/
				//核实确认支付订单状态
				String ret = HttpUtil.get(queryRequestUrl(orderId), null, 5000, 10000, "UTF-8");
				
				logger.info("【订单支付状态确认】 orderId:{} ret:{}",orderId,ret);
				
				if(!StringUtil.isNullOrBlank(ret)){
					if(PAYORDER_STATUS_SUCCESS1.equals(ret.trim()) || 
							PAYORDER_STATUS_SUCCESS2.equals(ret.trim()))
						return PAYINTERFACE_PAYRESULT_SUCCESS;//支付订单状态为支付成功
					else if(PAYORDER_STATUS_FAIL.equals(ret.trim()))
						return  PAYINTERFACE_PAYRESULT_FAIL;//支付订单状态为支付失败
				}
			}
		} catch (Exception e) {
			logger.error("查询支付订单状态异常！" , e);
			return "-2";
		}
		return "-1";
	}
	
	private static String queryRequestUrl(String orderId) throws Exception{
		
		StringBuffer requestUrl = new StringBuffer();
		StringBuffer logStr = new StringBuffer("[支付]查询地址组织!");
		try{
			logStr.append(" orderId:=").append(orderId);
			 PayMerchantDto merchantDto = PayMerchantDto.getInstance();
			 requestUrl.append(merchantDto.getQueryUrl());
		    if(merchantDto.getQueryUrl().indexOf("?") > 0) 
				requestUrl.append("&");
			else
				requestUrl.append("?");
			
		    String signStr = "merId=" + merchantDto.getMerchantId() + "&merOrder=" + orderId + "&key=" + merchantDto.getMerchantKey();
			//http://tianyapayHost?merId=..&merOrder=..&signMsg=..
			requestUrl.append("merId=").append(merchantDto.getMerchantId()).append("&merOrder=").append(orderId).append("&signMsg=").append(Md5Encrypt.md5(signStr));
			
			logStr.append(" requestUrl:=").append(requestUrl.toString());
		}catch(Exception ex){
			logger.error(logStr.toString() + ex);
			throw new Exception(ex.getMessage());
		}finally{
			if(logger.isInfoEnabled())
				logger.info(logStr.toString());
		}
		return requestUrl.toString();
		
	}
	
}
