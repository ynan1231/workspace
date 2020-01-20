package cn.tiayan.pay;

import org.junit.Test;

import cn.tianya.pay.PayOrderQueryHandle;
import cn.tianya.pay.PayReturnDataHandle;
import cn.tianya.pay.PayReturnDto;

public class CallBackTest {
	public final static String NOTBLANK_DATE_FORMAT = "yyyyMMddHHmmss";
	public final static String PAYINTERFACE_PAYRESULT_SUCCESS = "10";
	public final static String PAYINTERFACE_PAYRESULT_FAIL = "11";
	public final static String PAYINTERFACE_RETURN_SUCCESS = "success";
	public final static String PAYINTERFACE_RETURN_FAIL = "false";

	private PayReturnDto getPayReturnDto() {
		PayReturnDto dto = new PayReturnDto();
		dto.setVersionId("1.0");
		dto.setInvokeType("1");
		dto.setMerId("test");
		dto.setSignType("1");
		dto.setMerOrder("test2019080617002535");
		dto.setCurrency("TYT");
		dto.setPayAmount("110");
		dto.setDealId("20190806170128Sf8k1p");
		dto.setDealTime("20190806170711");
		dto.setChannel("56");
		dto.setNotify("");
		dto.setPayResult("pay");

		dto.setErrCode("");
		dto.setExt1("ext1");
		dto.setExt2("ext2");

		dto.setSignMsg("");

		return dto;
	}
	/**
	 * 回写结果成功:success,失败:false
	 * @throws Exception
	 */
	@Test
	public void payCallBack() throws Exception {
		StringBuffer logStr = new StringBuffer("支付返回!");
		PayReturnDto dto = null;

		dto = getPayReturnDto();
		logStr.append(" orderId:=").append(dto.getMerOrder()).append(" dealId:=").append(dto.getDealId());
		dto = PayReturnDataHandle.URLParamsDecode(dto, "utf-8");

		System.out.println(dto);
		if (PayReturnDataHandle.checkReturnParams(dto)) {// 签名校验通过
			String queRet = PayOrderQueryHandle.queryPayOrderStatus(dto.getMerOrder());
			if (queRet.equals(dto.getPayResult())) {// 回调支付接口查询订单状态，确保不被伪造
				if (dto.getPayResult().equals(PAYINTERFACE_PAYRESULT_SUCCESS)) {// 支付成功
					System.out.println("支付成功");
				} else {
					System.out.println("支付失败");
				}
				/** 实际业务处理 */
				if (true) {
					System.out.println(PAYINTERFACE_RETURN_SUCCESS);
				} else {
					System.out.println(PAYINTERFACE_RETURN_FAIL);
				}
			} else {
				System.out.println(PAYINTERFACE_RETURN_FAIL);
			}
		} else {
			System.out.println(PAYINTERFACE_RETURN_FAIL);
		}
	}
}
