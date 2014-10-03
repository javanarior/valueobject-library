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

/**
 * Example Person with value types.
 */
public class Person {

    private final Firstname firstname;
    private final Surname surname;

    public Person(Firstname firstname, Surname surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public Firstname getFirstname() {
        return firstname;
    }

    public Surname getSurename() {
        return surname;
    }

}
