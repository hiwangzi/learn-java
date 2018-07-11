package zzhthread;

public class PersonA extends Thread {
    // 创建银行对象
    Bank bank;
    String name;

    // 通过构造器传入银行对象，确保两个人进入的是一个银行
    public PersonA(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    // 重写run方法，在里面实现使用柜台取钱

    @Override
    public void run() {
        while (true) {
            synchronized (bank) {
                if (bank.money <= 200) {
                    try {
                        bank.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    bank.ATMQ(100, name);// 每次取100块
                }
            }
            try {
                sleep(1000);// 取完休息0.1秒
                yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
