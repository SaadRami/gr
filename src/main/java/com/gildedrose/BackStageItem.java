package com.gildedrose;

public class BackStageItem extends BaseItem {
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;

    private BackStageItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseItemQuality();

        if (getSellIn() <= TEN_DAYS) {
            increaseItemQuality();
        }

        if (getSellIn() <= FIVE_DAYS) {
            increaseItemQuality();
        }
    }


    @Override
    protected void updateQualitySellByDate() {
        dropQualityToZero();
    }

    public static BaseItem createBackStageItem(Item item) {
        return new BackStageItem(item);
    }
}
