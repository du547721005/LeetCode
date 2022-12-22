package src.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author bxdu
 * @Date 2022年12月21日 23:43
 **/
public class 有效的括号20 {
    /**
     * easy
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号
     */
    public boolean isValid(String s) {
        int len = s.length();
        //括号数不是偶数直接返回false
        if(len % 2 != 0){
            return false;
        }
        //利用栈做，后出现的左括号，先被匹配掉。
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < len; i++){
            //先入栈左括号
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                //出现右括号时，栈为空或者栈顶元素不是对应的右括号直接返回false
                if(stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                //栈顶元素出栈。
                stack.pop();
            }else{
                //入栈左括号
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
