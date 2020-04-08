package module_work;
// работа Харламова Игоря ПП-11 Вариант 2 (1)
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    public static int size_arr1;
    public static int size_arr2;
    public static int [] array1;
    public static int [] array2;

    public static void menu() {
        System.out.println("Enter the quantity numbers for array 1 max(10) min (1)");
        size_arr1 = Check_num();
        System.out.println("Enter the quantity numbers for array 2 max(10) min (1)");
        size_arr2 = Check_num();
        array1 = new int[size_arr1];
        array2 = new int[size_arr2];
        System.out.println("Input filling method for array 1 : 1-autofill 2-manually");
        Scanner Input = new Scanner(System.in);
         int switch_number = Input.nextInt();
        switch (switch_number){
            case 1: autoFill1();
                break;
            case 2: manual_filling1();
                break;
            default:autoFill1();
        }
        System.out.println("Input filling method for array 2 : 1-autofill 2-manually");
         switch_number = Input.nextInt();
        switch (switch_number){
            case 1: autoFill2();
                break;
            case 2: manual_filling2();
                break;
            default:autoFill2();
        }
        result();
    }
    public static void autoFill1(){
        for(int i=0; i<size_arr1; i++) {
            array1[i]=(int) (Math.random()*101)-1;
            if(array1[i]<=0)
                array1[i]=1;
        }
    }
    public static void autoFill2(){
        for(int i=0; i<size_arr2; i++) {
            array2[i]=(int) (Math.random()*101)-1;
            if(array2[i]<=0)
                array2[i]=1;
        }
    }
    public static void manual_filling1(){
        for(int i=0; i<size_arr1; i++){
            System.out.println("Enter the number ["+(i+1)+"] for array 1 ");
            int case_number = Check_num1();
            array1[i]=case_number;
        }
    }
    public static void manual_filling2(){
        for(int i=0; i<size_arr2; i++){
            System.out.println("Enter the number ["+(i+1)+"] for array 2 ");
            int case_number = Check_num1();
            array2[i]=case_number;
        }
    }
    public static void result(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        int cur = array1[size_arr1-1];
        int end = array2[0];
        for (; cur < end; cur++) {
            boolean every = true;
            for (int i=0; i < size_arr1; i++)
                if (cur % array1[i] > 0) {
                    every = false;
                    break;
                }
            if (!every)
                continue;
            every = true;
            for (int i=0; i < size_arr2; i++)
                if (array2[i] % cur > 0) {
                    every = false;
                    break;
                }
            if (!every)
                continue;
            results.add(cur);
        }

        if (results.size() > 0) {
            System.out.println("And here are the numbers that meet the conditions:");
            for (int v : results)
                System.out.printf("%d ", v);
            System.out.println();
        } else {
            System.out.println("no numbers");
        }
    }
    public   static int Check_num() {
        int selected_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                selected_num = Input_number.nextInt();
                if(selected_num>=1 && selected_num<=10)
                    break;
            }
            System.out.println("user do not enrage me and enter the number");
        }
        return selected_num;
    }
    public   static int Check_num1() {
        int selected_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                selected_num = Input_number.nextInt();
                if(selected_num>=1 && selected_num<=100)
                    break;
            }
            System.out.println("user do not enrage me and enter the number");
        }
        return selected_num;
    }
    public static void main(String[] args) {
        boolean bool = true;
        menu();
        do {
            System.out.println("Enter 0-Exit ; 1-continue ");
            Scanner Input = new Scanner(System.in);
            int switch_number = Input.nextInt();
            switch(switch_number){
                case 1:  menu();
                    break;
                case 0:  bool=false;
                    break;
                default: break;
            }

        }while (bool);
    }
}
