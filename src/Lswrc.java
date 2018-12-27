/**
 * Created by Honghao on 2018/12/25.
 */
public class Lswrc {
	public int lengthOfLongestSubstring(String s) {

		int max = 0;
		String s2 = "";
		if (s.length()!=0) {
			max = 1;
		}
		for (int i=0;i<=s.length()-1;i++) {
			String s3 = s.substring(i,i+1);
			if (s2.contains(s3)) {
//				if(s2.substring(0, 1).equals(s3) && s2.length() > 1) {
//					s2 = s2.substring(1) + s3;
//				} else {
//					s2 = s3;
//				}
				for (int j = 0; j <= s2.length() && !s3.equals(s2.substring(s2.length())); j++) {
					if(!s2.substring(j).contains(s3) && !"".equals(s2.substring(j))){
						s2 = s2.substring(j) + s3;
					} else if(s2.substring(j).equals(s3)){
						s2 = s3;
					}
				}
				continue;
			} else {
				s2 += s3;
			}
			if(s2.length() >= max) {
				if (s.length() == 2 && s.charAt(0) != s.charAt(1)) {
					max = s.length();
				} else {
					max = s2.length();
				}
			}
		}
		return max;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "anivaf";
		int result;
		Lswrc ls = new Lswrc();
		result = ls.lengthOfLongestSubstring(str);
		System.out.print(result);
	}
}
