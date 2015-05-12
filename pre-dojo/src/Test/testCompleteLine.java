package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pre.dojo.Line;

public class testCompleteLine {

	@Test
	public void testCaptureStart() {
		String start = "23/04/2013 15:34:22 - New match 11348965 has started";
		Line l = new Line();
		l.setStart(start.contains("started")?true:false);
		assertEquals(true,l.getStart());
	}

	@Test
	public void testCaptureEnd() {
		String end = "23/04/2013 15:39:22 - Match 11348965 has ended";
		Line l = new Line();
		l.setEnd(end.contains("ended")?true:false);
		assertEquals(true,l.getEnd());
	}

	@Test
	public void testContent() {
		String content = "23/04/2013 15:39:22 - Match 11348965 has ended";
		Line l = new Line();
		l.setEnd(content.contains("ended")?true:false);
		l.setStart(content.contains("started")?true:false);
		l.setContent(content);
		assertEquals(true,l.getEnd());
		assertEquals(false,l.getStart());
		assertEquals(content,l.getContent());
	}
}
	
	