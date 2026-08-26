import java.util.ArrayList;
import java.util.List;

public class PeopleManager {

    private List<Person> peopleList;

    //construtor
    public PeopleManager(){
        this.peopleList = new ArrayList<>();
    }

    //metodo para retornar a lista de pessoas
    public List<Person> getPeopleList(){
        return peopleList;
    }
    

    //metodo para adicionar/salvar uma pessoa na lista
    public boolean save(Person person){
        if(person != null){
            peopleList.add(person);
            return true;
        }
        return false;
    }
}
