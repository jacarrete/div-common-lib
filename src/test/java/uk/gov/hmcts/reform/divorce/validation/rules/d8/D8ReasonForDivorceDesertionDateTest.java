package uk.gov.hmcts.reform.divorce.validation.rules.d8;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.gov.hmcts.reform.divorce.model.ccd.CoreCaseData;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class D8ReasonForDivorceDesertionDateTest {

    private D8ReasonForDivorceDesertionDate rule;
    private CoreCaseData coreCaseData;

    @Before
    public void setup() {
        rule = new D8ReasonForDivorceDesertionDate();
        coreCaseData = new CoreCaseData();
    }

    @Test
    public void whenShouldReturnTrueWhenFactIsDesertionAndD8ReasonForDivorceDesertionDateIsNull() {
        coreCaseData.setD8ReasonForDivorce("desertion");
        rule.setCoreCaseData(coreCaseData);
        boolean result = rule.when();

        assertEquals(true, result);
    }

    @Test
    public void whenShouldReturnFalseWhenFactIsNotDesertionAndD8ReasonForDivorceDesertionDateIsNull() {
        rule.setCoreCaseData(coreCaseData);
        boolean result = rule.when();

        assertEquals(false, result);
    }

    @Test
    public void whenShouldReturnFalseWhenD8ReasonForDivorceDesertionDateIsNotNull() {
        coreCaseData.setD8ReasonForDivorceDesertionDate("dateString");

        rule.setCoreCaseData(coreCaseData);
        boolean result = rule.when();

        assertEquals(false, result);
    }

    @Test
    public void thenShouldReturnErrorMessageWithNull() {
        coreCaseData.setD8ReasonForDivorce("desertion");
        rule.setCoreCaseData(coreCaseData);

        rule.setResult(new ArrayList<>());
        rule.then();

        assertEquals("D8ReasonForDivorceDesertionDate can not be null or empty. Actual data is: null",
            rule.getResult().get(0));
    }
}