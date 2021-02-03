package cn.jsledd.stack;

import java.util.*;

/**
 * @version 1.0
 * @ClassName : ReversePolishNotation
 * @Description : 逆波兰表达式
 * @Author : JSLEDD
 * @Date: 2016-02-02 13:15
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String notationStr = "21 -10+(1-2)* 31 +4";
        List<String> l = new ArrayList<>();
        l.add("1+2");
        l.add("1+(2-3)");
        l.add("1+(2-3)*4");
        l.add("1* -1 +(2+-3)");
        l.add("(4 + (13 / 5))");
        l.add("((10 * (6 / ((9 + 3) * -11))) + 17) + 5");
        for (String ss : l) {
            ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
            String[] s = reversePolishNotation.convertInfixToSuffix(ss);
            int i = reversePolishNotation.evalRPN(s);
            System.out.println(i);
        }

    }

    /**
     * @param notationStr 字符串表达式
     * @return java.lang.String[]
     * @throws
     * @description 将字符串表达式放入数组
     * @author JSLEDD
     * @date 2016/6/12 14:24
     */
    public String[] notationStrToArray(String notationStr) {
        List<String> list = new ArrayList();
        notationStr = notationStr.replaceAll(" ", "");
        char[] chars = notationStr.toCharArray();
        int keepNum = 0;
        int preflag = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (preflag == 0 && c == 45) {
                System.out.println("负数");
                keepNum++;
            } else if (isSymbol(c) && c != 32) {

                if (keepNum > 0) {
                    String trim = notationStr.substring(i - keepNum, i).trim();
                    if (!trim.isEmpty()) list.add(trim);
                    keepNum = 0;
                }
                preflag = 0;
                list.add(c + "");
            } else {
                preflag = 1;
                keepNum++;
            }
        }
        if (keepNum > 0) {
            list.add(notationStr.substring(notationStr.length() - keepNum, notationStr.length()).trim());
        }
        System.out.println(list);
        return list.toArray(new String[list.size()]);
    }

    /**
     * @param tokens 后缀表达式（逆波兰表达式）
     * @return int
     * @throws
     * @description 后缀表达式计算
     * @author JSLEDD
     * @date 2016/6/12 9:24
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> resStack = new Stack<Integer>();//记录运算符
        for (String token : tokens) {
            if (token.matches("^-?\\d+$")) {// 判断是不是数字，如果是直接存入结果集
                resStack.push(Integer.parseInt(token));
            } else {
                int ev2 = resStack.pop();
                int ev1 = resStack.pop();
                int evre = 0;
                switch (token) {
                    case "+":
                        evre = ev1 + ev2;
                        break;
                    case "-":
                        evre = ev1 - ev2;
                        break; //可选
                    case "*":
                        evre = ev1 * ev2;
                        break; //可选
                    case "/":
                        evre = ev1 / ev2;
                        break; //可选
                    //你可以有任意数量的case语句
                    default: //可选
                        //语句
                }
                resStack.push(evre);
            }
        }
        return resStack.pop();
    }

    /**
     * @param tokens 后缀表达式（逆波兰表达式）
     * @return int
     * @throws
     * @description
     * @author JSLEDD
     * @date 2016/6/12 14:05
     */
    public int evalRPN1(String[] tokens) {
        Stack<Integer> resStack = new Stack<Integer>();//记录运算符
        for (String token : tokens) {
            int ev1, ev2 = 0;
            switch (token) {
                case "+":
                    ev2 = resStack.pop();
                    ev1 = resStack.pop();
                    resStack.push(ev1 + ev2);
                    break;
                case "-":
                    ev2 = resStack.pop();
                    ev1 = resStack.pop();
                    resStack.push(ev1 - ev2);
                    break;
                case "*":
                    ev2 = resStack.pop();
                    ev1 = resStack.pop();
                    resStack.push(ev1 * ev2);
                    break;
                case "/":
                    ev2 = resStack.pop();
                    ev1 = resStack.pop();
                    resStack.push(ev1 / ev2);
                    break;
                //你可以有任意数量的case语句
                default:
                    resStack.push(Integer.parseInt(token));
                    break;
            }
        }
        return resStack.pop();
    }
    /**
     *
     * @param tokens 后缀表达式（逆波兰表达式）
     * @description
     * @author JSLEDD
     * @date 2016/6/12 14:58
     * @return int
     * @throws
     */
    public int evalRPNArray(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    numStack[index - 2] += numStack[--index];
                    break;
                case "-":
                    numStack[index - 2] -= numStack[--index];
                    break;
                case "*":
                    numStack[index - 2] *= numStack[--index];
                    break;
                case "/":
                    numStack[index - 2] /= numStack[--index];
                    break;
                default:
                    // numStack[index++] = Integer.valueOf(s);
                    //valueOf改为parseInt，减少自动拆箱装箱操作
                    numStack[index++] = Integer.parseInt(s);
                    break;
            }
        }
        return numStack[0];
    }

    /**
     * @param infixNotation 中缀表达式
     * @return java.lang.String[]
     * @throws
     * @description 中缀表达式转后缀表达式（逆波兰表达式）
     * @author JSLEDD
     * @date 2016/6/12 13:44
     */
    public String[] convertInfixToSuffix(String infixNotation) {
        String[] strings = notationStrToArray(infixNotation);
        Stack<String> symbolStack = new Stack<String>();//记录运算符
        List<String> list = new ArrayList();//记录转换后的结果
        for (String str : strings) {
            if (str.matches("^-?\\d+$")) {// 判断是不是数字，如果是直接存入结果集
                list.add(str);
            } else if (str.equals("(")) { //判断是不是左括弧,是直接压入栈
                symbolStack.push(str);
            } else if (str.equals(")")) { //判断是不是右括弧,找到对应的左括弧
                while (!symbolStack.peek().equals("(")) {
                    list.add(symbolStack.pop());
                }
                symbolStack.pop();
            } else {
                //str的优先级小于等于symbolStack栈顶运算符, 将symbolStack栈顶的运算符弹出并加入到sb中，再次往下判断直到结束
                while (!symbolStack.isEmpty()) {
                    String peek = symbolStack.peek();
                    if ("(".equals(peek)) {
                        break;
                    } else if (comparPriority(str, peek) < 0) {
                        list.add(symbolStack.pop());
                    } else {
                        break;
                    }
                }
                symbolStack.push(str);
            }
        }
        //将符号栈中的符号依次输入结果集
        while (!symbolStack.isEmpty()) {
            list.add(symbolStack.pop());
        }
        return list.toArray(new String[list.size()]);
    }


    /**
     * @param thissymbol  当前运算符
     * @param othersymbol 比较的运算符
     * @return int 1：优先级高；0：优先级相等，-1：优先级低
     * @throws
     * @description 运算符比较优先级
     * @author JSLEDD
     * @date 2016/6/12 13:29
     */
    public int comparPriority(String thissymbol, String othersymbol) {
        int re = 0, thislevel = 0, otherlevel = 0;
        if ("*".equals(thissymbol) || "/".equals(thissymbol)) {
            thislevel = 1;
        } else if ("+".equals(thissymbol) || "-".equals(thissymbol)) {
            thislevel = 0;
        } else {
            throw new RuntimeException("运算符有误");
        }
        if ("*".equals(othersymbol) || "/".equals(othersymbol)) {
            otherlevel = 1;
        } else if ("+".equals(othersymbol) || "-".equals(othersymbol)) {
            otherlevel = 0;
        } else {
            throw new RuntimeException("运算符有误");
        }
        return thislevel - otherlevel;
    }

    /**
     * @param val 数据
     * @return boolean
     * @throws
     * @description 判断是不是运算符
     * @author JSLEDD
     * @date 2016/6/12 14:03
     */
    public boolean isSymbol(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/' || val == '(' || val == ')';
    }
}
