package wbs.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

public class ReadMetaInfDemo {

	public static void main(String[] args) throws IOException {
		Enumeration<URL> resources = ReadMetaInfDemo.class.getClassLoader()
				.getResources("META-INF/services/java.sql.Driver");
		URL url;
		InputStream is;
		BufferedReader br;
		String line;
		while (resources.hasMoreElements()) {
			url = resources.nextElement();
			System.out.println("url: " + url);
			is = url.openStream();
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				System.out.println(" " + line);
			}
			br.close();
		}
	}
}
