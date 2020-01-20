package cn.tianya.pay;

import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @FileName: DsPayDataHandle.java <br>
 * @Creater: chencc <br>
 * @Date: 2013-7-19 <br>
 * @version V1.0 <br>
 * @Description: <br>
 */
public class PayDataHandle {

	private static Logger logger = LoggerFactory.getLogger(PayDataHandle.class);

	public static String payRequestUrl(PayRequestDto dto) throws Exception {
		StringBuffer requestUrl = new StringBuffer();
		StringBuffer logStr = new StringBuffer("[支付]支付地址组织!");
		try {
			logStr.append(" orderId:=").append(dto.getMerOrder());
			String signMsg = payRequestSign(dto);
			logStr.append(" signMsg:=").append(signMsg);

			dto = URLParamsEncode(dto, "utf-8");
			requestUrl.append(dto.getPayReqUrl());
			if (dto.getPayReqUrl().indexOf("?") > 0)
				requestUrl.append("&");
			else
				requestUrl.append("?");

			// http://tianyapayHost?versionId=..&invokeType=..&merId=..&merOrder=..&merPrdName=..&currency=..&merAmount=..
			// &merDate=..&payType=..&paySubType=..&accountNo=..&accountPwd=..&signType=..&merBackurl=..&encode=..&remark=..&ext1=..&ext2=..&signMsg=..

			requestUrl.append("versionId=").append(dto.getVersionId()).append("&invokeType=")
					.append(dto.getInvokeType()).append("&merId=").append(dto.getMerId()).append("&merOrder=")
					.append(dto.getMerOrder()).append("&merPrdName=").append(dto.getMerPrdName()).append("&currency=")
					.append(dto.getCurrency()).append("&merAmount=").append(dto.getMerAmount()).append("&merDate=")
					.append(dto.getMerDate()).append("&payType=").append(dto.getPayType());

			if (null != dto.getPaySubType() && !"".equals(dto.getPaySubType()))
				requestUrl.append("&paySubType=").append(dto.getPaySubType());

			if (null != dto.getAccountNo() && !"".equals(dto.getAccountNo()) && null != dto.getAccountPwd()
					&& !"".equals(dto.getAccountPwd()))
				requestUrl.append("&accountNo=").append(dto.getAccountNo()).append("&accountPwd=")
						.append(dto.getAccountPwd());

			requestUrl.append("&signType=").append(dto.getSignType()).append("&merBackurl=").append(dto.getMerBackurl())
					.append("&encode=").append(dto.getEncode());

			if (null != dto.getUserId() && !"".equals(dto.getUserId()))
				requestUrl.append("&userId=").append(dto.getUserId());
			if (null != dto.getUserName() && !"".equals(dto.getUserName()))
				requestUrl.append("&userName=").append(dto.getUserName());

			if (null != dto.getRemark())
				requestUrl.append("&remark=").append(dto.getRemark());
			if (null != dto.getExt1())
				requestUrl.append("&ext1=").append(dto.getExt1());
			if (null != dto.getExt2())
				requestUrl.append("&ext2=").append(dto.getExt2());
			if (null != dto.getSubMerId())
				requestUrl.append("&subMerId=").append(dto.getSubMerId());
			requestUrl.append("&signMsg=").append(signMsg);

			logStr.append(" requestUrl:=").append(requestUrl.toString());
		} catch (Exception ex) {
			logger.error(logStr.toString() + ex);
			throw new Exception(ex.getMessage());
		} finally {
			if (logger.isInfoEnabled())
				logger.info(logStr.toString());
		}
		return requestUrl.toString();
	}

	private static String payRequestSign(PayRequestDto dto) throws Exception {
		String signMsg = "";
		StringBuffer logStr = new StringBuffer("[支付]支付地址组织-签名串!");
		try {
			// 需要签名的字段和顺序如下：
			// versionId=..&invokeType=..&merId=..&merOrder=..&merPrdName=..&currency=..&merAmount=..&merDate=..&payType=..&signType=..&key=..
			StringBuffer str = new StringBuffer();
			str.append("versionId=").append(dto.getVersionId()).append("&invokeType=").append(dto.getInvokeType())
					.append("&merId=").append(dto.getMerId()).append("&merOrder=").append(dto.getMerOrder())
					.append("&merPrdName=").append(dto.getMerPrdName()).append("&currency=").append(dto.getCurrency())
					.append("&merAmount=").append(dto.getMerAmount()).append("&merDate=").append(dto.getMerDate())
					.append("&payType=").append(dto.getPayType()).append("&signType=").append(dto.getSignType())
					.append("&key=").append(dto.getKey());

			logStr.append(" orderId:=").append(dto.getMerOrder()).append(" signStr:=").append(str.toString());
			signMsg = Md5Encrypt.md5(str.toString());
			logStr.append(" signMsg:=").append(signMsg);
		} catch (Exception ex) {
			logger.error(logStr.toString(),ex);
			throw new Exception(ex.getMessage());
		} finally {
			if (logger.isInfoEnabled())
				logger.info(logStr.toString());
		}
		return signMsg;
	}

	/**
	 * @Title: URLParamsEncode @Creater: chencc <br> @Date: 2013-7-19
	 * <br> @Description: TODO请求地址生成获得转码对象 @param @param dto @param @param
	 * charSet @param @return @param @throws Exception @return
	 * DsPayRequestDto @throws
	 */
	private static PayRequestDto URLParamsEncode(PayRequestDto dto, String charSet) throws Exception {

		try {
			if (charSet == null || charSet.trim().equals("")) {
				charSet = "utf-8";
			}

			dto.setMerPrdName(URLEncoder.encode(dto.getMerPrdName(), charSet));
			dto.setMerBackurl(URLEncoder.encode(dto.getMerBackurl(), charSet));

			if (null != dto.getUserName()) {
				dto.setUserName(URLEncoder.encode(dto.getUserName(), charSet));
			}
			if (null != dto.getRemark()) {
				dto.setRemark(URLEncoder.encode(dto.getRemark(), charSet));
			}
			if (null != dto.getExt1()) {
				dto.setExt1(URLEncoder.encode(dto.getExt1(), charSet));
			}
			if (null != dto.getExt2()) {
				dto.setExt2(URLEncoder.encode(dto.getExt2(), charSet));
			}
		} catch (Exception ex) {
			logger.error("请求地址生成获得转码对象异常！", ex);
			throw new Exception(ex.getMessage());
		}

		return dto;
	}
}
