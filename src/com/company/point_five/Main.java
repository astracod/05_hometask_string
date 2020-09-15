package com.company.point_five;

import java.io.*;
import java.util.ArrayList;

public class Main {
    /*Задача:
        Имеется произвольный текстовый документ,
        выбрать из него все предложения в которых более 5ти слов
        Внешний документ :
        C:\Users\Admin\Desktop\3.txt
        */

    public static ArrayList<String> splitString(String inputString) {
        ArrayList<String> arr = new ArrayList<>();
        String lastString = "";
        char separator = '.';
        for (int i = 0; i < inputString.length(); i++) {
            lastString += inputString.charAt(i);
            if (inputString.charAt(i) == separator) {
                arr.add(lastString);
                lastString = "";
            }
        }
        return arr;
    }


    public static ArrayList<String> fromFive(ArrayList<String> inputArr) {
        ArrayList<String> arrayOfFive = new ArrayList<>();
        char space = ' ';
        char comma = ',';
        int count = 0;
        for (int i = 0; i < inputArr.size(); i++) {
            for (int j = 0; j < inputArr.get(i).length(); j++) {
                if ((inputArr.get(i).charAt(j) == space) | inputArr.get(i).charAt(j) == comma) {
                    if ((inputArr.get(i).charAt(j) == space) & inputArr.get(i).charAt(j + 1) == comma) continue;
                    if ((inputArr.get(i).charAt(j) == comma) & inputArr.get(i).charAt(j + 1) == space) continue;
                    count++;
                }
            }
            if (count > 4) {
                arrayOfFive.add(inputArr.get(i));
            }
            count = 0;
        }
        return arrayOfFive;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileReader fr = new FileReader("C:/Users/Admin/Desktop/3.txt");

        char[] a = new char[215];   // Количество символов, которое будем считывать
        fr.read(a) ;   // Чтение содержимого в массив
        String s = new String(a);
        String s2 = new String();
        int w = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (s.charAt(i) == '\n') continue;
            if (s.charAt(i) == '\r') continue;
            s2 += s.charAt(i);
            if (s.charAt(i) == '.') s2 += '\n';
        }


        System.out.println("<------- Исходные данные строки : ----->");
        System.out.println(s2);
        System.out.println("|-------------------------------|\n");

        ArrayList<String> arrayString = splitString(s2);
        System.out.println("<------- Вывод массива : ------->\n");
        for (int i = 0; i < arrayString.size(); i++) {
            System.out.print(arrayString.get(i));
        }
        System.out.println();
        System.out.println("|-------------------------------|\n");

        ArrayList<String> arrFive = fromFive(arrayString);
        System.out.println("<------- Вывод массива строк с предложениями более пяти слов: ------->");
        for (int i = 0; i < arrFive.size(); i++) {
            System.out.print(arrFive.get(i));
        }
        System.out.println();
        System.out.println("|--------------------------------------------------------------------|");

        OutputStream out = new FileOutputStream("C:/Users/Admin/Desktop/4.txt");
        PrintWriter writer = new PrintWriter(out);
        writer.print(arrayString);
        writer.flush();
    }
}
