package de.javanarior.vo.validation.constraints;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;

@Test
public class RangeIntegerTest {

    public void testCheckToLow() {
        Constraint<Integer> constraint = new RangeInteger(2, 2);
        ConstraintCheckResult result = constraint.check(1);
        assertThat(result.hasErrors(), is(true));
    }

    public void testCheckToHigh() {
        Constraint<Integer> constraint = new RangeInteger(2, 2);
        ConstraintCheckResult result = constraint.check(3);
        assertThat(result.hasErrors(), is(true));
    }

}
