package com.gildedrose.model;

public class SulfurasItem extends BaseItem {
    private SulfurasItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        // Behavior : No Update
    }

    @Override
    protected void updateQualitySellByDate() {
        // Behavior : No Update
    }

    public static BaseItem createSulfurasItem(Item item) {
        return new SulfurasItem(item);
    }
}
