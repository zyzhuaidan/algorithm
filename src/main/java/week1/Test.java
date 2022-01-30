package week1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "0.1.0";
        String pattern = "/^\\d+\\.\\d+\\.\\d+$/";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
        Integer a = new Integer(121212);
        Long b = Long.valueOf(a);
        String str1 = "[1,12,1212313,12121,2312]";
        List<Long> longs = JSON.parseObject(str1, new TypeReference<List<Long>>() {
        });
        for(Long e:longs){
            System.out.print(String.valueOf(e) + "--- ");
        }
    }
}
