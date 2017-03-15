package com.ffan.autotest.ffantest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest {

	@BeforeTest // 标记指定所有测试进行前呼叫此 method
	public void beforeAllTest() {
		System.out.println("Before All Test");
	}

	@BeforeMethod // 标记指定每个测试进行前呼叫此 method
	public void setUp() {
		System.out.println("Before Each Test Method");
	}

	@Test(groups = { "group1" }) // 标记为测试程式，并为分组 group1
	public void group1Test() {
		System.out.println("Group 1");
	}

	@Test(groups = { "group2" }) // 标记为测试程式，并为分组 group2
	public void group2Test() {
		System.out.println("Group 2");
	}

	@Test(groups = { "group3" }) // 标记为测试程式，并为分组 group3
	public void group3Test() {
		System.out.println("Group 3");
	}

	@AfterMethod // 标记指定每个测试进行后呼叫此 method
	public void tearDown() {
		System.out.println("After Each Test Method");
	}

	@AfterTest // 标记指定所有测试进行后呼叫此 method
	public void afterAllTest() {
		System.out.println("After All Test");
	}

	@Test(dataProvider = "range-provider")
	public void testIsBetween(int n, int lower, int upper, boolean expected) {
		System.out.println("Received " + n + " " + lower + "-" + upper + " expected: " + expected);
		Assert.assertEquals(expected, isBetween(n, lower, upper));
	}

	@DataProvider(name = "range-provider")
	public Object[][] rangeData() {
		int lower = 5;
		int upper = 10;
		return new Object[][] { { lower - 1, lower, upper, false }, { lower, lower, upper, true },
				{ lower + 1, lower, upper, true }, { upper, lower, upper, true }, { upper + 1, lower, upper, false }, };

	}

	public boolean isBetween(int n, int lower, int upper) {
		if (n >= lower && n <= upper) {
			return true;
		} else {
			return false;
		}
	}

}
