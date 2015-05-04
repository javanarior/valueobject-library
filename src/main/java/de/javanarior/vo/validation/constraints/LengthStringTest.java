package de.javanarior.vo.validation.constraints;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;


@Test
public class LengthStringTest {

    public void testCheckToShort() {
        Constraint<String> constraint = new LengthString(2, 2);
        ConstraintCheckResult result = constraint.check("x");
        assertThat(result.hasErrors(), is(true));
    }

    public void testCheckToLong() {
        Constraint<String> constraint = new LengthString(2, 2);
        ConstraintCheckResult result = constraint.check("xxx");
        assertThat(result.hasErrors(), is(true));
    }

}
