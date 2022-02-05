package src.cn.AlgorithmAccumulation.day01_1;

public class PlaceChange {
    public static void main(String[] args) {
        String s="BBBBBGGGGBBBBBBGG";
        int change = placeChange(s);
        System.out.println(change);
    }

    /**
     * 1.一个数组中只有两个字符'G'和'B'，可以让所有的G放在左边，所有的B放在右边，或者让所有的B放在左边，G放在右边
     *  只能在相邻字符再之间进行交换操作，至少需要交换多少次？
     * 2.Thinking:可以采用贪心，假设所有的G在左边，那么第一个G的坐标必然为0，设gi作为G的下标，step1记录交换的次数
     * 交换的次数在于遍历的当前下标减去G的下标，相减之后必须将G下标后移，即gi++;
     * @param s
     * @return
     */
    public static int placeChange(String s){
        if (s==null||s.equals("")){
            return 0;
        }
        int step1=0;
        int gi=0;
        int step2=0;
        int bi=0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i]=='G'){
                step1+=i-(gi++);
            }else{
                step2+=i-(bi++);
            }
        }


        return Math.min(step1,step2);
    }
}
