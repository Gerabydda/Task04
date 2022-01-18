package com.company;
import java.util.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Stack;
public class Main {
    public static void processor(int n, int k, String s) {
        String[] strArr = s.split("\\s");
        int len = 0;
        for(String s1 : strArr){
            if(len+s1.length() <= k){
                if(len!=0){
                    System.out.print(' ' + s1);
                }
                else{
                    System.out.print(s1);
                }
                len+=s1.length();

            }
            else{
                System.out.print('\n'+s1);
                len=s1.length();
            }
        }
    }
    public static void split(String s) {
        ArrayList<String> arrLS = new ArrayList<>();
        String s1 = "";
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            s1+=ch;
            if(ch=='('){
                stack.push(ch);
            }
            else{
                stack.pop();
            }
            if(stack.isEmpty()){
                arrLS.add(s1);
                s1="";
            }
        }

        System.out.println(arrLS);

    }
    public static String toCamelCase(String s) {
        String s1 = "";
        Boolean nextUp = false;
        for(char ch : s.toCharArray()){
            if(ch=='_'){
                nextUp = true;
            }
            else{
                if(nextUp){
                    s1+=Character.toUpperCase(ch);
                }
                else{
                    s1+=ch;
                }
                nextUp=false;
            }
        }
        return s1;
    }

    public static String toSnakeCase (String s) {
        String s1 = "";
        for(char ch : s.toCharArray()){
            if(Character.isUpperCase(ch)){
                s1+='_';
                s1+=Character.toLowerCase(ch);
            }
            else{
                s1+=ch;
            }
        }
        return s1;
    }
    public static String overTime(double[] arr) {
        double cash = 0;
        for(double i=arr[0]; i<arr[1]; i=(int)i+1){
            if(i<17){
                cash+=((int)(i+1)-i)*arr[2];
            }
            else{
                cash+=((int)(i+1)-i)*arr[2]*arr[3];
            }
        }

        return "$"+String.format("%.2f",cash);
    }
    public static String BMI(String s1, String s2) {
        String[] arrS1 = s1.split(" ");
        String[] arrS2 = s2.split(" ");
        double weight = Double.valueOf(arrS1[0]);
        if(arrS1[1].equals("pounds")){
            weight /= 2.20462;
        }

        double growth = Double.valueOf(arrS2[0]);
        if(arrS2[1].equals("inches")){
            growth /= 39.37;
        }

        double index = weight/(growth*growth);

        if(index < 18.5){
            return String.format("%.1f Underweight", index);
        }
        else if(index < 24.9){
            return String.format("%.1f Normal weight", index);
        }

        return String.format("%.1f Overweight", index);
    }
    public static int bugger(int num) {
        String s;
        int counter = 0;
        while(num>9){
            s = Integer.toString(num);
            num = 1;
            for(char ch : s.toCharArray()){
                num*=Integer.parseInt(String.valueOf(ch));
            }
            counter++;
        };
        return counter;
    }
    public static String toStarShorthand(String s) {
        if(s.length()==0) return s;
        String s1="";
        for(int i=0; i<s.length(); i++){
            int counter = 1;
            int j=i+1;
            for(; j<s.length() && s.charAt(j)==s.charAt(i); j++){
                counter++;
                i++;
            }
            s1+=s.charAt(i);
            if(counter!=1){
                s1+="*";
                s1+=Integer.toString(counter);
            }
        }
        return s1;
    }
    public static Boolean doesRhyme(String s1, String s2) {
        s1 = s1.replaceAll("[^aeiouAEIOU ]", "").toLowerCase();
        s2 = s2.replaceAll("[^aeiouAEIOU ]", "").toLowerCase();
        String[] sArr1 = s1.split(" ");
        String[] sArr2 = s2.split(" ");
        return sArr1[sArr1.length-1].equals(sArr2[sArr2.length-1]);
    }
    public static Boolean trouble(long n1, long n2) {
        String s1 = Long.toString(n1);
        String s2 = Long.toString(n2);
        HashSet<Long> hs1 = new HashSet<>();
        HashSet<Long> hs2 = new HashSet<>();
        for(int i=0; i<s1.length(); i++){
            int counter = 1;
            int j=i+1;
            for(; j<s1.length(); j++){
                if(s1.charAt(i) == s1.charAt(j)){
                    counter++;
                    i++;
                }
            }
            if(counter>2){
                hs1.add(Long.parseLong(String.valueOf(s1.charAt(i))));
            }
        }
        for(int i=0; i<s2.length(); i++){
            int counter = 1;
            int j=i+1;
            for(; j<s2.length(); j++){
                if(s2.charAt(i) == s2.charAt(j)){
                    counter++;
                    i++;
                }
            }
            if(counter>1){
                hs2.add(Long.parseLong(String.valueOf(s2.charAt(i))));
            }
        }
        HashSet<Long> result = new HashSet<>(hs1);
        result.retainAll(hs2);
        return result.size()>0;
    }
    public static int countUniqueBooks(String s, char ch) {
        int first = -1;
        int end = -1;
        for(int i=0; i<s.length() ; i++){
            if(s.charAt(i) == ch){
                if(s.charAt(i) == ch){
                    if(first==-1){
                        first = i;
                    }
                    end = i;
                }
            }
        }
        if(first==end || first == end-1) return 0;
        HashSet<Character> result = new HashSet<>();

        for(char chS : s.substring(first+1,end-1).toCharArray()){
            if(ch!=chS) result.add(chS);
        }
        return result.size();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of func (1-10): "); // выбор нужной функции чтобы не запускать сразу все
        int i = in.nextInt();
        if (i==1) {
            processor(10,7,  "hello my name is Bessie and this is my essay");
        }
        if (i==2) {
            split("()()()");
            split("((()))");
            split("((()))(())()()(()())");
            split("((())())(()(()()))");

        }
        if (i==3) {
            System.out.println(toCamelCase("hello_edabit"));
            System.out.println(toSnakeCase("helloEdabit"));
            System.out.println(toCamelCase("is_modal_open"));
            System.out.println(toSnakeCase("getColor"));
        }
        if (i==4) {
            System.out.println(overTime(new double[]{9, 17, 30, 1.5}));
            System.out.println(overTime(new double[]{16, 18, 30, 1.8}));
            System.out.println(overTime(new double[]{13.25, 15, 30, 1.5}));
        }
        if (i==5) {
            System.out.println(BMI("205 pounds", "73 inches"));
            System.out.println(BMI("55 kilos", "1.65 meters"));
            System.out.println(BMI("154 pounds", "2 meters"));
        }
        if (i==6) {
            System.out.println(bugger(39));
            System.out.println(bugger(999));
            System.out.println(bugger(4));
        }
        if (i==7) {
            System.out.println(toStarShorthand("abbccc"));
            System.out.println(toStarShorthand("77777geff"));
            System.out.println(toStarShorthand("abc"));
            System.out.println(toStarShorthand(""));
        }
        if (i==8) {
            System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
            System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
            System.out.println(doesRhyme("You are off to the races", "a splendid day."));
            System.out.println(doesRhyme("and frequently do?", "you gotta move."));
        }
        if (i==9) {
            System.out.println(trouble(451999277, 417772899));
            System.out.println(trouble(1222345, 12345));
            System.out.println(trouble(666789, 12345667));
        }
        if (i==10) {
            System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
            System.out.println(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
            System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
        }
    }
}
