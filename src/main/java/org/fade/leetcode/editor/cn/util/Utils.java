package org.fade.leetcode.editor.cn.util;

import org.fade.leetcode.editor.cn.TreeNode;
import org.fade.leetcode.editor.cn.graph.Node;
import org.fade.leetcode.editor.cn.list.ListNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 *
 * @author fade
 * @date 2023/03/04
 */
public class Utils {

    public static final Pattern INT_PATTERN = Pattern.compile("\\[[-\\d,]*]");

    public static final Pattern CHAR_PATTERN = Pattern.compile("\\[.*?]");

    private static final String NULL_STR = "null";

    public static int[] parseToArrayFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        String[] split = substring.split(",");
        int[] ans = new int[split.length];
        for (int i = 0; i < split.length; ++i) {
            ans[i] = Integer.parseInt(split[i]);
        }
        return ans;
    }

    public static String[] parseToStringArrayFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        String[] split = substring.split("(?<=\") *, *(?=\")");
        return Arrays.stream(split).map(x -> x.substring(1, x.length() - 1)).toArray(String[]::new);
    }

    public static char[] parseToCharArrayFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        String[] split = substring.split("(?<=\") *, *(?=\")");
        int length = split.length;
        char[] ans = new char[length];
        for (int i = 0; i < length; ++i) {
            ans[i] = split[i].charAt(1);
        }
        return ans;
    }

    public static void invokeMethodOnSpecificObj(Object obj, String methodName, Object[] params, Class<?>[] paramTypes) {
        Class<?> objClass = obj.getClass();
        Method method;
        try {
            method = objClass.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            Object invoke = method.invoke(obj, params);
            if (invoke != null) {
                System.out.println(invoke);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] parseToIntArrayArrayFromString(String param) {
        List<List<Integer>> lists = parseToListListFromString(param, Integer::parseInt, INT_PATTERN);
        return lists.stream().map(x -> x.stream().mapToInt(Integer::intValue)
                .toArray()).toArray(int[][]::new);
    }

    public static char[][] parseToCharArrayArrayFromString(String param) {
        List<List<Character>> lists = parseToListListFromString(param, x -> x.charAt(1), CHAR_PATTERN);
        char[][] ans = new char[lists.size()][];
        for (int i = 0; i < lists.size(); ++i) {
            List<Character> characters = lists.get(i);
            ans[i] = new char[characters.size()];
            for (int j = 0; j < characters.size(); ++j) {
                ans[i][j] = characters.get(j);
            }
        }
        return ans;
    }

    public static <T> List<T> parseToListFromString(String param, Function<String, T> function) {
        String substring = param.substring(1, param.length() - 1);
        return Arrays.stream(substring.split(","))
                .map(function)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static <T> List<List<T>> parseToListListFromString(String param, Function<String, T> function, Pattern pattern) {
        String substring = param.substring(1, param.length() - 1);
        Matcher matcher = pattern.matcher(substring);
        List<List<T>> ans = new ArrayList<>(8);
        while (matcher.find()) {
            ans.add(parseToListFromString(matcher.group(), function));
        }
        return ans;
    }

    public static TreeNode parseToTreeNodeFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        String[] split = substring.split(",");
        TreeNode root = null;
        if (split.length >= 1 && !split[0].equals(NULL_STR)) {
            root = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode poll = queue.poll();
                    if (poll != null && index < split.length && !split[index].equals(NULL_STR)) {
                        TreeNode left = new TreeNode(Integer.parseInt(split[index++]));
                        poll.left = left;
                        queue.offer(left);
                    }
                    if (poll != null && index < split.length && !split[index].equals(NULL_STR)) {
                        TreeNode right = new TreeNode(Integer.parseInt(split[index++]));
                        poll.right = right;
                        queue.offer(right);
                    }
                }
            }
        }
        return root;
    }

    public static Node parseToGraphNodeFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        Matcher matcher = INT_PATTERN.matcher(substring);
        Node ans = null;
        Map<Integer, Node> map = new HashMap<>(8);
        if (matcher.find()) {
            ans = new Node(1);
            map.put(1, ans);
            List<Node> neighbors = new ArrayList<>();
            for (int num: parseToListFromString(matcher.group(), Integer::parseInt)) {
                Node node = new Node(num);
                neighbors.add(node);
                map.put(num, node);
            }
            ans.neighbors = neighbors;
        }
        int val = 2;
        while (matcher.find()) {
            Node cur;
            if (map.containsKey(val)) {
                cur = map.get(val);
            } else {
                cur = new Node(val);
            }
            List<Node> neighbors = new ArrayList<>();
            for (int num: parseToListFromString(matcher.group(), Integer::parseInt)) {
                if (map.containsKey(num)) {
                    neighbors.add(map.get(num));
                } else {
                    Node node = new Node(num);
                    neighbors.add(node);
                    map.put(num, node);
                }
            }
            cur.neighbors = neighbors;
            ++val;
        }
        return ans;
    }

    public static ListNode parseToListNodeFromString(String param) {
        int[] ints = parseToArrayFromString(param);
        ListNode head = null;
        if (ints.length > 0) {
            head = new ListNode(ints[0]);
            ListNode p = head;
            for (int i = 1; i < ints.length; ++i) {
                p.next = new ListNode(ints[i]);
                p = p.next;
            }
        }
        return head;
    }

    public static ListNode parseToListNodeWithCircleFromString(String param, int pos) {
        ListNode head = parseToListNodeFromString(param);
        if (pos != -1) {
            ListNode p = head, q;
            for (int i = 0; i < pos; ++i) {
                p = p.next;
            }
            q = p;
            while (p.next != null) {
                p = p.next;
            }
            p.next = q;
        }
        return head;
    }

}
