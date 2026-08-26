public class App {
    public static void main(String[] args) throws Exception {
        PeopleManager manager = new PeopleManager();

        manager.save(new Person("Maria da Silva", "1234"));

        System.out.println(manager.getPeopleList());
    }
}
