package at.tanguybernard.management_bc.application_core.ports.stubs

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee
import at.tanguybernard.management_bc.application_core.ports.EmployeeRepository

class InMemoryEmployeeRepository: EmployeeRepository {

     private val employees = arrayListOf<Employee>();

    override fun getEmployees(): List<Employee> {
        return employees
    }

    override fun save(employee: Employee) {
        employees.add(employee)
    }
    override fun save(employees: ArrayList<Employee>) {
        this.employees.addAll(employees)
    }
}