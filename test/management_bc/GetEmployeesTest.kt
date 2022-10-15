package management_bc

import at.tanguybernard.management_bc.application_core.application.domain.models.Employee
import at.tanguybernard.management_bc.application_core.application.use_cases.GetEmployees
import at.tanguybernard.management_bc.application_core.ports.stubs.InMemoryEmployeeRepository
import junit.framework.TestCase.assertEquals
import management_bc.application_core.employee.domain.models.EmployeeId
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName


class GetEmployeesTest {

    @Test
    @DisplayName("Should be true")
    fun shouldBeTrue() {
        assertThat(true).isTrue()
    }

    @Test
    fun `should get all employee`() {

        val totoEmployee = Employee(EmployeeId.random(),"TotoJeanPaul", 2)
        val repository = InMemoryEmployeeRepository();
        val useCase = GetEmployees(repository)
        repository.save(totoEmployee)

        assertEquals(useCase.getEmployees(), listOf(totoEmployee))
    }

    @Test
    fun `get employee allowed to work on sunday`() {

        val employeeAllowedToWorkOnSunday = listOf<Employee>(
            Employee(EmployeeId.random(),"Jean Dupuis", 18),
            Employee(EmployeeId.random(),"Paul Ricard", 89),
        )
        val otherEmployee = listOf<Employee>(
            Employee(EmployeeId.random(),"Marc Lavoine", 1),
            Employee(EmployeeId.random(), "Yasine Disserte", 10),
        )
        val list: ArrayList<Employee> = ArrayList()
        list.addAll(employeeAllowedToWorkOnSunday)
        list.addAll(otherEmployee)
        val repository = InMemoryEmployeeRepository();
        val useCase = GetEmployees(repository)
        repository.save(list)

        assertEquals(employeeAllowedToWorkOnSunday, useCase.getEmployeesAllowedToWorkOnSunday())
    }


}