package com.gildedrose;

import com.gildedrose.model.BaseItem;
import com.gildedrose.model.Item;

import java.util.function.Predicate;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        updateItemsBaseOnCondition(item -> !item.isSulfuras());
    }

    private void updateItemsBaseOnCondition(Predicate<BaseItem> requirementCondition) {
        for (Item item : items) {
            BaseItem baseItem = BaseItem.wrapItem(item);
            if (requirementCondition.test(baseItem)) {
                baseItem.performUpdateFlow();
            }
        }
    }

    /**********  Analyzing and Refactoring Code Phase **********/
//    private void increaseItemQuality(Item item) {
//        if (item.quality < 50) {
//            item.quality++;
//        }
//    }
//
//    private void decreaseItemQuality(Item item) {
//        if (item.quality > 0) {
//            item.quality--;
//        }
//    }
//
//    private void dropQualityToZero(Item item) {
//        item.quality = 0;
//    }
//
//    private void updateItem(Item item) {
//        if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASS)) {
//            increaseItemQuality(item);
//
//            if (item.name.equals(BACKSTAGE_PASS)) {
//                if (item.sellIn <= 10) {
//                    increaseItemQuality(item);
//                }
//
//                if (item.sellIn <= 5) {
//                    increaseItemQuality(item);
//                }
//            }
//        } else {
//            decreaseItemQuality(item);
//        }
//    }
//
//    private void updateIfExpired(Item item) {
//        if (item.sellIn < 0) {
//            switch (item.name) {
//                case AGED_BRIE:
//                    increaseItemQuality(item);
//                    break;
//                case BACKSTAGE_PASS:
//                    dropQualityToZero(item);
//                    break;
//                default:
//                    decreaseItemQuality(item);
//                    break;
//            }
//        }
//    }


    /****************** Original UpdateQuality Method ********************/
//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }


}
