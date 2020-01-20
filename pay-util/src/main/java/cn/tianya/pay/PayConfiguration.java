package cn.tianya.pay;

import java.util.ResourceBundle;

/**
 * @FileName: DsPayConfiguration.java <br>
 * @Creater: chencc <br>
 * @Date: 2013-7-19 <br>
 * @version V1.0   
 * <br>
 * @Description: <br>
 */
public class PayConfiguration {

	private static Object lock = new Object();
	private static PayConfiguration config = null;
	private static ResourceBundle rb = null;
	private static final String CONFIG_FILE = "common";

	private PayConfiguration() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
	}

	public static PayConfiguration getInstance() {
		synchronized (lock) {
			if (null == config) {
				config = new PayConfiguration();
			}
		}
		return (config);
	}

	public String getValue(String key) {
		try {
			return (rb.getString(key));
		} catch (Exception e) {
		}
		return "";
	}
}
