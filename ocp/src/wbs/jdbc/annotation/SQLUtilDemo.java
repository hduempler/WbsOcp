package wbs.jdbc.annotation;

import java.util.HashMap;
import java.util.Map;

import wbs.jdbc.dao.Buch;

public class SQLUtilDemo {

	public static void main(String[] args) throws Exception {
		
		SQLUtil sqlUtil = new SQLUtil();
				
		Map<String, String> tableMappings = new HashMap<String, String>();
		Map<String, String> typeMappings = new HashMap<String, String>();
		
		String sql;
		
		tableMappings.put("wbs.jdbc.dao.Buch", "Buch");
		
		typeMappings.put("int", "integer");
		typeMappings.put("String", "varchar(255)");
		typeMappings.put("double", "decimal(8,2)");
				
		Buch buch=new Buch();
		buch.setIsbn("wefwefewf");
		buch.setAutor("Autorsfsfsddf");
		buch.setTitel("Titelqwfqw");
		buch.setPreis(20.0);
		
		//sql = sqlUtil.saveObject(buch, tableMappings, typeMappings);
		
		//System.out.println(sql);
	}
}
