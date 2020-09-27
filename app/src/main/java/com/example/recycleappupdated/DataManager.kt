package com.example.recycleappupdated

object DataManager {
    val students = mutableListOf<Student>()

    init {
        createMockData()
    }

    fun createMockData() {
        students.add(Student("Sus", "AU20", true))
        students.add(Student("Ann", "AU20"))
        students.add(Student("Tim", "AU20"))
        students.add(Student("Rack", "AU20"))
        students.add(Student("Nastya", "AU20", true))
        students.add(Student("Ragnar", "AU20"))
        students.add(Student("Eleonor", "AU20"))
        students.add(Student("Olya", "AU20"))
    }
}