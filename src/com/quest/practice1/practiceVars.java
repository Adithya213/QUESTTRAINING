package com.quest.practice1;

public class practiceVars {
    final static int VOTE_AGE=10; //once we declared final it will constant & to understand that all must be in caps
    public static void main(String[] args) {
        int age=18;  //local variables
        double salary=20000.00;
       final char GENDER='M';
        String firstName="John";
        String lastName="Doe";
        System.out.println("age = "+age);
        System.out.println("salary = "+salary);
        System.out.println("gender = "+GENDER);
        System.out.println("fname = "+firstName);
        System.out.println("lname = "+lastName);

        //ones we initialize var we can change it
        age=20;//reinitialization
        System.out.println("age = "+age);
        System.out.println("Vote Age is = "+VOTE_AGE);
//        VOTE_AGE=20
//      it cannot be changed since VOTEAGE is final

//        scope of local variable is it can access only in that method only


//     callig the method
practiceConversion();
stringConcatenation();
stringMethods();
    }
    static private void practiceConversion(){
        int a=20;
        double b=25;
        double sum=a+b; //implicit conversion since a is int and b is double
//        int round=b; //double to int cannot convert implicit
        int round=(int)b; //narrowing
        System.out.println("sum = "+sum);
        System.out.println("round = "+round);
    }

    private static void stringConcatenation(){
        String s1="John";
        String s2="Doe";
        String s3=s1+" "+s2; // concat using + operator
        System.out.println(s3);
        int age=20;
        System.out.println("name = "+s3+" age = "+age);

    }

    private static void stringMethods(){
        String s1="John"; //s1 and s2 are literals
        String s2="JOHN";
        String s3=new String("Hello WORld"); //here we creating an object s3 to store in heap memory
        String s4 =new String("hello world"); //here we creating an object s4 to store in heap memory

        System.out.println(s3.length());
        System.out.println(s3==s2);
        System.out.println(s3.equalsIgnoreCase(s4));
        System.out.println(s3.equals(s4));//it will check content of s1 and s2
        System.out.println(s4==s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

//        equals(): Checks if two strings are exactly the same, including case.
//        equalsIgnoreCase(): Checks if two strings are the same, but ignores case.


    }

}
