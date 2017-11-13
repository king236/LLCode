package com.learn.housePrice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {
	
	@Value("${spring.datasource.driver-class-name}")
    private String dataDriverName;
	@Value("${spring.datasource.username}")
    private String dataUserName;
	@Value("${spring.datasource.password}")
    private String dataPassword;
	@Value("${spring.datasource.url}")
    private String dataUrl;
	@Value("${mybatis.outputDir}")
	private String outputDir;

	
	public String getDataDriverName() {
		return dataDriverName;
	}
	public void setDataDriverName(String dataDriverName) {
		this.dataDriverName = dataDriverName;
	}
	public String getDataUserName() {
		return dataUserName;
	}
	public void setDataUserName(String dataUserName) {
		this.dataUserName = dataUserName;
	}
	public String getDataPassword() {
		return dataPassword;
	}
	public void setDataPassword(String dataPassword) {
		this.dataPassword = dataPassword;
	}
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public String getOutputDir() {
		return outputDir;
	}
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
}
