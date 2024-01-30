package c02oop.javabase;

import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

public class HexFormatDemo {
    public static void main(String[] args) throws InterruptedException {
        byte[] data = "Hello".getBytes(StandardCharsets.UTF_8);
        HexFormat hf0 = HexFormat.of();
        String hexStr0 = hf0.formatHex(data);
        System.out.println(hexStr0); // 48656c6c6f

        // 分隔符为空格，添加前缀0x，大写字母:
        HexFormat hf1 = HexFormat.ofDelimiter(" ").withPrefix("0x").withUpperCase();
        String hexStr1 = hf1.formatHex(data);
        System.out.println(hexStr1); // 0x48 0x65 0x6C 0x6C 0x6F

        // 从十六进制字符串到byte[]数组转换，使用parseHex()方法：
        byte[] bs = HexFormat.of().parseHex(hexStr0);
        System.out.println(new String(bs)); // Hello
    }
}
