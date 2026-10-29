// Find an item using its Item ID
    public void searchItem(int itemID) {
        LostItemNode found = searchItemRecursive(root, itemID);
        if (found != null) {
            System.out.println("The requested item was found!");
            
            // Print the node information directly
            // If pakai display method or any method to display let me know - for person 1
            System.out.println("----------------------------------------");
            System.out.println("Item ID       : " + found.itemID);
            System.out.println("Item Name     : " + found.itemName);
            System.out.println("Category      : " + found.category);
            System.out.println("Location Found: " + found.locationFound);
            System.out.println("Date Reported : " + found.dateReported);
            System.out.println("Status        : " + found.status);
            System.out.println("----------------------------------------");
        } else {
            System.out.println("No matching item exists for ID " + itemID);
        }
    }

    private LostItemNode searchItemRecursive(LostItemNode node, int itemID) {
        if (node == null || node.itemID == itemID) {
            return node;
        }
        if (itemID < node.itemID) {
            return searchItemRecursive(node.left, itemID);
        }
        return searchItemRecursive(node.right, itemID);
    }