import java.util.InputMismatchException;
import java.util.Scanner;
/* Group Members:
        Muhammad Nu’man Hani Bin Hussin B20250017
        Akmal Arif Bin Haji Zulkifli B20250308
        Mohammad Akmal Khalaf @ Bazil Asna bin Haji Ariffin B20250310
        Muhammad Syabil Na’aim Bin Muhammad Salleh B20250312
        */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LostItemBST bst = new LostItemBST();
        int choice = 0;
        do {
             System.out.println("\n<><><><><><><><><><><><><><><><><><><>");
            System.out.println(" LOST AND FOUND REGISTRATION SYSTEM");
            System.out.println("\n1. Add Lost Item");
            System.out.println("2. Display all Lost Items (Inorder)");
            System.out.println("3. Search Lost Item by ID");
            System.out.println("4. Update Lost Item by ID");
            System.out.println("5. Delete Lost Item by ID");
            System.out.println("6. Display all Lost Items (Preorder)");
            System.out.println("7. Display all Lost Items (Postorder)");
            System.out.println("8. Display items by category");
            System.out.println("9. Display statistics");
            System.out.println("10. Exit");
            System.out.print("\nEnter your choice (1-10):");
            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch(choice) {
                        case 1:
                        System.out.print("\nEnter Item ID (integer): ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Item name: ");
                        String name = scanner.nextLine();
                        // Opted for predefined categories selection to reduce data inconsistencies 
                        System.out.println("\n Enter Category: ");
                        System.out.println("1. Electronics");
                        System.out.println("2. Clothing");
                        System.out.println("3. Documents");
                        System.out.println("4. Accessories");
                        System.out.println("5. Keys");
                        System.out.println("6. Others");
                        System.out.print("Enter category choice (1-6): ");
                        String categoryInput = scanner.nextLine().trim();
                        String category = ("Others");

                        switch (categoryInput) {
                            case "1": category = "Electronics"; break;
                            case "2": category = "Clothing"; break;
                            case "3": category = "Documents"; break;
                            case "4": category = "Accessories"; break;
                            case "5": category = "Keys"; break;
                            case "6": category = "Others"; break;

                            default:
                                System.out.println("Invalid category choice, Defaulted to 'Others'");
                                category = "Others";
                        }

                        System.out.print("Enter Location Found: ");
                        String location = scanner.nextLine();
                        System.out.print("Enter Date Reported (e.g. DD//MM/YYYY) ");
                        String date = scanner.nextLine();

                        String status = "Unclaimed"; // Set to "Unclaimed" as default when adding an item
                        bst.addItem(id, name, category, location, date, status);
                        break;

                        case 2:
                            bst.displayInOrder();
                            break;
                        
                        case 3:
                            System.out.print("Enter Item ID to search");
                            int searchID = scanner.nextInt();
                            scanner.nextLine();
                            bst.searchItem(searchID);
                            break;

                        case 4:
                            System.out.print("Enter Item ID to update status: ");
                            int updateID = scanner.nextInt();
                            scanner.nextLine();
                            bst.updateStatus(updateID);
                            break;

                        case 5:
                            System.out.print("Enter Item ID to delete: ");
                            int deleteID = scanner.nextInt();
                            scanner.nextLine();
                            bst.deleteItem(deleteID);
                            break;

                        case 6:
                            bst.displayPreOrder();
                            break;
                        
                        case 7:
                            bst.displayPostOrder();
                            break;

                        case 8:
                            System.out.println("\nEnter Category to filter: ");
                            System.out.println("1. Electronics");
                            System.out.println("2. Clothing");
                            System.out.println("3. Documents");
                            System.out.println("4. Accessories");
                            System.out.println("5. Keys");
                            System.out.println("6. Others");
                            System.out.println("\n Enter category choice (1-6): ");

                            String filterChoice = scanner.nextLine().trim();
                            String targetCategory = "";

                            switch (filterChoice) {
                                case "1": targetCategory = "Electronics"; break;
                            case "2": targetCategory = "Clothing"; break;
                            case "3": targetCategory = "Documents"; break;
                            case "4": targetCategory = "Accessories"; break;
                            case "5": targetCategory = "Keys"; break;
                            case "6": targetCategory = "Others"; break;
                            default:
                                System.out.println("Invalid selection.");
                                targetCategory = "";
                            }
                            if(!targetCategory.isEmpty()) {
                                bst.displayItemsByCategory(targetCategory);
                            }
                            break;

                        case 9:
                            bst.displayStatistics();
                            break;
                        
                        case 10:
                            System.out.println("\nExiting Program. Thank you and Good luck with the exam!");
                            break;
                            

                        default:
                            System.out.println("Invalid choice. Please enter a number from 1-10");

                    }
                } else {
                    String invalidInput = scanner.next();
                    System.out.println("Error: " + invalidInput + " is not a valid input. Please enter an integer betweeen 1-10.");
                } 
            } catch (InputMismatchException e ) {
                    System.out.println("Input error detected. Please ensure you enter the correct data type."); 
                    scanner.nextLine();
                }
            } while (choice !=10);
            scanner.close();
        }
    }

            
                    
