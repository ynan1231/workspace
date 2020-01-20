package cn.yn.test.test;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AliPay {
	
	public static void main(String[] args) throws AlipayApiException {
		String content = "app_id=2019121669922701&biz_content={\"total_amount\":\"10.00\",\"body\":\"天涯贝充值商户\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"subject\":\"天涯贝充值商户\",\"out_trade_no\":\"222020011318590991ZXX0\"}&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http://pay.tianya.cn/pay/aliSDKBack.backend.do&sign_type=RSA2&timestamp=2020-01-14 09:53:38&version=1.0";
		String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCArPKeSS4G//vS+GkZnkR4rRxaRTUIdqvWw+GnhgW9spYxqdrKit/e3L7nHLn0dYL/hgLA8/Dj/w1s866q/zZeaHebSz5nZJ6DEOomk1yAAfEvk3LA5UCyQmoT7cvrV7phMUZcdEL1NZAJ84hMmR9zDTthvyNrCLOdw3m57k4vSkcrVUYP3m+3oUEs+9ixJoN4wYL/xcn3nVgE6L7iJLSff/ndifuimJy1HN4AlN7NKx7ObpE0KhHTPZFEQnbiZo2hGbDzFvSo8mf8+7zOZokkNpH3qm8hBR6cexGHMHZ4OZGhxkMnek9osD3X/3upkHYHTJxJyUG1dus65knr4IfBAgMBAAECggEAQiIhVC8CZACe2fBofA023dsDDnYxapcrfGcSjDo6qyOlRAMrexvjMbS8vSWrgTQATvn+YlM+BMBqkwuvQx2GQQFqL7t9aEBzo6NG5OqqCPR2lGAxA2kQVk4CHRoDy4I8PYXIxu3OGB8eV67953hvjH9JfNRzDKjdQAFeh6wuLOk7Dng5/cZaIBrUOfBRmEul+ADJcYIiK+lyxcSjORq/I+8f09xRipqeMTnHWIIdvTf5hStRsD/SHDPZH8XGtoUHe9a+yQJCOCB5U3vpsSUOZg/Z/Uwr7iCXrTfdYM/IK0BsjMkJhVmzJZurkbmOYpeMiu7APzs64WzqGEkmTMCIPQKBgQDw8aRz3OElPp0vAfqLYp9VpfH1Dy6rJoacsJmnQLP3pn84Qw7d8V0Vpn2pQCdJVZKkuM/UfxCr05WM87FVjTxGWRdm6VMjFPOZ96EOQsOXhqlWA31Ertk2mzKOFoTWYuEmnI13HbM80Qp/uvWeWXEncybVWkaIXrBRebY+35pDEwKBgQCIt1vsK1dHZhOM2nX6MW6uakdJJ7P/CiePqBGFxpc7UH7LHIsUwzieQw5wdv+RaebvvkGS9l/EQc81f7wm008QUS5EanKZtKApqGDWMhWa4VYta8P3/EmMf8kizClJ099De3CM4IGn0kb/DBLim/dGeSBZYLaMpPYbH/3apnCQWwKBgQCORJBvHWgPntYfEJMIxHYCk5a3tXw/8OKhGKHRoSHiw/vwk5/uqvrksscWLdxEr/ODseB9v31vh+KRNL9sHZYOj8KCsJi3aUKhkhcWHZPyH8BTGoJYEMoPNTp3rZJIKGB7dQsO34mbCm+hlho7ouJugc7XQZPOJ+MCaNSUcWFb4wKBgH6jadBvrR8D3KQiUBn65A1HgNSwpDhgDZkyE1kZRUi6HVjDDcmjs7RVZPCkKcNml3YHg/I/qSG/29IwifZk0d3JdNQGzjS2bY1o3JpMNlsK06qrIhF5bh9o1sUW3D/4s9xsYSr9YtwzGXRymKOz2O88j8x6m13YB+fEUH7SoX31AoGBAKnZLIZF/KX/dUmxkaNBSCzd8YX7S9m0BsOCkgp7l/ODOubbDcsNpX6QJc/G+ZQ04HYfgFJDoMUvGjEbg2HfL/IMwKc7Y2J2c50IfvcrYE2yIcfgy+yerJpBZWDMFIR5bH2Mt3qsjnOZGOorgRSBIFQyKLwwf6JYTgKfF+AS38q6";
		String charset = "utf-8";
		String sign;
		
		sign = AlipaySignature.rsa256Sign(content, privateKey, charset);
		System.out.println(sign);
		
		
//		content = "body=天涯贝充值商户&buyer_email=130****1731&buyer_id=2088222747107332&discount=0.00&gmt_create=2020-01-13 14:11:21&is_total_fee_adjust=Y&notify_id=2020011300222141121007331417309692&notify_time=2020-01-13 14:11:21&notify_type=trade_status_sync&out_trade_no=202001131411160jlQVh&payment_type=1&price=1.00&quantity=1&seller_email=pay@staff.tianya.cn&seller_id=2088101178820134&subject=天涯贝充值商户&total_fee=1.00&trade_no=2020011322001307331408983482&trade_status=WAIT_BUYER_PAY&use_coupon=N";
//		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
//		sign = "JJXfSTtoWeSR5ALpkl4Z7yeq7U5tlVh85MrrpETgg/pQJX4nfhxnaX6k4cNA5WLrTcveafm3qVA47+KwcagnYtw4QENuhbyFvjGt1p1epCEHGtpcqKERKVLsgHa/F6+6rLa61W+PrND8TAW0wuc1yAk5h0frdioel6dyV1Vh+MY=";
//		
//		boolean isCheck = AlipaySignature.rsaCheckContent(content, sign, publicKey, charset);
//		
//		
//		content = "body=天涯贝充值商户&buyer_email=130****1731&buyer_id=2088222747107332&discount=0.00&gmt_create=2020-01-13 14:11:21&is_total_fee_adjust=Y&notify_id=2020011300222141121007331417309692&notify_time=2020-01-13 14:11:21&notify_type=trade_status_sync&out_trade_no=202001131411160jlQVh&payment_type=1&price=1.00&quantity=1&seller_email=pay@staff.tianya.cn&seller_id=2088101178820134&subject=天涯贝充值商户&total_fee=1.00&trade_no=2020011322001307331408983482&trade_status=WAIT_BUYER_PAY&use_coupon=N";
//		publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
//		sign = "JJXfSTtoWeSR5ALpkl4Z7yeq7U5tlVh85MrrpETgg/pQJX4nfhxnaX6k4cNA5WLrTcveafm3qVA47+KwcagnYtw4QENuhbyFvjGt1p1epCEHGtpcqKERKVLsgHa/F6+6rLa61W+PrND8TAW0wuc1yAk5h0frdioel6dyV1Vh+MY=";
//		
//		isCheck = AlipaySignature.rsa256CheckContent(content, sign, publicKey, charset);
		
//		System.out.println(isCheck);
		
		
		request();
		
	}
	
	public static void request() {
		String appId = "2088021531075657";
		String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCArPKeSS4G//vS+GkZnkR4rRxaRTUIdqvWw+GnhgW9spYxqdrKit/e3L7nHLn0dYL/hgLA8/Dj/w1s866q/zZeaHebSz5nZJ6DEOomk1yAAfEvk3LA5UCyQmoT7cvrV7phMUZcdEL1NZAJ84hMmR9zDTthvyNrCLOdw3m57k4vSkcrVUYP3m+3oUEs+9ixJoN4wYL/xcn3nVgE6L7iJLSff/ndifuimJy1HN4AlN7NKx7ObpE0KhHTPZFEQnbiZo2hGbDzFvSo8mf8+7zOZokkNpH3qm8hBR6cexGHMHZ4OZGhxkMnek9osD3X/3upkHYHTJxJyUG1dus65knr4IfBAgMBAAECggEAQiIhVC8CZACe2fBofA023dsDDnYxapcrfGcSjDo6qyOlRAMrexvjMbS8vSWrgTQATvn+YlM+BMBqkwuvQx2GQQFqL7t9aEBzo6NG5OqqCPR2lGAxA2kQVk4CHRoDy4I8PYXIxu3OGB8eV67953hvjH9JfNRzDKjdQAFeh6wuLOk7Dng5/cZaIBrUOfBRmEul+ADJcYIiK+lyxcSjORq/I+8f09xRipqeMTnHWIIdvTf5hStRsD/SHDPZH8XGtoUHe9a+yQJCOCB5U3vpsSUOZg/Z/Uwr7iCXrTfdYM/IK0BsjMkJhVmzJZurkbmOYpeMiu7APzs64WzqGEkmTMCIPQKBgQDw8aRz3OElPp0vAfqLYp9VpfH1Dy6rJoacsJmnQLP3pn84Qw7d8V0Vpn2pQCdJVZKkuM/UfxCr05WM87FVjTxGWRdm6VMjFPOZ96EOQsOXhqlWA31Ertk2mzKOFoTWYuEmnI13HbM80Qp/uvWeWXEncybVWkaIXrBRebY+35pDEwKBgQCIt1vsK1dHZhOM2nX6MW6uakdJJ7P/CiePqBGFxpc7UH7LHIsUwzieQw5wdv+RaebvvkGS9l/EQc81f7wm008QUS5EanKZtKApqGDWMhWa4VYta8P3/EmMf8kizClJ099De3CM4IGn0kb/DBLim/dGeSBZYLaMpPYbH/3apnCQWwKBgQCORJBvHWgPntYfEJMIxHYCk5a3tXw/8OKhGKHRoSHiw/vwk5/uqvrksscWLdxEr/ODseB9v31vh+KRNL9sHZYOj8KCsJi3aUKhkhcWHZPyH8BTGoJYEMoPNTp3rZJIKGB7dQsO34mbCm+hlho7ouJugc7XQZPOJ+MCaNSUcWFb4wKBgH6jadBvrR8D3KQiUBn65A1HgNSwpDhgDZkyE1kZRUi6HVjDDcmjs7RVZPCkKcNml3YHg/I/qSG/29IwifZk0d3JdNQGzjS2bY1o3JpMNlsK06qrIhF5bh9o1sUW3D/4s9xsYSr9YtwzGXRymKOz2O88j8x6m13YB+fEUH7SoX31AoGBAKnZLIZF/KX/dUmxkaNBSCzd8YX7S9m0BsOCkgp7l/ODOubbDcsNpX6QJc/G+ZQ04HYfgFJDoMUvGjEbg2HfL/IMwKc7Y2J2c50IfvcrYE2yIcfgy+yerJpBZWDMFIR5bH2Mt3qsjnOZGOorgRSBIFQyKLwwf6JYTgKfF+AS38q6";
		String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnHVLQkYg8qVMr4Agf56Xn4YfIwOFQ0oWnzl4L3093w00LwDZ4igVuGoFdU5CbWfbeac4Mx899J9MfKUbvPkY1E6+43J37er83avWJbJFoAfHb8UCgIV0f3kxuRhWK+Nko/7Jt328amWgeCmYsZiycjl2DZ8sWLwp1UXdPjIbX+E4vRO6XTpteHGtCp0psQLRKrP6oYYMg4UXWgKOhUyETKEQTdBjolK0jVUKCyMcdnhIg+qNWvYgMS2K2ig3xDuBey+hsgyzfWMcjKGJSXg2tqCrzKnGFJtY/M4WfiFU4pc7VOoCQpPOLVaSPbyHXG3ZCiL5D1NZoeLSbXuUN/goawIDAQAB";
		String CHARSET = "utf-8";		
		
		//实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", appId, privateKey, "json", CHARSET, publicKey, "RSA2");
		//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("天涯贝充值商户");
		model.setSubject("天涯贝充值商户");
		model.setOutTradeNo("2020011318590991ZXX0");
		model.setTimeoutExpress("30m");
		model.setTotalAmount("10.0");
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl("http://pay.tianya.cn/pay/aliSDKBack.backend.do");
		try {
		        //这里和普通的接口调用不同，使用的是sdkExecute
		        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
		        System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		}
	}

}
