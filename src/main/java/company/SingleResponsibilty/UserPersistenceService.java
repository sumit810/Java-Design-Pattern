package company.SingleResponsibilty;

import company.SingleResponsibilty.Store;
import company.SingleResponsibilty.User;

public class UserPersistenceService {

    private Store store = new Store();

    public void saveUser(User user){
        store.store(user);
    }
}
