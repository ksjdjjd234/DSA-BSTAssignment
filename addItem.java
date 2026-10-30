public void addItem (int itemID, String itemName, String category, String locationFound, String dateReported, String status) {

    root = addRecursive(root, itemID, itemName, category, locationFound, dateReported, status);
}

private LostItemNode addRecursive(LostItemNode current, int itemID, String itemName String category, String locationFound, String, dateReported String status) {

    if (current == null) {

        System.out.println("Item added successfully.");

        return new LostItemNode( itemID, itemName, category, locationFound, dateReported, status);
        

    }

    if (itemID < current.itemID){

        current.left = addRecursive( current.left, itemID, itemName, category, locationFound, dateReported, status);

        
    }

    else if (itemID > current.itemID){

        current.right = addRecursive( current.right, itemID, itemName, category, locationFound, dateReported, status);
    }
    
    else {

        System.out.println("Duplicate itemID is not allowed.")
    }

    return current;
}