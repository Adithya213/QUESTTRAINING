package com.quest.practice1;

public class JavaMethodExample {
    private static final int x=30;
    public static void main(String[] args) {

        JavaMethodExample javaMethodExample = new JavaMethodExample();
        javaMethodExample.display("hello");
      int result =   javaMethodExample.add(2,4);
      System.out.println(result);

    }

    /**
     * display string
     * @param str - name
     */
    private void display(String str) {
        System.out.println(str);
    }

    /**
     * add two numbers
     * @param a = n1
     * @param b -n2
     * @return - sum
     */
    private int add(int a, int b) {
        return a + b;
    }

}
