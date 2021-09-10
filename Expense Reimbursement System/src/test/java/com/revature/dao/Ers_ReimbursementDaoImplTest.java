package com.revature.dao;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RunWith(MockitoJUnitRunner.class)
public class Ers_ReimbursementDaoImplTest {


    public Ers_ReimbursementDaoImplTest() {
    }

    @Mock
    private Connection c;

    @Mock
    private PreparedStatement stmt;

    @Mock
    private ResultSet rs;



    @Before
    public void setUp() throws Exception {
        when(c.prepareStatement(any(String.class))).thenReturn(stmt);

        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(" ");
        when(rs.getString(3)).thenReturn(" ");
        when(stmt.executeQuery()).thenReturn(rs);
    }

}
