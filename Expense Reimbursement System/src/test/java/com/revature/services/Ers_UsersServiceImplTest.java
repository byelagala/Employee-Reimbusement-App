package com.revature.services;
import static org.junit.jupiter.api.Assertions.*;
import com.revature.dao.Ers_UsersDao;
import com.revature.models.Ers_Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


public class Ers_UsersServiceImplTest {

    Ers_UsersServiceImpl ers_UsersServiceImpl; //reference object for actual class what we are testing
    Ers_UsersDao ers_UsersDao = Mockito.mock(Ers_UsersDao.class); //mock object
    Ers_Users ers_users; //reference object for respective model class

    /*Mockito allows us to "mock" objects...
     * so if there is a method called in the method that we are testing,
     * we can "mock" that method and hardcode a result so we don't have to worry
     * about the logic from that method */

    public Ers_UsersServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        //passing the mock object using Ers_UsersServiceImpl constructor to create an instance
        ers_UsersServiceImpl = new Ers_UsersServiceImpl(ers_UsersDao);
        ers_users = new Ers_Users();
    }

    @AfterEach
    void tearDown() {
        ers_users = null;
    }

    @Test
    void testLoginNull(){
        //assign
        ers_users.setErsUserName("xyz");
        ers_users.setErsPassword("password");

        //mock object.method()
        Mockito.when(ers_UsersDao.getOneUser(Mockito.anyString())).thenReturn(null);

        //act
        Ers_Users resultErs_Users = ers_UsersServiceImpl.login(ers_users);

        //assert
        assertNull(resultErs_Users);
        //assertEquals(ers_users, resultErs_Users);
    }

    @Test
    void testLoginInCorrectPassword(){
        //assign actual values
        ers_users.setErsUserName("nathan");
        ers_users.setErsPassword("password5");

        //act giving incorrect
        Ers_Users expected = new Ers_Users();
        expected.setErsUserName("nathan");
        expected.setErsPassword("password1");

        //mock object.method that we are testing
        Mockito.when(ers_UsersDao.getOneUser(Mockito.anyString())).thenReturn(expected);
        Ers_Users resultErs_Users = ers_UsersServiceImpl.login(ers_users);

        //assert
        assertNull(resultErs_Users);
    }

    @Test
    void testLoginSuccesful(){
        //assign actual
        ers_users.setErsUserName("nathan");
        ers_users.setErsPassword("password5");

        //expected
        Ers_Users expected = new Ers_Users();
        expected.setErsUserName("nathan");
        expected.setErsPassword("password5");

        Mockito.when(ers_UsersDao.getOneUser(Mockito.anyString())).thenReturn(expected);
        Ers_Users resultErs_Users = ers_UsersServiceImpl.login(ers_users);

        assertEquals(ers_users.getErsUserName(),resultErs_Users.getErsUserName());
        assertEquals(ers_users.getErsPassword(),resultErs_Users.getErsPassword());
    }
}
