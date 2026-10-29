// List all registered items in ascending ID order
    public void displayInOrder() {
        if (root == null) {
            System.out.println("There are currently no items registered");
            return;
        }
        System.out.println("\n Lost Items Register (Sorted by ID in Ascending Order) ");
        inOrderRecursive(root);
    }

    private void inOrderRecursive(LostItemNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            
            // Print the node information directly instead of using the display method
            // If pakai display method or any method to display let me know - for person 1
            System.out.println("----------------------------------------");
            System.out.println("Item ID       : " + node.itemID);
            System.out.println("Item Name     : " + node.itemName);
            System.out.println("Category      : " + node.category);
            System.out.println("Location Found: " + node.locationFound);
            System.out.println("Date Reported : " + node.dateReported);
            System.out.println("Status        : " + node.status);
            System.out.println("----------------------------------------");
            
            inOrderRecursive(node.right);
        }
    }