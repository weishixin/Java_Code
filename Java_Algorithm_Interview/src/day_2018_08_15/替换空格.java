package day_2018_08_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ìæ»»¿Õ¸ñ {

	public String replaceSpace(StringBuffer str) {
    	String result = "";
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == ' '){
                result+="%20";
            }
            else{
                result+=str.charAt(i);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = {1,2,3};
		System.out.println(a.length);
	}

}

