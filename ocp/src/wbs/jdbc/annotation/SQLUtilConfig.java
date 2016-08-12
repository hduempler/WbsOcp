package wbs.jdbc.annotation;

import java.util.HashMap;
import java.util.Map;

public class SQLUtilConfig {
	private String driver;
	private String url;
	private String user;
	private String password;

	private Map<String, String> tableMappings = new HashMap<>();
	private Map<String, String> typeMappings = new HashMap<>();

	public void putTableMapping(String className, String tableName) {
		tableMappings.put(className, tableName);
	}

	public void putTypeMapping(String javaType, String sqlType) {
		typeMappings.put(javaType, sqlType);
	}

	public String getTableMapping(String className) {
		return tableMappings.get(className);
	}

	public String getTypeMapping(String javaType) {
		return typeMappings.get(javaType);
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getTableMappings() {
		return tableMappings;
	}

	public Map<String, String> getTypeMappings() {
		return typeMappings;
	}

	
	

}
