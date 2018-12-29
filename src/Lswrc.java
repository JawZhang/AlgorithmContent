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
//				for (int j = 0; j < s2.length() && !s3.equals(s2.substring(s2.length())); j++) {
//					if(s2.substring(j,j+1).equals(s3) && !"".equals(s2.substring(j))){
//						s2 = s2.substring(j+1) + s3;
//						continue;
//					}
//					} else if(s2.substring(j).equals(s3)){
//						s2 = s3;
//					}
				findstr(s2,s3);

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

	public String findstr(String s,String c){
		for (int j = 0; j < s.length() && !c.equals(s.substring(s.length())); j++) {
			if (s.substring(j, j + 1).equals(c) && !"".equals(s.substring(j))) {
				s = s.substring(j + 1) + c;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		String str = "anivaf";
		int result;
		Lswrc ls = new Lswrc();
		result = ls.lengthOfLongestSubstring(str);
		System.out.print(result);
	}
}
