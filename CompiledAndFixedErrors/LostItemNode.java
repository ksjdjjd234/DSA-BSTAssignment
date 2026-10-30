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

}