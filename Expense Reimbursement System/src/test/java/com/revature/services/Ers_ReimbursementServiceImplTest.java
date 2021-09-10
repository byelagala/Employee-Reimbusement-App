package com.revature.services;
import static org.junit.jupiter.api.Assertions.*;

import com.revature.dao.Ers_ReimbursementDao;
import com.revature.dao.Ers_UsersDao;
import com.revature.models.Ers_Reimbursement;
import com.revature.models.Ers_Users;
import com.revature.models.Reimbursements;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

public class Ers_ReimbursementServiceImplTest {

    Ers_ReimbursementServiceImpl ers_ReimbursementServiceImpl; //reference object of actual class that we are testing

    Ers_ReimbursementDao ers_ReimbursementDao = Mockito.mock(Ers_ReimbursementDao.class); //mock object creates

    Ers_Reimbursement ers_reimbursement;

    /*Mockito allows us to "mock" objects...
     * so if there is a method called in the method that we are testing,
     * we can "mock" that method and hardcode a result so we don't have to worry
     * about the logic from that method */

    public Ers_ReimbursementServiceImplTest() {
    }

    @BeforeEach
    void setUp() {
        //passing the mock object using Ers_ReimbursementServiceImpl constructor
        ers_ReimbursementServiceImpl = new Ers_ReimbursementServiceImpl(ers_ReimbursementDao);
        ers_reimbursement = new Ers_Reimbursement();

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void testUpdateReimbursementRequest(){
        Ers_Reimbursement ers_reimbursement = new Ers_Reimbursement();
        ers_reimbursement.setReimb_receipt("receipt");

        Ers_Reimbursement expected = new Ers_Reimbursement();
        expected.setReimb_receipt("receipt");
        Mockito.when(ers_ReimbursementDao.updateReimbursementRequest(ers_reimbursement)).thenReturn(expected);

        Ers_Reimbursement actual = ers_ReimbursementServiceImpl.updateReimbursementRequest(ers_reimbursement);
        assertEquals(expected.getReimb_receipt(),actual.getReimb_receipt());
    }

    @Test
    public void addReimbursementRequest(){
        //assign
        ers_reimbursement.setReimb_amount(87.00);
        ers_reimbursement.setReimb_description("visiting customer");
        ers_reimbursement.setReimb_receipt("receipt");
        ers_reimbursement.setErs_users_fk_auth(10);
        ers_reimbursement.setErs_users_fk_reslvr(5);
        ers_reimbursement.setErs_reimbursement_status_fk(2);
        ers_reimbursement.setErs_reimbursement_type_fk(3);

       Ers_Reimbursement expected1 = new Ers_Reimbursement();

        //List<Ers_Reimbursement> expected1 = ers_reimbursement;
        //expected
        expected1.setReimb_amount(87.00);
        expected1.setReimb_description("visiting customer");
        expected1.setReimb_receipt("receipt");
        expected1.setErs_users_fk_auth(10);
        expected1.setErs_users_fk_reslvr(5);
        expected1.setErs_reimbursement_status_fk(2);
        expected1.setErs_reimbursement_type_fk(3);

        //hardcoded
        //Mockito.when(ers_ReimbursementDao.addReimbursementRequest(ers_reimbursement)).thenReturn(expected1);

        //act//
//        Ers_Reimbursement actualResult = ers_ReimbursementServiceImpl.addReimbursementRequest(ers_reimbursement);
//
//        assertEquals(expected1.getReimb_amount(), actualResult.getReimb_amount());
//        assertEquals(expected1.getReimb_description(),actualResult.getReimb_description());
//        assertEquals(expected1.getReimb_receipt(), actualResult.getReimb_receipt());
//        assertEquals(expected1.getErs_users_fk_auth(),actualResult.getErs_users_fk_auth());
//        assertEquals(expected1.getErs_users_fk_reslvr(), actualResult.getErs_users_fk_reslvr());
//        assertEquals(expected1.getErs_reimbursement_status_fk(), actualResult.getErs_reimbursement_status_fk());
//        assertEquals(expected1.getErs_reimbursement_type_fk(), actualResult.getErs_reimbursement_type_fk());

        Mockito.verify(ers_ReimbursementDao, Mockito.times(1)).addReimbursementRequest(ers_reimbursement);
    }

    @Test
    public void viewAllReimbTicketsByEmpId(){
        //assign
        Integer ers_users_fk_auth = 6;
        List<Reimbursements> expected = new ArrayList<>();

        Mockito.when(ers_ReimbursementDao.viewAllReimbTicketsByEmpId(ers_users_fk_auth)).thenReturn(expected);

        //act
        List<Reimbursements> actual = ers_ReimbursementServiceImpl.viewAllReimbTicketsByEmpId(ers_users_fk_auth);

        //assert
        assertEquals(expected, actual);
        Mockito.verify(ers_ReimbursementDao, Mockito.times(1)).viewAllReimbTicketsByEmpId(ers_users_fk_auth);
    }

    @Test
    public void viewAllReimbursementsByManagerId(){
        //assign
        Integer ers_users_fk_reslvr = 3;
        List<Reimbursements> expected = new ArrayList<>();

        Mockito.when(ers_ReimbursementDao.viewAllReimbursementsByManagerId(ers_users_fk_reslvr)).thenReturn(expected);

        //act
        List<Reimbursements> actual = ers_ReimbursementServiceImpl.viewAllReimbursementsByManagerId(ers_users_fk_reslvr);

        //assert
        assertEquals(expected, actual);
        Mockito.verify(ers_ReimbursementDao, Mockito.times(1)).viewAllReimbursementsByManagerId(ers_users_fk_reslvr);
    }

    @Test
    public void viewAllEmpReimbursementsByStatus(){//
        //assign
        String reimb_status = "Pending";
        int ers_users_fk_reslvr = 5;

        List<Reimbursements> expected = new ArrayList<>();

        Mockito.when(ers_ReimbursementDao.viewAllEmpReimbursementsByStatus(ers_users_fk_reslvr,reimb_status)).thenReturn(expected);

        //Act
        List<Reimbursements> actual = ers_ReimbursementServiceImpl.viewAllEmpReimbursementsByStatus(ers_users_fk_reslvr,reimb_status);

        //Assert
        assertEquals(expected, actual);
        Mockito.verify(ers_ReimbursementDao, Mockito.times(1)).viewAllEmpReimbursementsByStatus(ers_users_fk_reslvr,reimb_status);

    }

    @Test
    public void viewEmpReimbByStatus(){
        //assign
        String reimb_status = "Approved";
        int ers_users_fk_auth = 1;

        List<Reimbursements> expected = new ArrayList<>();

        Mockito.when(ers_ReimbursementDao.viewAllEmpReimbursementsByStatus(ers_users_fk_auth,reimb_status)).thenReturn(expected);

        //Act
        List<Reimbursements> actual = ers_ReimbursementServiceImpl.viewAllEmpReimbursementsByStatus(ers_users_fk_auth,reimb_status);

        //Assert
        assertEquals(expected, actual);
        Mockito.verify(ers_ReimbursementDao, Mockito.times(1)).viewAllEmpReimbursementsByStatus(ers_users_fk_auth,reimb_status);

    }
}
