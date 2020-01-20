package cn.tianya.pay;

import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @FileName: DsReturnDataHandle.java <br>
 * @Creater: chencc <br>
 * @version V1.0 <br>
 * @Description: <br>
 */
public class PayReturnDataHandle {

	private static Logger logger = LoggerFactory.getLogger(PayReturnDataHandle.class);

	/**
	 * @Title: getReturnParams @Creater: chencc <br> @Description:
	 * TODO[打赏支付]支付返回!获得原始对象 @param @param paraMap @param @return @param @throws
	 * Exception @return DsPayReturnDto @throws
	 */
	public static PayReturnDto getReturnParams(Map<String, Object> paraMap) throws Exception {

		PayReturnDto dto = new PayReturnDto();
		StringBuffer logStr = new StringBuffer("[打赏支付]支付返回!获得原始对象!");
		try {
			if (null != MapUtils.getString(paraMap, "versionId"))
				dto.setVersionId(MapUtils.getString(paraMap, "versionId").trim());
			if (null != MapUtils.getString(paraMap, "invokeType"))
				dto.setInvokeType(MapUtils.getString(paraMap, "invokeType").trim());
			if (null != MapUtils.getString(paraMap, "merId"))
				dto.setMerId(MapUtils.getString(paraMap, "merId").trim());
			if (null != MapUtils.getString(paraMap, "signType"))
				dto.setSignType(MapUtils.getString(paraMap, "signType").trim());
			if (null != MapUtils.getString(paraMap, "merOrder"))
				dto.setMerOrder(MapUtils.getString(paraMap, "merOrder").trim());
			if (null != MapUtils.getString(paraMap, "currency"))
				dto.setCurrency(MapUtils.getString(paraMap, "currency").trim());
			if (null != MapUtils.getString(paraMap, "payAmount"))
				dto.setPayAmount(MapUtils.getString(paraMap, "payAmount").trim());
			if (null != MapUtils.getString(paraMap, "dealId"))
				dto.setDealId(MapUtils.getString(paraMap, "dealId").trim());
			if (null != MapUtils.getString(paraMap, "dealTime"))
				dto.setDealTime(MapUtils.getString(paraMap, "dealTime").trim());
			if (null != MapUtils.getString(paraMap, "channel"))
				dto.setChannel(MapUtils.getString(paraMap, "channel").trim());
			if (null != MapUtils.getString(paraMap, "channelSubType"))
				dto.setChannelSubType(MapUtils.getString(paraMap, "channelSubType").trim());

			if (null != MapUtils.getString(paraMap, "notify"))
				dto.setNotify(MapUtils.getString(paraMap, "notify").trim());
			if (null != MapUtils.getString(paraMap, "payResult"))
				dto.setPayResult(MapUtils.getString(paraMap, "payResult").trim());

			if (null != MapUtils.getString(paraMap, "errCode"))
				dto.setErrCode(MapUtils.getString(paraMap, "errCode").trim());
			if (null != MapUtils.getString(paraMap, "ext1"))
				dto.setExt1(MapUtils.getString(paraMap, "ext1").trim());
			if (null != MapUtils.getString(paraMap, "ext2"))
				dto.setExt2(MapUtils.getString(paraMap, "ext2").trim());

			if (null != MapUtils.getString(paraMap, "signMsg"))
				dto.setSignMsg(MapUtils.getString(paraMap, "signMsg").trim());

			logStr.append(" versionId:=").append(dto.getVersionId()).append(" invokeType:=").append(dto.getInvokeType())
					.append(" merId:=").append(dto.getMerId()).append(" signType:=").append(dto.getSignType())
					.append(" merOrder:=").append(dto.getMerOrder()).append(" currency:=").append(dto.getCurrency())
					.append(" payAmount:=").append(dto.getPayAmount()).append(" dealId:=").append(dto.getDealId())
					.append(" dealTime:=").append(dto.getDealTime()).append(" channel:=").append(dto.getChannel())
					.append(" channelSubType:=").append(dto.getChannelSubType()).append(" notify:=")
					.append(dto.getNotify()).append(" payResult:=").append(dto.getPayResult()).append(" signMsg:=")
					.append(dto.getSignMsg());
			if (null != dto.getErrCode())
				logStr.append(" errCode:=").append(dto.getErrCode());
			if (null != dto.getExt1())
				logStr.append(" ext1:=").append(dto.getExt1());
			if (null != dto.getExt2())
				logStr.append(" ext2:=").append(dto.getExt2());
		} catch (Exception ex) {
			logger.error("[打赏支付]支付返回!获得原始对象异常!", ex);
			throw new Exception(ex.getMessage());
		} finally {
			if (logger.isInfoEnabled())
				logger.info(logStr.toString());
		}

		return dto;
	}

	/**
	 * @Title: checkReturnParams @Creater: chencc <br> @Date: 2013-7-19
	 * <br> @Description: TODO[打赏]支付返回!校验签名 @param @param
	 * dto @param @return @param @throws Exception @return boolean @throws
	 */
	public static boolean checkReturnParams(PayReturnDto dto) throws Exception {

		StringBuffer logStr = new StringBuffer("[打赏]支付返回!校验签名!");
		boolean flag = false;
		try {
			StringBuffer signStr = new StringBuffer();
			// 需要签名的字段和顺序如下：
			// versionId=..&invokeType=..&merId=..&signType=..&merOrder=..&currency=..&payAmount=..&dealId=..&dealTime=..&channel=..&channelSubType=..&notify=..&payResult=..&key=..
			signStr.append("versionId=").append(dto.getVersionId()).append("&invokeType=").append(dto.getInvokeType())
					.append("&merId=").append(dto.getMerId()).append("&signType=").append(dto.getSignType())
					.append("&merOrder=").append(dto.getMerOrder()).append("&currency=").append(dto.getCurrency())
					.append("&payAmount=").append(dto.getPayAmount()).append("&dealId=").append(dto.getDealId())
					.append("&dealTime=").append(dto.getDealTime()).append("&channel=").append(dto.getChannel())
					.append("&channelSubType=").append(dto.getChannelSubType()).append("&notify=")
					.append(dto.getNotify()).append("&payResult=").append(dto.getPayResult()).append("&key=")
					.append(PayMerchantDto.getInstance().getMerchantKey());

			logStr.append(" orderId:=").append(dto.getDealId()).append(" signStr:=").append(signStr.toString());
			String sign = Md5Encrypt.md5(signStr.toString());
			if (sign.equals(dto.getSignMsg())) {
				flag = true;
			}else {
				if (logger.isInfoEnabled()) {
					logger.info("加密校验失败");
					logger.info("收到加密字符串:"+dto.getSignMsg());
					logger.info("实际加密字符串"+sign);
				}
			}
			logStr.append(" flag:=").append(flag);
		} catch (Exception ex) {
			logger.error(logStr.toString() + ex);
			throw new Exception(ex.getMessage());
		} finally {
			if (logger.isInfoEnabled())
				logger.info(logStr.toString());
		}
		return flag;
	}

	/**
	 * @Title: URLParamsDecode @Creater: chencc <br> @Date: 2013-7-19
	 * <br> @Description: TODO[打赏支付]支付返回!获得转码对象 @param @param dto @param @param
	 * charSet @param @return @param @throws Exception @return
	 * DsPayReturnDto @throws
	 */
	public static PayReturnDto URLParamsDecode(PayReturnDto dto, String charSet) throws Exception {

		StringBuffer logStr = new StringBuffer("[打赏支付]支付返回!获得转码对象!");
		try {
			if (charSet == null || charSet.trim().equals("")) {
				charSet = "utf-8";
			}

			logStr.append(" orderId:=").append(dto.getDealId());
			if (null != dto.getErrCode()) {
				dto.setErrCode(URLDecoder.decode(dto.getErrCode(), charSet));
				logStr.append(" errCode:=").append(dto.getErrCode());
			}
			if (null != dto.getExt1()) {
				dto.setExt1(URLDecoder.decode(dto.getExt1(), charSet));
				logStr.append(" ext1:=").append(dto.getExt1());
			}
			if (null != dto.getExt2()) {
				dto.setExt2(URLDecoder.decode(dto.getExt2(), charSet));
				logStr.append(" ext2:=").append(dto.getExt2());
			}
		} catch (Exception ex) {
			logger.error(logStr.toString() + ex);
			throw new Exception(ex.getMessage());
		} finally {
			if (logger.isInfoEnabled())
				logger.info(logStr.toString());
		}

		return dto;
	}

}
