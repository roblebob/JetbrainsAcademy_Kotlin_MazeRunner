open class Employee(val name: String, val age: Int, var yearsOfWork: Int = 0)

class Programmer(name: String, age: Int, yearsOfWork: Int) : Employee(name, age, yearsOfWork) {
    // Write your code here
    constructor(name: String, age: Int) : this(name, age, 0)
}