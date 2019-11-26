package com.example.demo.controller;

import com.example.demo.utils.ResultDto;

import java.io.*;
import java.util.HashMap;

public class demo {
    public static void main(String[] args) throws IOException {
        /*int count = 11;
        int pageSize = 5;
        int pageNumcount = count%pageSize==0?count/pageSize:count/pageSize+1;
        System.out.println(pageNumcount);
        ResultDto resultDto = new ResultDto();
        System.out.println(resultDto.setPageNumIs(10).getPageNum());*/
//        FileInputStream inputStream = new FileInputStream(new File("G:\\测试.txt"));
//        FileOutputStream fileOutputStream = new FileOutputStream(new File("G:\\demo.txt"));

      /*  InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String resul = null;
        while((resul = bufferedReader.readLine())!=null){
            builder.append(bufferedReader.readLine());
            fileOutputStream.write(resul.getBytes());
            System.out.println(resul+"00000000000000000");
        }*/
       /* bufferedReader.close();
        StringBuilder stringBuilder  = new StringBuilder();
        byte b[] = new byte[1024];
        int i = 1;
        while((i=inputStream.read(b))!=-1){
            String s = new String(b,0,i);
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder.toString());*/
        /*int[] in = new int[]{1,2,3,2};
       for(int i:twoSum(in,4)){
           System.out.println(i);
       }

    }

        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int [] result = new int[2];
            for(int i=0;i<nums.length;i++){
                int dif = target - nums[i];
                if(map.get(dif)!=null){
                    result[0] = i;
                    result[1] = map.get(dif);
                    return result;
                }
                map.put(nums[i],i);


            }
            return result;*/
        //链表
/*
        ListNode li = new ListNode(2);
        ListNode li1 = new ListNode(3);
        ListNode li2 = new ListNode(5);
        li.next = li1;
        li1.next = li2;

        addNodeVal(li,li2);

        }
        public static int addNodeVal(ListNode listNode1,ListNode listNode2){
                int [] ival = new int[3];
                int [] ival2 = new int[3];
                int count = 0,count2 = 0;


                if(listNode1==null||listNode2==null){
                    return -1;
                }
                for(int i=0;listNode1.next!=null;i++){
                    ival[i] = listNode1.val;
                    listNode1 = listNode1.next;
                    count++;
                }
                ival[count] = listNode1.val;


                *//*for(int i=0;listNode2.next!=null;i++){
                    ival2[i] = listNode2.val;
                    listNode2 = listNode2.next;
                    count2++;
                }
                ival2[count2] = listNode2.val;*//*
                int sumint = 0;
                int penio = 10;
                for(int i = ival.length-1;i>0;i--){



                }
            return sumint;*/
        //给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        //
        //如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        //如题目要求 将两个链表遍历相加 第一个难点是进位  然后将新的节点对象返回
       /* class Solution {
            public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
                ListNode pre = new ListNode(0);
                ListNode cur = pre;
                int carry = 0;
                while(l1 != null || l2 != null) {
                    int x = l1 == null ? 0 : l1.val;
                    int y = l2 == null ? 0 : l2.val;
                    int sum = x + y + carry;
                    //carry为进位增加的1   下一次计算加法就将他加了进去
                    carry = sum / 10;
                    sum = sum % 10;
                    cur.next = new ListNode(sum);

                    cur = cur.next;
                    if(l1 != null)
                        l1 = l1.next;
                    if(l2 != null)
                        l2 = l2.next;
                }
                if(carry == 1) {
                    cur.next = new ListNode(carry);
                }
                return pre.next;
            }
        }*/
        int [] in = new int[]{1,2,5,6,2,3,1};
        System.out.println(containsNearbyDuplicate(in,5));
        }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.get(nums[i])!=null&&Math.abs(i-map.get(nums[i]))==k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

}
