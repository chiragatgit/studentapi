package com.assignment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class BatchProcess {
    public static void main(String args[]) {
        processBatch(4);
    }
    static void processBatch(int batchSize){
        StringBuilder sb = new StringBuilder("INSERT INTO employees (id, name, age, department)");
        boolean last = false;
        List<Integer> list = new ArrayList<Integer>(Collections.nCopies(97, 0));
        Iterator itr = list.iterator();
        int i=0,cnt=0;
        while(itr.hasNext()){
            itr.next();
            i++;
            cnt++;
            sb.append("(' ").append(i).append("',");
            sb.append("' ").append("abc").append("',");
            sb.append("' ").append(i+10).append("',");
            sb.append("' dept ").append(i).append("')");
            if(i!=list.size()){
                sb.append(",");
            }
            if(i%batchSize==0){
                cnt=0;
                if(i!=list.size()){
                    sb.deleteCharAt(sb.length()-1);
                }

                System.out.println(sb.toString());
                sb.setLength(0);
                sb.append("INSERT INTO employees (id, name, age, department)");
            }
        }
        if(cnt>0){
            System.out.println("last batch");
            System.out.println(sb.toString());
        }


    }
}