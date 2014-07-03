package com.pivotallabs.android.businesstime.testHelpers;

import com.google.inject.util.Modules;
import com.pivotallabs.android.businesstime.ApplicationModule;
import com.pivotallabs.android.businesstime.TestApplicationModule;
import com.pivotallabs.android.businesstime.TestBusinessTimeApplication;
import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.*;
import roboguice.RoboGuice;

public class RobolectricTestRunnerWithInjection extends RobolectricTestRunner {
    public RobolectricTestRunnerWithInjection(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return TestLifeCycleWithInjection.class;
    }

    public static class TestLifeCycleWithInjection extends DefaultTestLifecycle {
        @Override
        public void prepareTest(Object test) {
            TestBusinessTimeApplication application = (TestBusinessTimeApplication)Robolectric.application;

            InjectMockModule mockModule = new InjectMockModule();
            InjectMockAnnotations.initInjectMocks(test.getClass(), mockModule, test);

            ApplicationModule applicationModule = new ApplicationModule();
            TestApplicationModule testApplicationModule = new TestApplicationModule();
            RoboGuice.setBaseApplicationInjector(application, RoboGuice.DEFAULT_STAGE,
                    RoboGuice.newDefaultRoboModule(application),
                    Modules.override(Modules.override(applicationModule).with(testApplicationModule)).with(mockModule));

            RoboGuice.getInjector(application).injectMembers(test);
            MockitoAnnotations.initMocks(test);
        }
    }
}
