package com.gildedrose;

import com.gildedrose.factory.ItemTestFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void whenUpdateQualityThenItemsNameIsNotChanged() {
        Item testItem = ItemTestFactory.createItemWithTestName();
        GildedRose app = new GildedRose(new Item[]{testItem});
        app.updateQuality();
        assertEquals(ItemTestFactory.ITEM_TEST_NAME, app.items[0].name);
    }

}
