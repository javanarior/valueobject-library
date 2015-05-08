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
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;


@Test
@SuppressWarnings("boxing")
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
