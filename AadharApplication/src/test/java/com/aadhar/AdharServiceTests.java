//package com.aadhar;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.atLeastOnce;
//import static org.mockito.Mockito.atMost;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import java.util.ArrayList;import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import com.aadhar.pojo.Aadhar;
//import com.aadhar.repo.AadharRepoistory;
//import com.aadhar.service.AadharService;
//
//
//@SpringBootTest
//public class AdharServiceTests { 
//	
//	@Mock
//	AadharRepoistory ar;
//	@Autowired
//	AadharService as;
//	ArrayList al;
//
//	@BeforeEach
//	void setUp() throws Exception
//	{
//		MockitoAnnotations.initMocks(this);
//		as=new AadharService(this.ar);
//		al=new ArrayList();
//		al.add(new Aadhar("saiteja","1111"));
//		al.add(new Aadhar("rajesh","2222"));
//		al.add(new Aadhar("ramesh","3333"));
//		al.add(new Aadhar("laxman","4444"));
//	}
//	
//	@Test
//	void testVerifyFindallAadhar() {
//		as.getAllAadhardetails();
//		verify(this.ar).findAll();
//	}
//	
//	@Test
//	void testAdharById()
//	{
//		when(ar.getById("1111")).thenReturn(new Aadhar("saiteja","1111"));
//		Aadhar e1=ar.getById("1111");
//		assertEquals("1111",e1.getAadharnumber());
//	}
//
//	@Test
//	void testShowAadhars()
//	{
//		when(as.getAllAadhardetails()).thenReturn(al);
//		ArrayList l=(ArrayList) as.getAllAadhardetails();
//		assertEquals(4,l.size());
//	}
//	
//	@Test
//	void testAddAadhar()
//	{
//		Aadhar a=new Aadhar("saiteja","1111");
//		when(as.saveAadhar(a)).thenReturn(a);
//		Aadhar e2=as.saveAadhar(a);
//		assertNotNull(e2);
//	}
//
//	@Test
//	void testUpdateAadharName()
//	{
//		Aadhar e1=new Aadhar("saiteja","1111");
//		e1.setName("saitejamada");
//		when(as.updateAadhar(e1, "1111")).thenReturn(e1);
//		assertEquals("saitejamada",e1.getName());
//	}
//
//	@Test
//	void testUpdateAtMost()
//	{
//		Aadhar e1=new Aadhar("saiteja","1111");
//		e1.setName("saitejamada");
//		when(as.updateAadhar(e1, "1111")).thenReturn(e1);
//		atMost(2);
//	}
//
//	@Test
//	void testDelAadhar()
//	{
//		Aadhar e1=new Aadhar("saiteja","1111");
//		as.deleteAadhar("1111");
//		assertTrue(true);
//	}
//
//	@Test
//
//	void testInsertAtleastOnce()
//	{
//		Aadhar e1=new Aadhar("saiteja","1111");
//		when(as.saveAadhar(e1)).thenReturn(e1);
//		atLeastOnce();
//	}
//
//	@Test
//	void testDelAadharAtleastOnce()
//	{
//		Aadhar e1=new Aadhar("saiteja","1111");
//		as.deleteAadhar("1111");
//		atLeastOnce();
//	}
//}
//
