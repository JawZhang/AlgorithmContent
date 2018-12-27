import java.util.Arrays;

/**
 * Created by Honghao on 2018/8/9.
 */
public class TowSum {

	public int[] TowSum(int[] nums, int target ){

		int[] temp = {0,0};                                //array of initialization

		for (int i = 0; i < nums.length-1; i++) {          //one loop of external start with first element
			for (int j = nums.length - 1; j > i; j--) {    //internal loop of loop start with last element
				int a = nums[i];
				int b = nums[j];
				if (a + b == target) {
					temp[temp[0]] = i;
					temp[temp.length-1] = j;
				}
			}
		}
		return temp;
	}

	public static void main(String[] args){
		int[] numss = {2,5,6,7,4};
		int t = 11;
		TowSum sumc = new TowSum();
		int[] sum = sumc.TowSum(numss, t);
		System.out.println(Arrays.toString(sum));
	}
}
