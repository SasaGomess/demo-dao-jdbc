package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===== TEST 1: department finById ======");

		Department department = departmentDao.findById(1);
		System.out.println(department);

		System.out.println();

		System.out.println("===== TEST 2: department delete by id ======");
		System.out.print("Enter id value for department delete");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete was completed");

		System.out.println();

		System.out.println("===== TEST 3: department update ======");
		department = departmentDao.findById(3);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println(department);
		
		System.out.println();

		System.out.println("===== TEST 4: department insert ======");
		Department departamento1 = new Department(null, "Fashion");
		departmentDao.insert(departamento1);
		System.out.println("New department id: " + departamento1.getId());

		System.out.println();

		System.out.println("===== TEST 5: department findAll ======");
		List<Department> depp = new ArrayList<>();
		depp = departmentDao.findAll();
		System.out.println(depp + "\n");

		sc.close();
	}

}
