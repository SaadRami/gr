package com.gildedrose;

public abstract class BaseItem {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "conjured";

    private static final int MIN_QUALITY_VALUE = 0;
    private static final int MAX_QUALITY_VALUE = 50;

    private final Item mItem;

    public BaseItem(Item item) {
        mItem = item;
    }

    public static BaseItem wrapItem(Item item) {
        if (containsConjuredWord(item.name)) {
            return ConjuredItem.createConjuredItem(item);
        }

        switch (item.name) {
            case AGED_BRIE:
                return AgedBrieItem.createAgedBrieItem(item);
            case BACKSTAGE_PASS:
                return BackStageItem.createBackStageItem(item);
            case SULFURAS:
                return SulfurasItem.createSulfurasItem(item);
            default:
                return RegularItem.createRegularItem(item);
        }
    }

    public void performUpdateFlow() {
        updateQuality();
        updateSellIn();
        if (hasExpired()) {
            updateQualitySellByDate();
        }
    }

    protected abstract void updateQuality();

    protected abstract void updateQualitySellByDate();

    private static boolean containsConjuredWord(String name) {
        return name.toLowerCase().contains(CONJURED);
    }

    public final boolean isConjured() {
        return containsConjuredWord(mItem.name);
    }

    public final boolean isAgedBrie() {
        return AGED_BRIE.equals(mItem.name);
    }

    public final boolean isBackStage() {
        return BACKSTAGE_PASS.equals(mItem.name);
    }

    public final boolean isSulfuras() {
        return SULFURAS.equals(mItem.name);
    }


    protected void increaseItemQuality() {
        if (mItem.quality < MAX_QUALITY_VALUE) {
            mItem.quality++;
        }
    }

    protected void decreaseItemQuality() {
        if (mItem.quality > MIN_QUALITY_VALUE) {
            mItem.quality--;
        }
    }

    protected boolean hasExpired() {
        return mItem.sellIn < MIN_QUALITY_VALUE;
    }

    protected void updateSellIn() {
        mItem.sellIn--;
    }

    protected void dropQualityToZero() {
        mItem.quality = MIN_QUALITY_VALUE;
    }

    public int getSellIn() {
        return mItem.sellIn;
    }
}
