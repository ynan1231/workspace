package cn.tianya.pay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @FileName: DsPayMerchantDto.java <br>
 * @Creater: chencc <br>
 * @version V1.0 <br>
 * @Description: <br>
 */
public class PayMerchantDto {

	private static Logger logger = LoggerFactory.getLogger(PayMerchantDto.class);

	private String merchantId;
	private String merchantKey;
	private String payReqUrl;
	private String bgUrl = "";
	private String queryUrl;

	private static PayMerchantDto payMerchantDto = new PayMerchantDto();

	public static PayMerchantDto getInstance() {
		return payMerchantDto;
	}

	private PayMerchantDto() {
		StringBuffer loggerStr = new StringBuffer("dsPayMerchant init！");
		try {
			PayConfiguration config = PayConfiguration.getInstance();
			this.merchantId = config.getValue("merchantAcctId_tianya").trim();
			this.merchantKey = config.getValue("key_tianya").trim();
			this.payReqUrl = config.getValue("payReqUrl_tianya").trim();
			this.bgUrl = config.getValue("bgUrl_tianya").trim();
			this.queryUrl = config.getValue("queryUrl_tianya").trim();

			loggerStr.append(" merId：").append(merchantId).append(" notifyUrl：").append(bgUrl).append(" payReqUrl：")
					.append(payReqUrl).append(" queryUrl：").append(queryUrl);
		} catch (Exception ex) {
			logger.error(loggerStr.toString() + ex);
		} finally {
			if (logger.isDebugEnabled())
				logger.debug(loggerStr.toString());
		}
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getMerchantKey() {
		return merchantKey;
	}

	public String getPayReqUrl() {
		return payReqUrl;
	}

	public String getBgUrl() {
		return bgUrl;
	}

	public String getQueryUrl() {
		return queryUrl;
	}

}
