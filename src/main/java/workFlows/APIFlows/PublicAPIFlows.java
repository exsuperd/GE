package workFlows.APIFlows;

import io.qameta.allure.Step;
import utilities.CommonOperations;

import java.util.List;

public class PublicAPIFlows extends CommonOperations {

    @Step("Get a list of properties")
    public static List getAndPrintListOfProperties(String resources) {
        response = httpRequest.get(resources);
        jp = response.jsonPath();
        List<String> categoryProperty = jp.getList("entries.Category");
        response.prettyPrint();
        return categoryProperty;
    }
}