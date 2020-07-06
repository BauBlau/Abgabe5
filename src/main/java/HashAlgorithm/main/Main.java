package HashAlgorithm.main;

import HashAlgorithm.hash.Hash;
import HashAlgorithm.probing.DoubleHashingProbing;
import HashAlgorithm.probing.LinearProbing;
import HashAlgorithm.probing.QuadraticProbing;
import HashAlgorithm.sort.Student;
import HashAlgorithm.sort.StudentMain;

import javax.naming.PartialResultException;
import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 12, 53, 5, 15, 2, 19
        int size = 7;

        execute(new ADSHashTable(size, new Hash(size), new LinearProbing()));
        execute(new ADSHashTable(size, new Hash(size), new QuadraticProbing()));
        execute(new ADSHashTable(size, new Hash(size), new DoubleHashingProbing(5)));




    }

    private static void execute(ADSHashTable table) {
        HashInvoker.print("--------------------------------------");

        HashInvoker.insert(table, 12);
        HashInvoker.insert(table, 53);
        HashInvoker.insert(table, 5);
        HashInvoker.insert(table, 15);
        HashInvoker.insert(table, 2);
        HashInvoker.insert(table, 19);

        Scanner ein = new Scanner(System.in);
        char aktion = '0';

        while (aktion != 'e'){
            System.out.println();
            System.out.println("--> Bitte wählen Sie eine Aktion aus <--");
            System.out.println(" 1  Add number to hash table.");
            System.out.println(" 2  Get number from hash table.  ");
            System.out.println(" 3  Search number in hash table.");
            System.out.println(" 4  Delete number from hash table.");
            System.out.println(" 5  Clear hash table.");
            System.out.println(" 6  Sort students by matriculation number.");
            System.out.println(" e    Exit");
            System.out.println("Ihre Eingabe: ");
            aktion = ein.next().charAt(0);

            switch (aktion) {

                case '1':
                    System.out.println("New Number: ____  ");
                    int nummer = ein.nextInt();
                    HashInvoker.insert(table, nummer);
                    break;

                case '2':
                    System.out.println("Get number: ____");
                    nummer = ein.nextInt();
                    HashInvoker.search(table, nummer);
                    break;

                case '3':
                    System.out.println("Search for number: ____");
                    nummer = ein.nextInt();
                    HashInvoker.search(table, nummer);
                    break;

                case '4':
                    System.out.println("Delete number: ____");
                    nummer = ein.nextInt();
                    HashInvoker.remove(table, nummer);
                    break;

                case '5':
                    HashInvoker.clear(table);
                    break;



                case '6':
                    System.out.println("Which Sorting Algorithm: ____");
                    char aktionSort = '0';
                    while (aktionSort != 'e') {

                        Student s1 = new Student("Adam", "Apfel", 10, 1);
                        Student s2 = new Student("Bernt", "Brot", 10, 2);
                        Student s3 = new Student("Chester", "Chrysler", 10, 3);
                        Student s4 = new Student("Denis", "Dose", 10, 4);
                        Student s5 = new Student("Emil", "Eis", 10, 5);
                        int[] arr = {s3.getMatriculationNumber(), s2.getMatriculationNumber(), s1.getMatriculationNumber(), s4.getMatriculationNumber(), s5.getMatriculationNumber()};
                        int l = arr.length;

                        System.out.println("--> Bitte wählen Sie eine Aktion aus <--");
                        System.out.println(" 1  Insertion sort.");
                        System.out.println(" 2  Heap sort.  ");
                        System.out.println(" 3  Bubble sort.");
                        System.out.println(" 4  Quicksort.");
                        System.out.println(" e    Exit");
                        System.out.println();
                        System.out.println("Studenten unsortiert:");
                        for (int i = 0; i < l; i++) {
                            if (arr[i] == s1.getMatriculationNumber()) {
                                System.out.println(s1);
                            } else if (arr[i] == s2.getMatriculationNumber()) {
                                System.out.println(s2);
                            } else if (arr[i] == s3.getMatriculationNumber()) {
                                System.out.println(s3);
                            } else if (arr[i] == s4.getMatriculationNumber()) {
                                System.out.println(s4);
                            } else if (arr[i] == s5.getMatriculationNumber()) {
                                System.out.println(s5);
                            }
                        }
                        System.out.println();
                        System.out.println("Ihre Eingabe: ");
                        aktionSort = ein.next().charAt(0);

                        switch (aktionSort) {

                            case'1':
                                StudentMain.insertionSort(arr);
                                break;

                            case '2':
                                StudentMain.heapSort(arr);
                                break;

                            case'3':
                                StudentMain.bubbleSort(arr);
                                break;

                            case'4':

                                int k = arr.length;
                                StudentMain.sort(arr,0,k-1);
                                break;

                            case'e':
                                break;
                        }
                        for (int i = 0; i < l; i++) {
                            if (arr[i] == s1.getMatriculationNumber()) {
                                System.out.println(s1);
                            } else if (arr[i] == s2.getMatriculationNumber()) {
                                System.out.println(s2);
                            } else if (arr[i] == s3.getMatriculationNumber()) {
                                System.out.println(s3);
                            } else if (arr[i] == s4.getMatriculationNumber()) {
                                System.out.println(s4);
                            } else if (arr[i] == s5.getMatriculationNumber()) {
                                System.out.println(s5);
                            }
                        }
                    }
                case 'e':
                    System.exit(0);
                    break;

            }

        }

    }
}
