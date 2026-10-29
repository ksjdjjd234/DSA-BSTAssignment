package assignment2;

public void deleteItem(int ID) {
	    if (searchItem(itemID) == null) {
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
	        current.location = successor.location;
	        current.dateReported = successor.dateReported;
	        current.status = successor.status;

	        // Delete the successor from the right subtree
	        current.right = deleteRecursive(
	                current.right, successor.itemID);
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
