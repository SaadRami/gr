package com.gildedrose.model;

public class BackStageItem extends BaseItem {

    public BackStageItem(Item item) {
        super(item);
    }

    @Override
    public void update() {
        increaseItemQuality();

        if (getSellIn() <= 10) {
            increaseItemQuality();
        }

        if (getSellIn() <= 5) {
            increaseItemQuality();
        }

        if (hasExpired()) {
            dropQualityToZero();
        }
    }


}
