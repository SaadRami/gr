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
                baseItem.updateSellIn();
                baseItem.update();
            }
        }
    }

}
