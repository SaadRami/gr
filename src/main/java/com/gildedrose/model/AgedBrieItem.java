package com.gildedrose.model;

public class AgedBrieItem extends BaseItem {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (hasExpired()) {
            increaseItemQuality();
        }
        increaseItemQuality();
    }

}
