package wbs.nio.attributes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.attribute.UserPrincipalNotFoundException;

public class UserPrincipalDemo {
	public static void main(String[] args) throws IOException {
		// String s = "src/wbs/nio/attributes/UserPrincipalDemo.java";
		String s = "C:/info.txt";
		Path path = Paths.get(s);
		System.out.println(Files.exists(path));
		UserPrincipalLookupService lookupService = FileSystems.getDefault()
				.getUserPrincipalLookupService();
		UserPrincipal userPrincipal = lookupService
				.lookupPrincipalByName("Master");
		System.out.println(userPrincipal);
		userPrincipal = Files.getOwner(path);
		System.out.println(userPrincipal);
		try {
			Files.setOwner(path, lookupService.lookupPrincipalByName("Master"));
		} catch (UserPrincipalNotFoundException e) {
			System.out.println(e);
		}
	}
}