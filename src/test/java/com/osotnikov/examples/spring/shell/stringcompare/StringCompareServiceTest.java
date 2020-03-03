package com.osotnikov.examples.spring.shell.stringcompare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = { // Disable spring shell so it won't kick in during tests.
		InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
		ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class StringCompareServiceTest {

	private static final String EXPECTED_5 = "ABCDΩ";

	private static final String ACTUAL_VALID_5 = "ABCDΩ";
	private static final String ACTUAL_INVALID_5_1 = "AXCDΩ";
	private static final String ACTUAL_INVALID_5_2 = "AXΩDΩ";
	private static final String ACTUAL_INVALID_5_5 = "ZΩZΩZ";

	private static final String ACTUAL_INVALID_6 = "ABCDΩA";

	private static final String DIFFERENT_LENGTH_STRINGS_EXCEPTION_MSG = "Arguments are of different lengths!";

	@Autowired
	StringCompareService stringCompareService;

	@Test
	public void findNumberOfDifferencesInEqualLengthStrings_Success() {

		int diffs = stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, ACTUAL_VALID_5);
		Assertions.assertEquals(0, 0);

		diffs = stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, ACTUAL_INVALID_5_1);
		Assertions.assertEquals(1, diffs);

		diffs = stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, ACTUAL_INVALID_5_2);
		Assertions.assertEquals(2, diffs);

		diffs = stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, ACTUAL_INVALID_5_5);
		Assertions.assertEquals(5, diffs);
	}

	@Test
	public void findNumberOfDifferencesInEqualLengthStrings_NullArgument_Fail() {

		Assertions.assertThrows(NullPointerException.class,
				() -> {
					stringCompareService.findNumberOfDifferencesInEqualLengthStrings(null, ACTUAL_VALID_5);
				});

		Assertions.assertThrows(NullPointerException.class,
				() -> {
					stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, null);
				});

		Assertions.assertThrows(NullPointerException.class,
				() -> {
					stringCompareService.findNumberOfDifferencesInEqualLengthStrings(null, null);
				});

	}

	@Test
	public void findNumberOfDifferencesInEqualLengthStrings_DifferentLengths_Fail() {

		Assertions.assertThrows(IllegalArgumentException.class,
				() -> {
					stringCompareService.findNumberOfDifferencesInEqualLengthStrings(EXPECTED_5, ACTUAL_INVALID_6);
				},
				DIFFERENT_LENGTH_STRINGS_EXCEPTION_MSG);

	}

}
