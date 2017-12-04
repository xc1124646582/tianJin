package com.joyadata.tjlog.model;

/**
 * 话单日志
 * 
 * @ClassName: SessionLog
 * @Description: SessionLog
 * @author 黄宏强 st8817@163.com
 * @date 2017年11月21日 下午2:22:23
 *
 */
public class SessionLog {
	private String id;
	private String userAccount;// 变长 用户账号 字符型
	private Integer protocolType; // 协议类型 十六进制整形表示
	private String sourceIp;// 变长 源IP IP地址采用点分十进制表示
	private String destinationIp;// 变长 目的IP IP地址采用点分十进制表示
	private Integer sourcePort;// 2 Bytes 源端口 十六进制整形表示
	private Integer destinationPort;// 2 Bytes 目的端口 十六进制整形表示
	private String domainName; // 变长 域名 采用BASE64编码
	private String url;// 变长 URL 采用BASE64编码，建议支持的最大长度不小于256byte
	private String referer;// REFERER 变长 链接源信息 采用BASE64编码，建议支持的最大长度不小于256byte
	private String userAgent;// 变长 UserAgent信息 采用BASE64编码，建议支持的最大长度不小于256byte
	private String cookie;// 变长 Cookie信息 采用BASE64编码，建议支持的最大长度不小于768byte
	private String accessTime;// 4 Bytes 访问时间 采用UTC格式
	private Long timestamps;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(Integer protocolType) {
		this.protocolType = protocolType;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getDestinationIp() {
		return destinationIp;
	}

	public void setDestinationIp(String destinationIp) {
		this.destinationIp = destinationIp;
	}

	public Integer getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(Integer sourcePort) {
		this.sourcePort = sourcePort;
	}

	public Integer getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(Integer destinationPort) {
		this.destinationPort = destinationPort;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(Long timestamps) {
		this.timestamps = timestamps;
	}

}
