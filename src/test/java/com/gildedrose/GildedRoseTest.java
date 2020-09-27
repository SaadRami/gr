package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    /************************ GildedRose Scenarios **************************
     - Once the sell by date has passed, Quality degrades twice as fast
     - The Quality of an item is never negative
     - "Aged Brie" actually increases in Quality the older it gets
     - The Quality of an item is never more than 50
     - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
     - "Backstage passes", like aged brie, increases in Quality as its SellIn value approaches;
     Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     Quality drops to 0 after the concert
     "Conjured" items degrade in Quality twice as fast as normal items*/

    private static GildedRose app;

    @BeforeAll
    public static void setup() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 0, 20), // quality degrade as the sell date pass
                new Item("+5 Dexterity Vest", 0, 0), // quality never negative
                new Item("Aged Brie", 2, 0), // aged brie increases the older it gets
                new Item("Aged Brie", 2, 50), // item quality never more than 50
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), // sulfuras fixed quality
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20), // backstage quality increases by 2
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20), // backstage quality increases by 3
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20), // backstage quality drops to 0
                new Item("Conjured Mana Cake", 3, 6) // conjured quality degrades twice
        };

        app = new GildedRose(items);
    }

    @Test
    public void updateQuality() {
        app.updateQuality();

        Integer[] expectedResult = new Integer[]{18, 0, 1, 50, 80, 22, 23, 0, 4};
        List<Integer> qualityList = Arrays.stream(app.items).map(x -> x.quality).collect(Collectors.toList());
        Integer[] input = new Integer[qualityList.size()];
        input = qualityList.toArray(input);

        assertArrayEquals(expectedResult, input);
    }


    /************* Speicif Test units (Best practice ?) **********/

    private void updateItemQuality(Item item) {
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
    }

    @Test
    public void qualityDegradesTwiceSellByDatePassed_updateQuality() {
        Item regularItem = new Item("+5 Dexterity Vest", 0, 20);
        updateItemQuality(regularItem);

        assertEquals(18, regularItem.quality);
    }

    @Test
    public void qualityNeverNegative_updateQuality() {
        Item regularItem = new Item("+5 Dexterity Vest", 0, 0);
        updateItemQuality(regularItem);

        assertEquals(0, regularItem.quality);
    }

    @Test
    public void agedBrieQualityIncreaseOld_updateQuality() {
        Item agedBrie = new Item("Aged Brie", 2, 0);
        updateItemQuality(agedBrie);

        assertEquals(1, agedBrie.quality);
    }

    @Test
    public void itemQualityNeverAboveFifty_updateQuality() {
        Item agedBrie = new Item("Aged Brie", 2, 50);
        updateItemQuality(agedBrie);

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void sulfurasHasFixedQuality_updateQuality() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        updateItemQuality(sulfuras);

        assertEquals(80, sulfuras.quality);
    }

    @Test
    public void backstageQualityIncreaseByTwoLessThanOrEqualTenDays_updateQuality() {
        Item backStage = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
        updateItemQuality(backStage);

        assertEquals(22, backStage.quality);

    }

    @Test
    public void backstageQualityIncByThreeLessThanOrEqualFiveDays_updateQuality() {
        Item backStage = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20);
        updateItemQuality(backStage);

        assertEquals(23, backStage.quality);
    }

    @Test
    public void backstageQualityDropsAfterConcert_updateQuality() {
        Item backStage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        updateItemQuality(backStage);

        assertEquals(0, backStage.quality);
    }

    @Test
    public void conjuredQualityDegradeTwice_updateQuality() {
        Item conjured = new Item("Conjured Mana Cake", 3, 6);
        updateItemQuality(conjured);

        assertEquals(4, conjured.quality);
    }

}
