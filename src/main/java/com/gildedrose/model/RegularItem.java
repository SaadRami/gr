package com.gildedrose.model;

public class RegularItem extends BaseItem {

    public RegularItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        if (hasExpired()) {
            decreaseItemQuality();
        }
        decreaseItemQuality();
    }

}
