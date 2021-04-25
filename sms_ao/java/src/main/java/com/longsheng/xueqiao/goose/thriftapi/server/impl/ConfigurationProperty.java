package com.longsheng.xueqiao.goose.thriftapi.server.impl;

import java.util.Properties;

public class ConfigurationProperty {

	private int smsType;

	private static ConfigurationProperty config;

	private ConfigurationProperty() {

	}

	public static ConfigurationProperty instance() {

		if (config == null) {
			synchronized (ConfigurationProperty.class) {
				if (config == null) {
					config = new ConfigurationProperty();
				}

			}
		}
		return config;
	}

	public void init(Properties props) {
		String type = props.getProperty("sms_type", "0");
		setSmsType(Integer.parseInt(type));
	}

	public int getSmsType() {
		return smsType;
	}

	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}
}
