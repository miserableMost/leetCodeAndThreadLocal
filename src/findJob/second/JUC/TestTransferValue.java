package findJob.second.JUC;

import findJob.entities.Person;

/**
 * @author 李聪
 * @date 2020/1/20 15:45
 */
public class TestTransferValue {
    public void changeValue1(int age) {
        age = 30;
    }
    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }
    public void changeValue3(String str) {
        str = "xxx";
    }
    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age---" + age);

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName----" + person.getPersonName());

        String str = "abc";//放在常量池
        test.changeValue3(str);
        System.out.println("string----" + str);
    }
}
