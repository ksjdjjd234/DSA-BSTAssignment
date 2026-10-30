public void displayPreOrder {
	if (root = null) {
		System.out.println("Tree is empty");
		return;
	}
	
	System.out.println("Pre-Order Traversal:");
	preOrderRecursion(root);
}

private void preOrderRecursion(LostItemNode current) {
	if (current == null) {
		return;
	}

	System.out.println("-------------------------");
	System.out.println("Item ID: " + current.itemID);
	System.out.println("Item Name: " + current.itemName);
	System.out.println("Category: " + current.category);
	System.out.println("Location: " + current.location);
	System.out.println("Date Reported: " + current.dateReported);
	System.out.println("Status: " + current.status);
	System.out.println("-------------------------");

	preOrderRecursion(current.left);
	preOrderRecursion(current.right);
}
