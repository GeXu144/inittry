package src.cn.AlgorithmAccumulation.datastruct;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//简化路径
public class Solution71 {
    /**
     * 算法思想：
     *      根据题意，使用栈进行模拟即可。
     *
     * 具体的，从前往后处理 path，每次以 item 为单位进行处理（有效的文件名），根据 item 为何值进行分情况讨论：
     *
     * item 为有效值 ：存入栈中；
     * item 为 .. ：弹出栈顶元素（若存在）；
     * item 为 . ：不作处理。
     *     }
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        List<String> list = Arrays.asList("",".","..");
        Deque<String> deque = new ArrayDeque<>();
        for (String s : path.split("/")) {
            if (!list.contains(s)){
                deque.add(s);
            }else if (!deque.isEmpty() && s.equals("..")){
                deque.pollLast();
            }
        }
        return "/" + String.join("/", deque);
    }
}
