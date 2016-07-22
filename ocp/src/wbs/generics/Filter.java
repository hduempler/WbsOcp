package wbs.generics;

public interface Filter<T> {
	public boolean accept(T t);
}
