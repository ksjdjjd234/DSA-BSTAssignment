// Khalaf's Category Filtering System (this should be already in BST.java)

public void displayItemsByCategory(String targetCategory) {
    System.out.println("Items in Category: " + targetCategory);
   boolean found = displayItemsByCategory(root, targetCategory);
    if (!found) {
        System.out.println("No items found in the specified category.");
    }

    private boolean displayItemsByCategoryRecursive(LostItemNode current, String targetCategory) {
        if (current == null) {
            return false;
        }

    boolean matchFound = false;
    
    if (displayItemsByCategoryRecursive(current.left, targetCategory)) {
        matchFound = true;
    }

    if (current.category.equalsIgnoreCase(targetCategory)) {
            System.out.println("Item ID: " + current.itemID);
            System.out.println("Item Name: " + current.itemName);
            System.out.println("Location Found: " + current.locationFound);
            System.out.println("Date Reported: " + current.dateReported);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------------");
            matchFound = true;
        }

        if (displayItemsByCategoryRecursive(current.right, targetCategory)) {
            matchFound = true;
        }

        return matchFound;
    }

    // Khalaf's Statistics & Height
    public int countItems() {
        return countItemsRecursive(root);
    }

    private int countItemsRecursive(LostItemNode current) {
        if (current == null) {
            return 0;
        }
        return 1 + countItemsRecursive(current.left) + countItemsRecursive(current.right);
    }

    public int countUnclaimedItems() {
        return countUnclaimedItemsRecursive(root);
    }

    private int countUnclaimedItemsRecursive(LostItemNode current) {
        if (current == null) {
            return 0;
        }
        int count = 0;
        if (current.status.equalsIgnoreCase("Unclaimed")) {
            count++;
        }
        return count + countUnclaimedItemsRecursive(current.left) + countUnclaimedItemsRecursive(current.right);
    }

    public int countClaimedItems() {
        return countClaimedItemsRecursive(root);
    }

    private int countClaimedItemsRecursive(LostItemNode current) {
        if (current == null) {
            return 0;
        }
        int count = 0;
        if (current.status.equalsIgnoreCase("Claimed")) {
            count++;
        }
        return count + countClaimedItemsRecursive(current.left) + countClaimedItemsRecursive(current.right);
    }

    public int getHeight() {
        return getHeightRecursive(root);
    }
    private int calculateHeight(LostItemNode current) {
        if (current == null) {
            return -1; 
        }

        if (current.left == null && current.right == null) {
            return 0; 
        }
       return 1 + Math.max(calculateHeight(current.left), calculateHeight(current.right));
    }

    public void displayStatistics() {
        int totalItems = countItems();
        int unclaimedItems = countUnclaimedItems();
        int claimedItems = countClaimedItems();
        int height = getHeight();

        System.out.println("Total Items: " + totalItems);
        System.out.println("Unclaimed Items: " + unclaimedItems);
        System.out.println("Claimed Items: " + claimedItems);
        System.out.println("Height of the Tree: " + height);
    }