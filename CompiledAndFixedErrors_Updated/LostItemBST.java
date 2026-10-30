public class LostItemBST {

    protected LostItemNode root;

    public LostItemBST(){
        root = null;
    }
    
    public void addItem (int itemID, String itemName, String category, String locationFound, String dateReported, String status) {
        root = addRecursive(root, itemID, itemName, category, locationFound, dateReported, status);
    }

    private LostItemNode addRecursive(LostItemNode current, int itemID, String itemName, String category, String locationFound, String dateReported, String status) {
        if (current == null) {
            System.out.println("\nItem added successfully!\n");
            return new LostItemNode( itemID, itemName, category, locationFound, dateReported, status);   
        }

        if (itemID < current.itemID){
            current.left = addRecursive( current.left, itemID, itemName, category, locationFound, dateReported, status);
        }

        else if (itemID > current.itemID){
            current.right = addRecursive( current.right, itemID, itemName, category, locationFound, dateReported, status);
        }
        
        else {
            System.out.println("Duplicate itemID is not allowed.");
        }

        return current;
    }

    // Find an item using its Item ID
    public void searchItem(int itemID) {
        LostItemNode found = searchItemRecursive(root, itemID);
        if (found != null) {
            System.out.println("\nThe requested item was found!");
			found.displayTheNode();
            
        } else {
            System.out.println("No matching item exists for ID number: " + itemID);
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
    
    // Update the item status information
    public void updateStatus(int itemID) {
        LostItemNode found = searchItemRecursive(root, itemID);
        if (found != null) {
            System.out.println("\nCurrent status for Item ID " + itemID + ": " + found.status);
            if (found.status.equalsIgnoreCase("Unclaimed")) {
                found.status = "Claimed";
            } else {
                found.status = "Unclaimed";
            }
            System.out.println("Status updated successfully to: " + found.status + "\n");
        } else {
            System.out.println("No matching item exists for ID number: " + itemID + ". Cannot update the item status");
        }
    }
    
    // List all registered items in ascending ID order
    public void displayInOrder() {
        if (root == null) {
            System.out.println("There are currently no items registered");
            return;
        }
        System.out.println("\nLost Items Register (Sorted by ID in Ascending Order) ");
        inOrderRecursive(root);
    }

    private void inOrderRecursive(LostItemNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            node.displayTheNode();
            inOrderRecursive(node.right);
        }
    }
    
    public void displayPreOrder() {
    	if (root == null) {
    		System.out.println("Tree is empty");
    		return;
    	}
    	
    	System.out.println("\nPre-Order Traversal:");
    	preOrderRecursion(root);
    }

    private void preOrderRecursion(LostItemNode current) {
    	if (current == null) {
    		return;
    	}
    	current.displayTheNode();
    	preOrderRecursion(current.left);
    	preOrderRecursion(current.right);
    }

    public void displayPostOrder() {
    	if (root == null) {
    		System.out.println("Tree is empty");
    		return;
    	}
    	
    	System.out.println("\nPost-Order Traversal:");
    	postOrderRecursion(root);
    }

    private void postOrderRecursion(LostItemNode current) {
    	if (current == null) {
    		return;
    	}
    	
    	postOrderRecursion(current.left);
    	postOrderRecursion(current.right);
		current.displayTheNode();
    }
    
    public void deleteItem(int itemID) {
	    if (searchItemRecursive(root, itemID) == null) {
	        System.out.println("Item ID not found. Nothing was deleted.");
	        return;
	    }

	    root = deleteRecursive(root, itemID);
	    System.out.println("Item deleted successfully.");
	}

	// Recursive deletion helper
	private LostItemNode deleteRecursive(LostItemNode current, int itemID) {
	
		if (current == null) {
			return null;
		}
	
		if (itemID < current.itemID) {
			current.left = deleteRecursive(current.left, itemID);
		} else if (itemID > current.itemID) {
			current.right = deleteRecursive(current.right, itemID);
		} else {
	
			// Case 1: Node has no children
			if (current.left == null && current.right == null) {
				return null;
			}
	
			// Case 2: Node has only a right child
			if (current.left == null) {
				return current.right;
			}
	
			// Case 2: Node has only a left child
			if (current.right == null) {
				return current.left;
			}
	
			// Case 3: Node has two children
			LostItemNode successor = findMin(current.right);
	
			// Copy all item data from the successor
			current.itemID = successor.itemID;
			current.itemName = successor.itemName;
			current.category = successor.category;
			current.locationFound = successor.locationFound;
			current.dateReported = successor.dateReported;
			current.status = successor.status;
	
			// Delete the successor from the right subtree
			current.right = deleteRecursive(current.right, successor.itemID);
		}
	
		return current;
	}

	// Find the smallest node in a subtree
	private LostItemNode findMin(LostItemNode current) {
		while (current.left != null) {
			current = current.left;
		}
	
		return current;
	}
	
	// Khalaf's Category Filtering System (this should be already in BST.java)

	public void displayItemsByCategory(String targetCategory) {
	    System.out.println("\nItems in Category: " + targetCategory);
	   boolean found = displayItemsByCategoryRecursive(root, targetCategory);
	    if (!found) {
	        System.out.println("No items found in " + targetCategory);
	    }
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
	            current.displayTheNode();
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
	    private int getHeightRecursive(LostItemNode current) {
	        if (current == null) {
	            return -1; 
	        }

	        if (current.left == null && current.right == null) {
	            return 0; 
	        }
	       return 1 + Math.max(getHeightRecursive(current.left), getHeightRecursive(current.right));
	    }

	    public void displayStatistics() {
	        int totalItems = countItems();
	        int unclaimedItems = countUnclaimedItems();
	        int claimedItems = countClaimedItems();
	        int height = getHeight();
	        
	        System.out.println("\n-----------------------------------");
	        System.out.println("Total Items: " + totalItems);
	        System.out.println("Unclaimed Items: " + unclaimedItems);
	        System.out.println("Claimed Items: " + claimedItems);
	        System.out.println("Height of the Tree: " + height);
	        System.out.println("-----------------------------------");
	    }
}
