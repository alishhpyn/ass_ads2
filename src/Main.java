
class Main{
    public static void main(String[] args){
        LinkedList list  = new LinkedList();
        LinkedList list1 = new LinkedList();
        list1.insert(12);
        list1.insert(18);
        list1.insert(15);
        list1.insert(14);
        list.insert(5);
        list.insert(7);
        list.insert(12);
        list.insertAtStart(55);
        list.insertAtStart(31);
        list.insertAt(0,9);
        list.removeTheLastElement();
        list.removeByValue(9);
        list.combineLists(list,list1);
        list.reverse();
        list.show();



    }
}

import java.util.*;

// ================= TREE NODE =================

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

// ================= MAIN CLASS =================

public class Main {

    // =====================================================
    // TASK 1 - TWO SUM
    // =====================================================

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int need = target - nums[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    // =====================================================
    // TASK 2 - FIRST UNIQUE CHARACTER
    // =====================================================

    public static int firstUnique(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // =====================================================
    // TASK 3 - ISOMORPHIC STRINGS
    // =====================================================

    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map1.containsKey(c1)) {

                if (map1.get(c1) != c2) {
                    return false;
                }

            } else {

                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {

                if (map2.get(c2) != c1) {
                    return false;
                }

            } else {

                map2.put(c2, c1);
            }
        }

        return true;
    }

    // =====================================================
    // TASK 4 - HAPPY NUMBER
    // =====================================================

    public static boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {

            set.add(n);

            int sum = 0;

            while (n > 0) {

                int digit = n % 10;

                sum += digit * digit;

                n /= 10;
            }

            n = sum;
        }

        return n == 1;
    }

    // =====================================================
    // TASK 5 - LEVEL ORDER TRAVERSAL
    // =====================================================

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                level.add(current.val);

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    // =====================================================
    // TASK 6 - MAXIMUM DEPTH
    // =====================================================

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    // =====================================================
    // TASK 7 - SYMMETRIC TREE
    // =====================================================

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return mirror(root.left, root.right);
    }

    public static boolean mirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return t1.val == t2.val
                && mirror(t1.left, t2.right)
                && mirror(t1.right, t2.left);
    }

    // =====================================================
    // TASK 8 - LONGEST CONSECUTIVE SEQUENCE
    // =====================================================

    static int max = 0;

    public static int longestConsecutive(TreeNode root) {

        dfs(root, null, 0);

        return max;
    }

    public static void dfs(TreeNode node, TreeNode parent, int length) {

        if (node == null) {
            return;
        }

        if (parent != null && node.val == parent.val + 1) {
            length++;
        } else {
            length = 1;
        }

        max = Math.max(max, length);

        dfs(node.left, node, length);

        dfs(node.right, node, length);
    }

    // =====================================================
    // TASK 9 - SORT COLORS
    // =====================================================

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                swap(nums, low, mid);

                low++;
                mid++;

            } else if (nums[mid] == 1) {

                mid++;

            } else {

                swap(nums, mid, high);

                high--;
            }
        }
    }

    // =====================================================
    // TASK 10 - QUICK SORT
    // =====================================================

    public static void quickSort(int[] nums, int low, int high) {

        if (low < high) {

            int pivot = partition(nums, low, high);

            quickSort(nums, low, pivot - 1);

            quickSort(nums, pivot + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {

        int pivot = nums[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (nums[j] < pivot) {

                i++;

                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);

        return i + 1;
    }

    // =====================================================
    // TASK 11 - MERGE SORT
    // =====================================================

    public static void mergeSort(int[] nums, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(nums, left, mid);

            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] < nums[j]) {

                temp[k++] = nums[i++];

            } else {

                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }

    // =====================================================
    // TASK 12 - HEAP SORT
    // =====================================================

    public static void heapSort(int[] nums) {

        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            swap(nums, 0, i);

            heapify(nums, i, 0);
        }
    }

    public static void heapify(int[] nums, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;

        int right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {

            swap(nums, i, largest);

            heapify(nums, n, largest);
        }
    }

    // =====================================================
    // SWAP METHOD
    // =====================================================

    public static void swap(int[] nums, int a, int b) {

        int temp = nums[a];

        nums[a] = nums[b];

        nums[b] = temp;
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        // TASK 1
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]);

        // TASK 2
        System.out.println(firstUnique("loveleetcode"));

        // TASK 3
        System.out.println(isIsomorphic("egg", "add"));

        // TASK 4
        System.out.println(isHappy(19));

        // TASK 9
        int[] colors = {2, 0, 2, 1, 1, 0};

        sortColors(colors);

        System.out.println(Arrays.toString(colors));

        // TASK 10
        int[] quick = {5, 2, 9, 1, 7};

        quickSort(quick, 0, quick.length - 1);

        System.out.println(Arrays.toString(quick));

        // TASK 11
        int[] merge = {8, 3, 1, 6, 2};

        mergeSort(merge, 0, merge.length - 1);

        System.out.println(Arrays.toString(merge));

        // TASK 12
        int[] heap = {4, 10, 3, 5, 1};

        heapSort(heap);

        System.out.println(Arrays.toString(heap));
    }
}
