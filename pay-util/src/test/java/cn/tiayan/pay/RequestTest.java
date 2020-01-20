package cn.tiayan.pay;

import java.util.Date;

import org.junit.Test;

import cn.tianya.pay.PayDataHandle;
import cn.tianya.pay.PayMerchantDto;
import cn.tianya.pay.PayRequestDto;
import cn.tianya.util.DateUtil;

public class RequestTest {
	@Test
	public  void getRequestURL() throws Exception {
		PayRequestDto dto = new PayRequestDto();
		//商家需设置字段
		dto.setMerOrder("test123545434354353443");
		dto.setMerPrdName("会员一个月");
		dto.setMerAmount("10");			
		dto.setMerDate(DateUtil.convertDateToStr(new Date(), "yyyyMMddHHmmss"));
		
		//common.properties配置
		PayMerchantDto merchantDto = PayMerchantDto.getInstance();
		dto.setMerBackurl(merchantDto.getBgUrl());//回调地址
		dto.setMerId(merchantDto.getMerchantId());	//商家ID 需申请
		dto.setKey(merchantDto.getMerchantKey());	//商家秘钥
		dto.setPayReqUrl(merchantDto.getPayReqUrl()); //请求地址
		
		//固定字段
		dto.setSignType("1");//MD5
		dto.setEncode("utf-8");
		dto.setVersionId("1.0");
		dto.setInvokeType("1");//默认值 前台调用
		dto.setCurrency("TYT");//
		dto.setPayType("57");
		String requestUrl = PayDataHandle.payRequestUrl(dto);
		
		System.out.println(requestUrl);
		
	}
	
	
	@Test
	public  void getRequestURL2() throws Exception {
		PayRequestDto dto = new PayRequestDto();
		//商家需设置字段
		dto.setMerOrder("test12332256554353443");
		dto.setMerPrdName("会员一个月");
		dto.setMerAmount("10");			
		dto.setMerDate(DateUtil.convertDateToStr(new Date(), "yyyyMMddHHmmss"));
		
		//common.properties配置
		PayMerchantDto merchantDto = PayMerchantDto.getInstance();
		dto.setMerBackurl(merchantDto.getBgUrl());//回调地址
		dto.setMerId(merchantDto.getMerchantId());	//商家ID 需申请
		dto.setKey(merchantDto.getMerchantKey());	//商家秘钥
		dto.setPayReqUrl(merchantDto.getPayReqUrl()); //请求地址
		
		//固定字段
		dto.setSignType("1");//MD5
		dto.setEncode("utf-8");
		dto.setVersionId("1.0");
		dto.setInvokeType("3");// 前台调用
		dto.setCurrency("RMB");//
		dto.setPayType("00");
		dto.setRemark("开通1个月会员，2019-03-28到期.");
		String requestUrl = PayDataHandle.payRequestUrl(dto);
		
		System.out.println(requestUrl);
		
	}
}
