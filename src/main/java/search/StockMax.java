package search;


/** title : 股票的最大盈利值
 * 题目描述：给定一个整形数组，其中的第i个元素代表股票第i天的价格。在一开始，你手里有足够的钱，但没有股票。
 * 你仅有一次买股票和一次卖股票的机会（每次只能买/卖1股），或者不买不卖。输出你可能的最大盈利值。
 * 尽量降低程序的时间复杂度。
 */
public class StockMax {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        int[] array1 = {7, 6, 5, 4, 3, 2};
        System.out.println(maxProfit(array));
        System.out.println(maxProfit(array1));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int minNum = prices[0];
//        int index = 0;
        int earn = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minNum) {
                minNum = prices[i];
//                index = i;
            }
            int temp = prices[i] - minNum;
            if (temp > earn)
                earn = temp;
        }
        return earn;
    }
}

