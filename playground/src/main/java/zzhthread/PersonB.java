package zzhthread;

public class PersonB extends Thread {
	// 创建银行对象
	Bank bank;
	String name;

	// 通过构造器传入银行对象，确保两个人进入的是一个银行
	public PersonB(Bank bank, String name) {
		this.bank = bank;
		this.name = name;
	}

	// 重写run方法，在里面实现使用柜台取钱
	@Override
	public void run() {
		while (true) {
			synchronized (bank) {
				while (bank.money <= 300){
					bank.ATMC(1000, name);// 每次存1000块
					bank.notifyAll();
				}
			}
			try {
				sleep(15000);// 存完休息30秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
