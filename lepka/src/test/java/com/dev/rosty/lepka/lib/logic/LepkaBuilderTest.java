package com.dev.rosty.lepka.lib.logic;

import android.test.mock.MockApplication;

import com.dev.rosty.lepka.lib.Lepka;
import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.entity.module.TestModule1;
import com.dev.rosty.lepka.lib.entity.module.TestModule2;
import com.dev.rosty.lepka.lib.entity.module.TestModule3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen1;
import com.dev.rosty.lepka.lib.logic.backstack.BackStackSupport;
import com.dev.rosty.lepka.lib.logic.executor.ExecutorSupport;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class LepkaBuilderTest {

    private final List<Module> modules = new ArrayList<>();
    private final LepkaBuilder builder = new LepkaBuilder();

    @Before public void setUp() throws Exception {

        modules.add(new TestModule1());
        modules.add(new TestModule2());
        modules.add(new TestModule3());

        builder.setApplication(new MockApplication())
                .registerModules(modules)
                .setEntryScreen(new TestScreen1())
                .setUseSupport(true);
    }

    @Test public void registerModules() throws Exception {

        assertTrue(builder.modules.equals(modules));
    }

    @Test public void setEntryScreen() throws Exception {

        assertTrue(builder.screen instanceof TestScreen1);
    }

    @Test public void setApplication() throws Exception {

        assertTrue(builder.application instanceof MockApplication);
    }

    @Test public void setUseSupport() throws Exception {

        assertTrue(builder.useSupport);
    }

    @Test public void build() throws Exception {

        Lepka lepka = builder.build();

        assertTrue(lepka instanceof LepkaImpl);

        LepkaImpl lepkaImpl = (LepkaImpl) lepka;

        assertTrue(lepkaImpl.backStack instanceof BackStackSupport);
        assertTrue(lepkaImpl.executor  instanceof ExecutorSupport);

        assertNotNull(lepkaImpl.dataHeap);
        assertNotNull(lepkaImpl.modulesPool);
        assertNotNull(lepkaImpl.entry);
        assertNotNull(lepkaImpl.module);

        assertNull(lepkaImpl.screen);
    }
}