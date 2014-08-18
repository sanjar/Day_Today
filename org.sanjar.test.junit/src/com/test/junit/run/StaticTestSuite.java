package com.test.junit.run;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.junit.Test1;
import com.test.junit.Test2;

@RunWith(Suite.class)
@SuiteClasses({Test1.class,Test2.class})
public class StaticTestSuite {

}
