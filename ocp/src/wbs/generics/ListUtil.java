package wbs.generics;

import java.util.List;

public class ListUtil {
	public static <T> void copy(List<? extends T> from, List<? super T> to) {
		to.clear();
		for (T t : from) {
			to.add(t);
		}
	}
}