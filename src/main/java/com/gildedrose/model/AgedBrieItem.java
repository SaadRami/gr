package com.gildedrose.model;

public class AgedBrieItem extends BaseItem {
    private AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseItemQuality();
    }

    @Override
    protected void updateQualitySellByDate() {
        increaseItemQuality();
    }

    public static BaseItem createAgedBrieItem(Item item) {
        return new AgedBrieItem(item);
    }

}
