/*
 * Copyright (C) 2015 Sven von Pluto - javanarior (a) gmail dot com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.javanarior.vo.validation.constraints;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@SuppressWarnings("boxing")
public class ContraintTest {

    private static final String CUSTOME_MESSAGE = "customeMessage";

    /* CHECKSTYLE:OFF */
    @DataProvider(name = "constraints")
    public Object[][] getContraints() throws ParseException {
        /* CHECKSTYLE:ON */
        /* @formatter:off */
        return new Object[][] {
            {new NotNullConstraint<Integer>(), 1, null, new NotNullConstraint<Integer>(CUSTOME_MESSAGE)},
            {new NotZeroInteger(), 1, 0, new NotZeroInteger(CUSTOME_MESSAGE)},
            {new PositiveInteger(), 1, -1, new PositiveInteger(CUSTOME_MESSAGE)},
            {new RangeInteger(3, 4), 3, 5, new RangeInteger(3, 4, CUSTOME_MESSAGE)},
            {new LengthString(2, 2), "xx", "x", new LengthString(2, 2, CUSTOME_MESSAGE)},
            {new RegExString("AA"), "AA", "a", new RegExString("AA", CUSTOME_MESSAGE)}

        };
        /* @formatter:on */
    }

    @Test(dataProvider = "constraints")
    public <T extends Comparable<T>> void testCheckSuccess(Constraint<T> constraint, T valueSuccess,
                    T valueFailure, Constraint<T> customConstraint) {
        ConstraintCheckResult result = constraint.check(valueSuccess);
        assertThat(result.hasErrors(), is(false));
    }

    @Test(dataProvider = "constraints")
    public <T extends Comparable<T>> void testCheckFailure(Constraint<T> constraint, T valueSuccess,
                    T valueFailure, Constraint<T> customConstraint) {
        ConstraintCheckResult result = constraint.check(valueFailure);
        assertThat(result.hasErrors(), is(true));
    }

    @Test(dataProvider = "constraints")
    public <T extends Comparable<T>> void testCheckCustomerMessage(Constraint<T> constraint, T valueSuccess,
                    T valueFailure, Constraint<T> customConstraint) {
        ConstraintCheckResult result = customConstraint.check(valueFailure);
        assertThat(result.hasErrors(), is(true));
        assertThat(result.getMessage(), equalTo(CUSTOME_MESSAGE));
    }

}
