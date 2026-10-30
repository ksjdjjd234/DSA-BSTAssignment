public class LostItemNode {

    int itemID;
    String itemName;
    String category;
    String locationFound;
    String dateReported;
    String status;

    LostItemNode left;
    LostItemNode right;

    public LostItemNode (int itemID, String itemName, String category, String locationFound, String dateReported, String status) {
        
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.locationFound = locationFound;
        this.dateReported = dateReported;
        this.status = status;

        left = null;
        right = null;

    }

    public void displayTheNode() {
        System.out.println("----------------------------------------");
        System.out.println("Item ID       : " + itemID);
        System.out.println("Item Name     : " + itemName);
        System.out.println("Category      : " + category);
        System.out.println("Location Found: " + locationFound);
        System.out.println("Date Reported : " + dateReported);
        System.out.println("Status        : " + status);
        System.out.println("----------------------------------------");
    }

}