package com.gildedrose.model;

public class ConjuredItem extends BaseItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (hasExpired()) {
            decreaseItemQuality();
            decreaseItemQuality();
        }

        decreaseItemQuality();
        decreaseItemQuality();
    }

}
