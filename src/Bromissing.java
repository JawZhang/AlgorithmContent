import java.util.ArrayList;

/**
 * Created by Honghao on 2018/8/18.
 */
public class Bromissing {
	public int firstMissingPositive(int[] nums) {

		if (nums.length == 0)

			return 1;

		int[] arr1 = new int[nums.length];
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++)

			arr1[i] = i + 1;

		int possibleLargest = arr1[nums.length - 1];
		int[] arr2 = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] < possibleLargest + 1) {
				arr2[nums[i] - 1] = nums[i];
			}
		}

		for (int k = 0; k < nums.length; k++) {
			list.add(arr1[k] - arr2[k]);
		}

		int sum = 0;

		for (int index = 0; index < list.size(); index++)

			sum = sum + list.get(index);

		if (sum == 0)

			return nums.length + 1;

		else {
			int p = 0;
			while (p < nums.length && list.get(p) == 0) {
				p++;
			}
			return list.get(p);
		}
	}

	public static void main(String[] args) {
		Bromissing bm = new Bromissing();
		int[] numes = new int[]{-1, -3, 1, 4, 5, 2, 2, 9, 3, 10, 6, 6,};
		long start = System.currentTimeMillis();
		int b = bm.firstMissingPositive(numes);
		System.out.print(b);
		System.out.println("Bromissing: "
				+ (System.currentTimeMillis() - start) + "ms");

	}
}
