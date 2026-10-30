public void displayPostOrder {
	if (root = null) {
		System.out.println("Tree is empty");
		return;
	}
	
	System.out.println("Post-Order Traversal:");
	postOrderRecursion(root);
}

private void postOrderRecursion(LostItemNode current) {
	if (current == null) {
		return;
	}
	
	postOrderRecursion(current.left);
	postOrderRecursion(current.right);

	System.out.println("-------------------------");
	System.out.println("Item ID: " + current.itemID);
	System.out.println("Item Name: " + current.itemName);
	System.out.println("Category: " + current.category);
	System.out.println("Location: " + current.location);
	System.out.println("Date Reported: " + current.dateReported);
	System.out.println("Status: " + current.status);
	System.out.println("-------------------------");
}
