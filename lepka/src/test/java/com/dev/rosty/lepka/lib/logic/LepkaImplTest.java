package com.dev.rosty.lepka.lib.logic;

import android.test.mock.MockApplication;

import com.dev.rosty.lepka.lib.Lepka;
import com.dev.rosty.lepka.lib.Module;
import com.dev.rosty.lepka.lib.Screen;
import com.dev.rosty.lepka.lib.command.Back;
import com.dev.rosty.lepka.lib.command.Forward;
import com.dev.rosty.lepka.lib.entity.module.TestModule1;
import com.dev.rosty.lepka.lib.entity.module.TestModule2;
import com.dev.rosty.lepka.lib.entity.module.TestModule3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen1;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen2;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen3;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen4;
import com.dev.rosty.lepka.lib.entity.screen.TestScreen5;
import com.dev.rosty.lepka.lib.logic.backstack.BackStack;
import com.dev.rosty.lepka.lib.logic.executor.Executor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class LepkaImplTest {

    private final List<Module> modules = new ArrayList<>();

    private ModulesProvider modulesProvider;
    private DataHeap        dataHeap;
    private Screen          entry;

    @Mock private Executor  executor;
    @Mock private BackStack backStack;

    private Lepka lepka;

    @Before public void setUp() throws Exception {

        modules.add(new TestModule1());
        modules.add(new TestModule2());
        modules.add(new TestModule3());

        modulesProvider = new ModulesProvider(modules);
        dataHeap        = new DataHeap();
        entry           = new TestScreen1();

        MockitoAnnotations.initMocks(this);

        lepka = new LepkaImpl(new MockApplication(),
                new TestScreen1(), executor, modulesProvider, backStack, dataHeap);
    }

    @Test public void executeBack() throws Exception {

        when(backStack.count()).thenReturn(0);
        lepka.execute(new Back());
        verify(executor, new Times(1)).closeRouter();

        when(backStack.count()).thenReturn(1);
        lepka.execute(new Back());
        verify(executor, new Times(2)).closeRouter();

        when(backStack.count()).thenReturn(2);
        lepka.execute(new Back());
        verify(executor, new Times(1)).closeScreen();

        when(backStack.count()).thenReturn(10);
        lepka.execute(new Back());
        verify(executor, new Times(2)).closeScreen();
    }

    @Test public void executeForward() throws Exception {

        Module module = modulesProvider.findControllerForScreen(entry);
        Screen screen = new TestScreen2();

        lepka.execute(new Forward(screen));

        verify(executor, new Times(1)).openScreen(
                any(module.getClass()),
                any(screen.getClass()),
                anyString());

        screen = new TestScreen4();
        module = modulesProvider.findControllerForScreen(screen);

        lepka.execute(new Forward(screen));

        verify(executor, new Times(1)).openRouter(
                any(module.getClass()),
                anyString());

        module = modulesProvider.findControllerForScreen(screen);
        screen = new TestScreen3();

        lepka.execute(new Forward(screen));

        verify(executor, new Times(1)).openScreen(
                any(module.getClass()),
                any(screen.getClass()),
                anyString());

        screen = new TestScreen5();
        module = modulesProvider.findControllerForScreen(screen);

        lepka.execute(new Forward(screen));

        verify(executor, new Times(1)).openRouter(
                any(module.getClass()),
                anyString());
    }

    @Test public void executeBackTo() throws Exception {
    }

    @Test public void executeForwardPop() throws Exception {
    }
}