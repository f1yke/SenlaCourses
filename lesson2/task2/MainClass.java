import java.util.ArrayList;

interface IOrganizationService {

	int getDepartmentCount();

}


class Man {

	private String name;
	private String surname;

	public Man(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "\nName: " + this.name + "\nSurname: " + this.surname;
	}
}

class Department {

	private String name;
	private ArrayList<Employee> employees;
	private Organization organization;

	public Department(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		this.employees.remove(employee);
		this.employees.trimToSize();
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}

class Employee extends Man {

	private String position;
	private Department department;
	private int salary;

	public Employee(String name, String surname, String position, int salary, Department department) {
		super(name, surname);
		this.position = position;
		this.salary = salary;
		this.department = department;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	} 

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\nName: " + getName() + "\nSurname: " + getSurname() + "\nDepartment: "+ this.department.getName() + "\nPosition: " + this.position + "\nSalary: $" + this.salary;
	}
}

class Organization implements IOrganizationService {
	private String name;
	private ArrayList<Department> departments;

	public Organization(String name) {
		this.name = name;
		departments = new ArrayList<Department>();
	}

	@Override
	public int getDepartmentCount() {
		return this.departments.size();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Department> getDepartments() {
		return this.departments;
	}

	public void addDepartment(Department department) {
		this.departments.add(department);
	}

	public void removeDepartment(Department department) {
		this.departments.remove(department);
	}

	@Override
	public String toString() {
		String result = "\nOrganization: " + this.name + "\nDepartments: ";
		for (int i = 0; i < this.departments.size(); i++) {
			result += departments.get(i).getName() + " ";
		}
		return result;
	}
}

public class MainClass {
	public static void main(String[] args) {

		Organization organization = new Organization("SENLA");
		Department department = new Department("Security department");
		organization.addDepartment(department);
		Employee employee = new Employee("Andrey", "Gavrilchik", "Programmer", 200, department);
		department.addEmployee(employee);

		System.out.println(" \nEmployee info\n" + employee.toString());
		System.out.println(" \nOrganization info\n" + organization.toString());
		System.out.println("Count departments: " + organization.getDepartmentCount());
	}
}