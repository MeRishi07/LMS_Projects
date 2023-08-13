package LMS_Projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TheDeskApplication {

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }

    private static void optionsSelection() {
        String[] arr = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int slen = arr1.length;
        for (int i = 0; i < slen; i++) {
            System.out.println(arr[i]);
        }
        ArrayList<Integer> expenses = new ArrayList<>(Arrays.asList(1000, 2300, 45000, 32000, 110));

        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        while (options != 6) {
            switch (options) {
                case 1:
                    System.out.println("Your saved expenses are listed below: \n");
                    System.out.println(expenses + "\n");
                    break;
                case 2:
                    System.out.println("Enter the value to add your Expense: \n");
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    break;
                case 3:
                    System.out.println("You are about to delete all your expenses! \nConfirm again by selecting the same option...\n");
                    int con_choice = sc.nextInt();
                    if (con_choice == options) {
                        expenses.clear();
                        System.out.println(expenses + "\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                    break;
                case 4:
                    sortExpenses(expenses);
                    break;
                case 5:
                    searchExpenses(expenses);
                    break;
                default:
                    System.out.println("You have made an invalid choice!");
                    break;
            }
            System.out.println("\nEnter your choice:\t");
            options = sc.nextInt();
        }
        if (options == 6) {
            closeApp();
        }
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int leng = arrayList.size();
        System.out.println("Enter the expense you need to search:\t");
        Scanner sc = new Scanner(System.in);
        int searchExpense = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < leng; i++) {
            if (arrayList.get(i) == searchExpense) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Expense found!");
        } else {
            System.out.println("Expense not found!");
        }
    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength = arrayList.size();

        // Convert ArrayList to array
        Integer[] expensesArray = arrayList.toArray(new Integer[arrlength]);

        // Sort the expenses array in ascending order using bubble sort
        for (int i = 0; i < arrlength - 1; i++) {
            for (int j = 0; j < arrlength - i - 1; j++) {
                if (expensesArray[j] > expensesArray[j + 1]) {
                    // Swap the elements
                    int temp = expensesArray[j];
                    expensesArray[j] = expensesArray[j + 1];
                    expensesArray[j + 1] = temp;
                }
            }
        }

        // Update the sorted expenses back to the ArrayList
        arrayList.clear();
        arrayList.addAll(Arrays.asList(expensesArray));

        System.out.println("Expenses sorted in ascending order: " + arrayList);
    }
}
