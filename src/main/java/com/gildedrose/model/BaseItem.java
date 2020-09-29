package com.gildedrose.model;

import java.util.function.Supplier;

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
        return supplyItem(item);
    }

    private static BaseItem supplyItem(Item item) {
        Supplier<BaseItem> baseItemSupplier = () -> {
            if (containsConjuredWord(item.name)) {
                return new ConjuredItem(item);
            }

            switch (item.name) {
                case AGED_BRIE:
                    return new AgedBrieItem(item);
                case BACKSTAGE_PASS:
                    return new BackStageItem(item);
                case SULFURAS:
                    return new SulfurasItem(item);
                default:
                    return new RegularItem(item);
            }
        };

        return baseItemSupplier.get();
    }


    public abstract void update();

    private static boolean containsConjuredWord(String name) {
        return name.toLowerCase().contains(CONJURED);
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

    public void updateSellIn() {
        mItem.sellIn--;
    }

    protected void dropQualityToZero() {
        mItem.quality = MIN_QUALITY_VALUE;
    }

    public int getSellIn() {
        return mItem.sellIn;
    }
}
