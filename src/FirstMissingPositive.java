import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Honghao on 2018/8/14.
 */
public class FirstMissingPositive {

	public int[] firstMissingPositive(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			int temp;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[i] > nums[j]) {
					temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
		return nums;
	}

	public int findMissingEle(int[] nums) {

		int tarnum = 1;
		Arrays.sort(nums);                                        //srcArray sort
		TreeSet numsSet = new TreeSet();
		for (int j : nums) {
			if (j > 0) {
				numsSet.add(j);
			}
		}
		//if (numsSet.contains(1)) {                              //submit
		int[] num = new int[numsSet.size()];
		Iterator it = numsSet.iterator();
		for (int i = 0; i < nums.length && it.hasNext(); i++) {
			num[i] = (int) it.next();                             //remove the same elements
		}
		ArrayList arrayList = new ArrayList();
		if (num[0] == 1) {
			for (int i = 0; i < num.length - 1; i++) {
				if (num[i] + 1 != num[i + 1]) {                  //determine if the array is continuous
					arrayList.add(num[i] + 1);                   //insert missing elements to new array list
				}
			}
			int size = arrayList.size();
			if (size == 0) {                                      //if array is continuous
				tarnum = nums[nums.length - 1] + 1;                //return value of last element add 1
			} else {
				Integer[] numf = (Integer[]) arrayList.toArray(new Integer[size]);
				tarnum = numf[0];                                //return new array list of first elememt
			}
		}
		return tarnum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numes = new int[]{-1, -3, 4, 1, 7, 5, 2, 2, 9, 3, 10, 6, 6,};

		FirstMissingPositive so = new FirstMissingPositive();
		int solu = so.findMissingEle(numes);
		System.out.println(solu);
	}
}
