import java.util.Arrays;

public class BSTNode {
	public BSTNode left, right;
	public int value;

	public BSTNode(int n) {
		value = n;
	}

	public static int[] slice(int[] arr, int begin, int end) {
		if (begin < 0 || begin > arr.length || end < 0 || end > arr.length 
			|| begin >= end) {
			return null;
		}
		int[] result = new int[end - begin];
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (i >= begin && i < end) {
				result[j] = arr[i];
				j++;
			}
		}
		return result;
	}

	public static BSTNode makeBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		} else if (nums.length == 1) {
			return new BSTNode(nums[0]);
		}
		int mid = nums.length / 2;
		BSTNode result = new BSTNode(nums[mid]);
		result.left = makeBST(slice(nums, 0, mid));
		result.right = makeBST(slice(nums, mid + 1, nums.length));
		return result;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		BSTNode t = BSTNode.makeBST(arr);
		System.out.println(t.value);
		System.out.println(t.left.value);
		System.out.println(t.left.left.value);
		System.out.println(t.left.right.value);
		System.out.println(t.right.value);
		System.out.println(t.right.left.value);
		System.out.println(t.right.right.value);
	}
}