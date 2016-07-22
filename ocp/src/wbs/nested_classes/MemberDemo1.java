package wbs.nested_classes;

public class MemberDemo1 {

	int n;
	static int sn;

	void m1() {
	}

	public class Inner1 {
		void m1() {
			n = 3;
			sn = 4;
			MemberDemo1.this.m1();
		}
	}

	public static void main(String[] args) {
		MemberDemo1 demo1 = new MemberDemo1();
		demo1.new Inner1();
		new MemberDemo1().new Inner1();
	}

}
