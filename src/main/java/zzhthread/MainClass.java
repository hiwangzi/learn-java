package zzhthread;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 实力化一个银行对象
		Bank bank = new Bank();
		// 实例化两个人，传入同一个银行的对象
		PersonA pA1 = new PersonA(bank, "儿子1");
		PersonA pA2 = new PersonA(bank, "儿子2");
		PersonA pA3 = new PersonA(bank, "儿子3");
		PersonB pB = new PersonB(bank, "父亲");
		// 两个人开始取钱

		pB.start();
		pA1.start();
		pA2.start();
		pA3.start();

	}

}
