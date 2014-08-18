package com.test.junit.run;

import java.io.IOException;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

public class DynamicSuite extends Suite {

    public DynamicSuite(Class<?> setupClass) throws InitializationError, IOException {
       super(setupClass, DynamicTestRun.suite());
    }
}
