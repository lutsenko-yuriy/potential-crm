package com.iurii.demo.entity

import jakarta.persistence.*

@Entity
@Table(name = "employee")
class Employee(
    @Column(name = "first_name") var firstName: String = "",
    @Column(name = "last_name") var lastName: String = "",
    @Column(name = "email") var email: String = "",
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null


    override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', email='$email', id=$id)"
    }
}