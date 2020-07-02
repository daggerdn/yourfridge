package pl.devnowak.yourfridge.entity;

public enum ProductCategory {

    VEGETABLES("Vegetables"),
    FRUITS("Fruits"),
    GRAINS("Grains"),
    BAKERY("Bakery"),
    MEAT("Meat"),
    DAIRY("Dairy"),
    SWEETS("Sweets"),
    SNACKS("Snacks"),
    CAKES("Cakes"),
    DRINKS("Drinks");

    private final String productCategory;

    ProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }
}
