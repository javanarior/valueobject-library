/*
 * Copyright (C) 2014 Sven von Pluto - javanarior (a) gmail dot com
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
package de.javanarior.vo.example.person.typed;

import static de.javanarior.vo.TypeInteger.create;
import static de.javanarior.vo.TypeStringS.create;
import de.javanarior.vo.TypeInteger;
import de.javanarior.vo.TypeStringS;
import de.javanarior.vo.generator.helper.IntType;

public class PersonUsage {

    public static void main(String[] args) {
        // START SNIPPET: usage-implementation
        Person person = new Person(new Firstname(""), new Surname(""));
        // END SNIPPET: usage-implementation

        // START SNIPPET: usage-generator
        Person customer = new Person(create(Firstname.class, ""), TypeStringS.create(Surname.class, ""));
        // END SNIPPET: usage-generator

        create(IntType.class, "2");
    }

}
