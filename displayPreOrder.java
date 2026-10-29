package assignment2;

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
	
	displayItem(current);
	preOrderRecursion(current.left);
	preOrderRecursion(current.right);
	
}
