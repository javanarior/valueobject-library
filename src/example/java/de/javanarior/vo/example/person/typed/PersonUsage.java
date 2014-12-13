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

//import static de.javanarior.vo.TypeInteger.create;
import static de.javanarior.vo.TypeInteger.create;
import static de.javanarior.vo.TypeString.create;
import de.javanarior.vo.TypeInteger;
import de.javanarior.vo.TypeString;
import de.javanarior.vo.example.types.IntType;

public class PersonUsage {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // START SNIPPET: usage-implementation
        Person person = new Person(new Firstname(""), new Surname(""));
        // END SNIPPET: usage-implementation

        // START SNIPPET: usage-generator
        Firstname first = TypeString.create(Firstname.class, "first");
        Surname sur = create(Surname.class, "sur");
        Person customer = new Person(first, sur);
        // END SNIPPET: usage-generator

        TypeInteger.create(IntType.class, "2");
        create(IntType.class, "2");
    }

}
