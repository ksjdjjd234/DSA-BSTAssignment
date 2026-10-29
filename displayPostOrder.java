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
	displayItem(current);
}