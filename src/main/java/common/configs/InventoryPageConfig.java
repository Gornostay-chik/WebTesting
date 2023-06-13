package common.configs;

import common.objectValue.PreviewItemCard;

import java.util.List;

public class InventoryPageConfig {

    public static final String TITLE = "PRODUCT";
    public static final int COUNT_ITEM_PER_PAGE = 6;
    public static final String DEFAULT_SORT = "Name (A to Z)";
    public static final String SORT_Z_A = "Name (Z to A)";
    public static final String SORT_PRICE_LOW_HIGH = "Price (low to high)";
    public static final String SORT_PRICE_HIGH_LOW = "Price (high to low)";

    public static PreviewItemCard previewItem1 = PreviewItemCard.builder()
            .itemName("Sauce Labs Backpack")
            .itemDescription("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.")
            .itemPrice(29.99)
            .build();

    public static PreviewItemCard previewItem2 = PreviewItemCard.builder()
            .itemName("Sauce Labs Bike Light")
            .itemDescription("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.")
            .itemPrice(9.99)
            .build();

    public static PreviewItemCard previewItem3 = PreviewItemCard.builder()
            .itemName("Sauce Labs Bolt T-Shirt")
            .itemDescription("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.")
            .itemPrice(15.99)
            .build();

    public static PreviewItemCard previewItem4 = PreviewItemCard.builder()
            .itemName("Sauce Labs Fleece Jacket")
            .itemDescription("It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.")
            .itemPrice(49.99)
            .build();

    public static PreviewItemCard previewItem5 = PreviewItemCard.builder()
            .itemName("Sauce Labs Onesie")
            .itemDescription("Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.")
            .itemPrice(7.99)
            .build();

    public static PreviewItemCard previewItem6 = PreviewItemCard.builder()
            .itemName("Test.allTheThings() T-Shirt (Red)")
            .itemDescription("This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.")
            .itemPrice(15.99)
            .build();

    public static List<PreviewItemCard> expectedPreviewItemCard = List.of(previewItem1, previewItem2, previewItem3, previewItem4, previewItem5, previewItem6);
}
