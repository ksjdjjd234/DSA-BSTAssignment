// Update the item status information
    public void updateStatus(int itemID) {
        LostItemNode found = searchItemRecursive(root, itemID);
        if (found != null) {
            System.out.println("Current status for Item ID " + itemID + ": " + found.status);
            if (found.status.equalsIgnoreCase("Unclaimed")) {
                found.status = "Claimed by Owner";
            } else {
                found.status = "Unclaimed";
            }
            System.out.println("Status updated successfully to: " + found.status);
        } else {
            System.out.println("No matching item exists for ID " + itemID + ". Cannot update status");
        }
    }