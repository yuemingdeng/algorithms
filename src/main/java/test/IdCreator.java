package test;


import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 获取主键:返回17位时间戳+3位递增数(同一时间递增)
 */
public class IdCreator {
    private static int addPart = 1;
    private static String result = "";
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static String lastDate = "";
    /**
     * 获取主键
     * @param length 长度
     * @return 返回17位时间戳+3位递增数
     */
    public synchronized static String getId(int length) {
        //获取时间部分字符串
        Date now = new Date();
        String nowStr = sdf.format(now);

        //获取数字后缀值部分
        if (IdCreator.lastDate.equals(nowStr)) {
            addPart += 1;
        } else {
            addPart = 1;
            lastDate = nowStr;
        }

        if (length > 17) {
            length -= 17;
            for (int i = 0; i < length - ((addPart + "").length()); i++) {
                nowStr += "0";
            }
            nowStr += addPart;
            result = nowStr;
        } else {
            result = nowStr;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(IdCreator.getId(20));
    }
}
