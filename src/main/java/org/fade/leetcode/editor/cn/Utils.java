package org.fade.leetcode.editor.cn;

import org.fade.leetcode.editor.cn.graph.Node;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 *
 * @author fade
 * @date 2023/03/04
 */
public class Utils {

    private static final Pattern PATTERN = Pattern.compile("\\[[\\d,]*]");

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

    public static List<Integer> parseToListFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        return Arrays.stream(substring.split(","))
                .mapToInt(Integer::parseInt)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static List<List<Integer>> parseToListListFromString(String param) {
        String substring = param.substring(1, param.length() - 1);
        Matcher matcher = PATTERN.matcher(substring);
        List<List<Integer>> ans = new ArrayList<>(8);
        while (matcher.find()) {
            ans.add(parseToListFromString(matcher.group()));
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
        Matcher matcher = PATTERN.matcher(substring);
        Node ans = null;
        Map<Integer, Node> map = new HashMap<>(8);
        if (matcher.find()) {
            ans = new Node(1);
            map.put(1, ans);
            List<Node> neighbors = new ArrayList<>();
            for (int num: parseToListFromString(matcher.group())) {
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
            for (int num: parseToListFromString(matcher.group())) {
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

}
