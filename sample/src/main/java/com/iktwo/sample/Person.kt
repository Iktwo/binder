package com.iktwo.sample

class Person {
    var firstName: String
    var lastName: String
    var isVI: Boolean = false

    constructor(firstName: String, lastName: String) {
        this.firstName = firstName
        this.lastName = lastName
    }

    constructor(firstName: String, lastName: String, isVI: Boolean) {
        this.firstName = firstName
        this.lastName = lastName
        this.isVI = isVI
    }
}
