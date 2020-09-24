package com.gildedrose;

public class ConjuredItem extends BaseItem {
    private ConjuredItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        // twice regular item behavior
        decreaseItemQuality();
        decreaseItemQuality();
    }

    @Override
    protected void updateQualitySellByDate() {
        // twice regular item behavior
        decreaseItemQuality();
        decreaseItemQuality();
    }

    public static ConjuredItem createConjuredItem(Item item) {
        return new ConjuredItem(item);
    }
}
