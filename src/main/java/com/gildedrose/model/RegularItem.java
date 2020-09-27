package com.gildedrose.model;

public class RegularItem extends BaseItem {

    private RegularItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseItemQuality();
    }

    @Override
    protected void updateQualitySellByDate() {
        decreaseItemQuality();
    }

    public static BaseItem createRegularItem(Item item) {
        return new RegularItem(item);
    }

}
