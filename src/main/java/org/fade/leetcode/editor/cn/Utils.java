package org.fade.leetcode.editor.cn;

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
                for (int i = 0; i < size && index < split.length; ++i) {
                    TreeNode poll = queue.poll();
                    if (poll != null && !split[i].equals(NULL_STR)) {
                        TreeNode left = new TreeNode(Integer.parseInt(split[i]));
                        poll.left = left;
                        queue.offer(left);
                    }
                    if (poll != null && i + 1 < split.length && !split[i + 1].equals(NULL_STR)) {
                        TreeNode right = new TreeNode(Integer.parseInt(split[i + 1]));
                        poll.right = right;
                        queue.offer(right);
                    }
                }
            }
        }
        return root;
    }

}
