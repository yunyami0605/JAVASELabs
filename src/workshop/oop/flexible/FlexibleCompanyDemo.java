package workshop.oop.flexible;

public class FlexibleCompanyDemo {
    public static void main(String[] args) {
        
        MereClerk mereClerk1 = new MereClerk("ö��", 100);
        MereClerk mereClerk2 = new MereClerk("����", 100);
        Manager manager = new Manager("ȫ�浿", 200);
        
        Manager hrMgr = new Manager("�Ѹ�",200,"HR");
        System.out.println(hrMgr.getName());
        System.out.println(hrMgr.getSalary());
        System.out.println(hrMgr.getDept());
        
        Employee itMgr = new Manager("�浿",250,"IT");
        System.out.println(itMgr.getName());
        System.out.println(itMgr.getSalary());
        
        Manager itMgr2 = (Manager)itMgr;
        System.out.println(itMgr2.getDept()); 

        Employee[] emps = new Employee[4]; 
        emps[0] = new Manager("�浿",250,"IT");
        emps[1] = new MereClerk("ö��", 100);
        emps[2] = new MereClerk("����", 100);
        emps[3] = new Manager("�Ѹ�",200,"HR");
        
        System.out.println("���� �����Դϴ�.");
        printEmployInfo(emps);
        
        for(Employee emp: emps) {
        	emp.manageSalary(10);
        }
        
       System.out.println("�ø� ���� �����Դϴ�.");
       printEmployInfo(emps);
                        
   }

	public static void printEmployInfo(Employee[] emps) {
		for(Employee emp: emps) { 

			if(emp instanceof Manager) {
				System.out.print("������ �μ��� = " + ((Manager)emp).getDept() + " ");
			}
        	System.out.println(emp.getName() + "�� ���� ������ " + emp.getSalary() + " ���� �Դϴ�.");        	
        }
	}
}
