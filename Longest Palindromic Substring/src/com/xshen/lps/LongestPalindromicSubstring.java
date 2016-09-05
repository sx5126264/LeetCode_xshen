package com.xshen.lps;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String res = s.longestPalindrome("aaaaaaaaaaaaa");
		System.out.println(res);
	}

}

class Solution {
    public String longestPalindrome(String s) {
        
    	//使奇偶情况相同
        StringBuffer res = new StringBuffer();
        StringBuffer newstr = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
        	newstr.append("#");
        	newstr.append(s.charAt(i));
        }
        newstr.append("#");
        
        int id = 0;//最大回文边界的回文串中心点
        int max = 0;//最大回文边界的回文串半径
        int maxi = 0;//最大回文长度的回文串中心点
        int maxl = 0;//最大回文长度的回文串中心点
        int p[] = new int[newstr.length()];//每个字符最大回文半径
        
        for(int i = 0; i < newstr.length(); i++){
        	if(id + max > i){
        		//当前点在回文串对称域内，回文半径初始化为最大对称长度
        		p[i] = max + id > p[2*id-i] + i ? p[2*id-i] : max + id - i;
        	}
        	else{
        		p[i] = 0;
        	}
        	
        	//左右扩展回文串
        	while(i - p[i] - 1 >= 0 && i + p[i] + 1 < newstr.length() 
        			&& newstr.charAt(i+p[i]+1) == newstr.charAt(i-p[i]-1)){
        		  p[i]++;  		
        	}
        	
        	//更新参数
        	if(i + p[i] > max + id){
        		id = i;
        		max = p[i];
        	}
        	if(maxl <= p[i]){
        		maxl = p[i];
        		maxi = i;
        	}
        }
        
        for(int i = maxi - maxl; i <= maxi + maxl; i += 2){
        	if(newstr.charAt(i) == '#'){
        		i++;
        	}
        	res.append(newstr.charAt(i));
        }
      
        return res.toString();
        
    }
}
