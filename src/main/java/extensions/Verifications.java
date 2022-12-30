package extensions;

import utilities.CommonOperations;
import io.qameta.allure.Step;

import java.util.List;

public class Verifications extends CommonOperations {


    //In case all list indexes have the same text  - after sorting
    @Step("Verify the text of each web element in a list is as expected")
    public static void repeatableTextInEachListIndex(List<String> items, String repeatableText) {
        for (int i = 0; i < items.size() ; i++) {
            softAssertion.assertTrue(items.get(i).equalsIgnoreCase(repeatableText));
        }
    }
    @Step("Compare original int value to updated value")
    public static void compareIntValues(int actual, int expectedValue) {
        softAssertion.assertEquals(actual, expectedValue);
    }
    @Step("Verify if a String contains a specific text")
    public static void verifyATextIsIncludedInAString(String str, String expectedValue) {
       softAssertion.assertTrue(str.contains(expectedValue));
    }
    @Step("Verify if a String contains a specific text")
    public static void verifyATextIsNotIncludedInAString(String str, String expectedValue) {
     softAssertion.assertFalse(str.contains(expectedValue));
    }
}