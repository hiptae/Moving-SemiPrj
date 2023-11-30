package kr.co.mpago.service;

import org.junit.Test;

import kr.co.mpago.domain.Cast;
import lombok.extern.log4j.Log4j;

@Log4j
public class CastServiceTests {
	CastService castService = CastService.getCastService();
	
	//OK
	@Test
	public void testAddCast() {
		Long castno = 2l;
		Cast cast = castService.getCast(castno);
		castService.addCast(cast);
	}
	
	//OK
	@Test
	public void testGetCast() {
		Long castno = 2l;
		castService.getCast(castno);
	}
	
	//OK
	@Test
	public void testRemoveCast() {
		Long castno = 1l;
		castService.removeCast(castno);
	}
	
	//OK
	@Test
	public void testModifyCast() {
		Cast cast = castService.getCast(2l);
		cast.setName("test변경된이름2");
		castService.modifyCast(cast);
	}
	
	//OK
	@Test
	public void testGetCastList() {
		castService.getCastList();
	}
	
}
