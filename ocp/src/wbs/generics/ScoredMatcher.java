package wbs.generics;

public interface ScoredMatcher<T1, T2> {
	
	public int getMatching(T1 t1, T2 t2); 
}
