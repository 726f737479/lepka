package com.dev.rosty.lepka.lib.logic;

import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity1;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity2;
import com.dev.rosty.lepka.lib.entity.activity.TestActivity3;
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

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rosty on 11/26/17.
 */
public class ModulesProviderTest {

    private List<Module> modules = new ArrayList<>();

    @Before public void setUp() throws Exception {

        modules.add(new TestModule1());
        modules.add(new TestModule2());
        modules.add(new TestModule3());
    }

    @Test public void findControllerForScreen() throws Exception {

        ModulesProvider modulesProvider = new ModulesProvider(modules);

        Module module1 = modulesProvider.findControllerForScreen(new TestScreen2());
        Module module2 = modulesProvider.findControllerForScreen(new TestScreen6());
        Module module3 = modulesProvider.findControllerForScreen(new TestScreen4());
        Module module4 = modulesProvider.findControllerForScreen(new TestScreen1());
        Module module5 = modulesProvider.findControllerForScreen(new TestScreen5());
        Module module6 = modulesProvider.findControllerForScreen(new TestScreen3());

        assertTrue(module1.getActivityClass().equals(TestActivity1.class));
        assertTrue(module2.getActivityClass().equals(TestActivity3.class));
        assertTrue(module3.getActivityClass().equals(TestActivity2.class));
        assertTrue(module4.getActivityClass().equals(TestActivity1.class));
        assertTrue(module5.getActivityClass().equals(TestActivity3.class));
        assertTrue(module6.getActivityClass().equals(TestActivity2.class));
    }

    @Test public void findControllerByActivity() throws Exception {

        ModulesProvider modulesProvider = new ModulesProvider(modules);

        Module module1 = modulesProvider.findControllerByActivity(new TestActivity3());
        Module module2 = modulesProvider.findControllerByActivity(new TestActivity1());
        Module module3 = modulesProvider.findControllerByActivity(new TestActivity2());

        assertTrue(module1.getActivityClass().equals(TestActivity3.class));
        assertTrue(module2.getActivityClass().equals(TestActivity1.class));
        assertTrue(module3.getActivityClass().equals(TestActivity2.class));
    }

    @Test public void findControllerForScreenPriority() throws Exception {

        ModulesProvider modulesProvider = new ModulesProvider(modules);

        Module module = modulesProvider.findControllerForScreen(new TestScreen7());

        assertTrue(module.getActivityClass().equals(TestActivity3.class));
    }
}