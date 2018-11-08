package main;

import java.util.*;

public class Main {

    //9.回文数
    public boolean isPalindrome(int x) {
        String string = Integer.toString(x);
        int left = 0,right = string.length()-1;
        while(left < right){
            if(string.charAt(left) == string.charAt(right)){
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }

    //27.移除元素
    public int removeElement(int[] nums, int val) {
        int left = 0,right = nums.length-1;
        while(left < right){
            if(nums[left] != val){
                left++;
                continue;
            }
            if(nums[right] == val){
                right--;
                continue;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        return left;
    }

    //58最后一个单词的长度
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                break;
            }
            count++;
        }
        return count;
    }

    //88.合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m,j=0;j<nums2.length;i++,j++){
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1,0,m+n);
    }

    //169.求众数
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                int newValue = map.get(num);
                newValue++;
                map.replace(num,newValue);
                continue;
            }
            map.put(num,1);
        }
        int max = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }

    //202.快乐数
    public boolean isHappy(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(n);
        while(true){
            int sum = 0;
            while(n>0){
                int rem = n%10;
                sum += rem*rem;
                n /= 10;
            }
            if(sum == 1){
                return true;
            }
            if(list.contains(sum)){
                return false;
            }
            list.add(sum);
            n = sum;
        }
    }

    //237.删除链表中的结点
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //242.有效的字母异位词
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        if(ch1.length != ch2.length){
            return false;
        }
        for(int i=0;i<ch1.length;i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }
        return true;
    }

    //258.各位相加
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        int sum = 0;
        while(num >0){
            sum += (num%10);
            num /= 10;
        }
        return addDigits(sum);
    }

    //268.缺失数字
    public int missingNumber(int[] nums) {
        int tmp[] = new int[nums.length+1];
        for (int i=0;i<tmp.length;i++) {
            tmp[i] = -1;
        }
        for (int num : nums) {
            tmp[num] = num;
        }
        for(int i=0;i<tmp.length;i++){
            if(tmp[i]  == -1){
                return i;
            }
        }
        return 0;
    }

    //283.移动零
    public void moveZeroes(int[] nums) {
        int pos1 = 0,pos2 = 0;
        while(pos1 < nums.length && pos2 < nums.length){
            if(nums[pos1] != 0){
                pos1++;
                continue;
            }
            if(nums[pos2] == 0){
                pos2++;
                continue;
            }
            int tmp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = tmp;
        }
    }

    //326.3的幂
    public boolean isPowerOfThree(int n) {
        while(n>0){
            if(n%3 != 0){
                return false;
            }
            n /= 3;
            if(n == 1){
                return true;
            }
        }
        return false;
    }

    //344.反转字符串
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s,i,i+1);
        }
        return sb.toString();
    }

    //345.反转字符串中的元音字母
    public String reverseVowels(String s) {
        char []ch = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0,right = s.length()-1;
        while(left<right){
            if(! vowels.contains(Character.toString(ch[left]))){
                left++;
                continue;
            }
            if(! vowels.contains(Character.toString(ch[right]))){
                right--;
                continue;
            }
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(char i : ch){
            sb.append(i);
        }
        return sb.toString();
    }

    //389.找不同
    public char findTheDifference(String s, String t) {
        char ch1[] = s.toCharArray();
        char ch2[] = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        char tmp = '0';
        for(int i=0;i<ch1.length;i++){
            if(ch1[i] != ch2[i]){
                tmp = ch2[i];
                break;
            }
        }
        if(tmp == '0'){
            return ch2[ch2.length-1];
        }
        return tmp;
    }

    //461.汉明距离
    public int hammingDistance(int x, int y) {
        int s = x^y;
        String string = Integer.toString(s,2);
        int count = 0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    //476.数字的补数
    public int findComplement(int num) {
         String string = Integer.toString(num,2);
         StringBuilder sb = new StringBuilder();
         for(int i=0;i<string.length();i++){
             if(string.charAt(i) == '1'){
                 sb.append("0");
                 continue;
             }
             sb.append("1");
         }
         return Integer.parseInt(sb.toString());
    }

    //485.最大连续1的个数
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        boolean aaa = true;
        for(int num : nums){
            if(num == 1){
                count++;
                continue;
            }
            max = Math.max(max,count);
            count = 0;
        }
        return Math.max(max,count);
    }

    //520.检测大写字母
    public boolean detectCapitalUse(String word) {
        String upper = word.toUpperCase();
        String lower = word.toLowerCase();
        if(upper.equals(word) || lower.equals(word)){
            return true;
        }
        StringBuilder  sb = new StringBuilder();
        for(int i=1;i<word.length();i++){
            if(word.charAt(i) >= 'A'&& word.charAt(i) <= 'Z'){
                return false;
            }
        }
        return true;
    }

    //557.反转字符串中的单词III
    public String reverseWords(String s) {
        String [] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String string : strings){
            sb.append(this.reverseString(string));
            sb.append("_");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    //693.交替位二进制数
    public boolean hasAlternatingBits(int n) {
        int tmp = n%2;
        while(n >0){
            n /= 2;
            if(tmp == n%2){
                return false;
            }
            tmp = n%2;
        }
        return true;
    }

    //704.二分查找
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left <= right){
            int tmp = (left+right)/2;
            if(nums[tmp] > target){
                right = tmp-1;
                continue;
            }
            if(nums[tmp] < target){
                left = tmp+1;
                continue;
            }
            return tmp;
        }
        return -1;
    }

    //728.自除数
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for(int i=left;i<= right;i++){
            int num = i;
            if(Integer.toString(num).contains("0")){
                continue;
            }
            boolean aaa = true;
            while (num > 0) {
                int tmp = num%10;
                if(i%tmp != 0){
                    aaa = false;
                    break;
                }
                num /= 10;
            }
            if(aaa){
                list.add(i);
            }
        }
        return list;
    }

    //832.翻转图像
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        for(int i=0;i<row;i++){
            int left = 0,right = column-1;
            while(left < right){
                int tmp = (A[i][left]+1)%2;
                A[i][left] = (A[i][right]+1)%2;
                A[i][right] = tmp;
                left++;
                right--;
            }
            if(left == right){
                A[i][left] = (A[i][left]+1)%2;
            }
        }
        return A;
    }

    //852.山脉数组的峰顶索引
    public int peakIndexInMountainArray(int[] A) {
        int left = 0,right = A.length-1;
        int tmp = 0;
        while(true){
            tmp = (left + right)/2;
            if(A[tmp]>A[tmp+1] && A[tmp]>A[tmp-1]){
                break;
            }
            if(A[tmp]<A[tmp+1]){
                left = tmp;
                continue;
            }
            right = tmp;
        }
        return tmp;
    }

    //867.转置矩阵
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int [][] T = new int[column][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                T[j][i] = A[i][j];
            }
        }
        return T;
    }

    //896.单调数列
    public boolean isMonotonic(int[] A) {
        if(A.length <= 2){
            return true;
        }
        boolean positive = false;
        boolean negative = false;
        for(int i=0;i<A.length-1;i++){
            if((A[i]-A[i+1])>0){
                positive = true;
            }
            if((A[i]-A[i+1])<0){
                negative = true;
            }
            if(positive && negative){
                return false;
            }
        }
        return true;
    }

    //917.仅仅反转字母
    public String reverseOnlyLetters(String S) {
        char []chars = S.toCharArray();
        int left = 0,right = chars.length-1;
        while(left <= right){
            if(chars[left]<='A' || (chars[left]>='Z' && chars[left]<='a') || chars[left]>='z'){
                left++;
                continue;
            }
            if(chars[right]<='A' || (chars[right]>='Z' && chars[right]<='a') || chars[right]>='z'){
                right--;
                continue;
            }
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : chars){
            sb.append(Character.toString(ch));
        }
        return sb.toString();
    }

    //922.按奇偶排序数组II
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int odd = 1;
        int even = 0;
        while(odd < len && even < len){
            if(A[odd]%2 == 1){
                odd+=2;
                continue;
            }
            if(A[even]%2 == 0){
                even +=2;
                continue;
            }
            int tmp = A[odd];
            A[odd] = A[even];
            A[even] = tmp;
            odd+=2;
            even+=2;
        }
        return A;
    }

    //929.独特的电子邮件地址
    public int numUniqueEmails(String[] emails) {
        Set<String> set  = new HashSet<>();
        for(String email : emails){
            StringBuilder sb = new StringBuilder();
            String string[] = email.split("@");
            String subString[] = string[0].split("\\+");
            for(int i=0;i<subString[0].length();i++){
                if(string[0].charAt(i) != '.'){
                    sb.append(subString[0], i, i+1);
                }
            }
            sb.append("@");
            sb.append(string[1]);
            set.add(sb.toString());
        }
        return set.size();
    }

    static int pos1 = 0,pos2 = 0;
    public static void main(String [] args){

    }
}
