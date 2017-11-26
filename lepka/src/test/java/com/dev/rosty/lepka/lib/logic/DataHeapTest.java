package com.dev.rosty.lepka.lib.logic;

import com.dev.rosty.lepka.lib.entity.module.TestModule1;
import com.dev.rosty.lepka.lib.entity.module.TestModule2;
import com.dev.rosty.lepka.lib.entity.module.TestModule3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen1;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen2;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen4;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen5;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen6;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen7;
import com.dev.rosty.lepka.lib.screen.Data;
import com.dev.rosty.lepka.lib.screen.DataEmpty;
import com.dev.rosty.lepka.lib.util.KeysUtil;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rosty on 11/26/17.
 */
public class DataHeapTest {

    private final String KEY_MODULE_1 = KeysUtil.generateModuleKey(new TestModule1());
    private final String KEY_MODULE_2 = KeysUtil.generateModuleKey(new TestModule2());
    private final String KEY_MODULE_3 = KeysUtil.generateModuleKey(new TestModule3());

    private final String KEY_SCREEN_1 = KeysUtil.generateScreenKey(new TestScreen1());
    private final String KEY_SCREEN_2 = KeysUtil.generateScreenKey(new TestScreen2());
    private final String KEY_SCREEN_3 = KeysUtil.generateScreenKey(new TestScreen3());
    private final String KEY_SCREEN_4 = KeysUtil.generateScreenKey(new TestScreen4());
    private final String KEY_SCREEN_5 = KeysUtil.generateScreenKey(new TestScreen5());
    private final String KEY_SCREEN_6 = KeysUtil.generateScreenKey(new TestScreen6());
    private final String KEY_SCREEN_7 = KeysUtil.generateScreenKey(new TestScreen7());

    private final Data<Integer> data1 = new Data<>(1);
    private final Data<Integer> data2 = new Data<>(1);
    private final Data<Integer> data3 = new Data<>(1);

    private final Data<String> data4 = new Data<>("1");
    private final Data<String> data5 = new Data<>("2");
    private final Data<String> data6 = new Data<>("3");

    private final Data<Boolean> data7 = new Data<>(true);

    private final DataHeap dataHeap = new DataHeap();


    @Before public void setUp() throws Exception {

        dataHeap.addData(KEY_MODULE_1, KEY_SCREEN_1, data1);
        dataHeap.addData(KEY_MODULE_1, KEY_SCREEN_2, data2);
        dataHeap.addData(KEY_MODULE_2, KEY_SCREEN_3, data3);
        dataHeap.addData(KEY_MODULE_2, KEY_SCREEN_4, data4);
    }

    @Test public void getData() throws Exception {

        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_1).equals(data1));
        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_2).equals(data2));
        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_3).equals(data3));
        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_4).equals(data4));

        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_5) instanceof DataEmpty);
        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_6) instanceof DataEmpty);
        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_7) instanceof DataEmpty);
    }

    @Test public void addData() throws Exception {

        dataHeap.addData(KEY_MODULE_3, KEY_SCREEN_5, data5);
        dataHeap.addData(KEY_MODULE_3, KEY_SCREEN_6, data6);
        dataHeap.addData(KEY_MODULE_3, KEY_SCREEN_7, data7);

        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_5).equals(data5));
        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_6).equals(data6));
        assertTrue(dataHeap.getData(KEY_MODULE_3, KEY_SCREEN_7).equals(data7));
    }

    @Test public void clearData() throws Exception {

        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_1).equals(data1));
        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_2).equals(data2));
        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_3).equals(data3));
        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_4).equals(data4));

        dataHeap.clearData(KEY_MODULE_2);

        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_1).equals(data1));
        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_2).equals(data2));

        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_3) instanceof DataEmpty);
        assertTrue(dataHeap.getData(KEY_MODULE_2, KEY_SCREEN_4) instanceof DataEmpty);

        dataHeap.clearData(KEY_MODULE_1);

        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_1) instanceof DataEmpty);
        assertTrue(dataHeap.getData(KEY_MODULE_1, KEY_SCREEN_2) instanceof DataEmpty);
    }
}