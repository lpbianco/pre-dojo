package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import pre.dojo.fileReader;

public class testFileReader {

	@Test
	public void testConnect() {
		if(fileReader.readFile("logTest.txt").size()>0){
			assertEquals(1,1);
		}else{
			fail("Erro ao ler arquivo");
		}
	}
}
