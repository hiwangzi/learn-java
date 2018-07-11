package zzhthread;

public class Bank {
	// 假设一个账户有1000块钱
	Integer money = 1000;

	// ATM取钱的方法
	public void ATMQ(int money, String name) {// 参数是每次取走的钱

		this.money -= money;// 取钱后总数减少
		System.out.println(name + "取走了" + money + "还剩下" + (this.money));

	}

	// ATM 存钱的方法
	public void ATMC(int money, String name) {

		this.money += money;
		System.out.println("父亲存了" + money + "还剩下" + (this.money));

	}
}
