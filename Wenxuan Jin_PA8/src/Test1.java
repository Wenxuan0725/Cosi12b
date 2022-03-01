import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test1 {
	private final InputStream systemIn = System.in;
	private final PrintStream systemOut = System.out;

	private ByteArrayInputStream testIn;
	private ByteArrayOutputStream testOut;
	
	private static final Map<Class<?>, Object> DEFAULT_VALUES = Stream
            .of(boolean.class, byte.class, char.class, double.class, float.class, int.class, long.class, short.class)
            .collect(Collectors.toMap(clazz -> (Class<?>) clazz, clazz -> Array.get(Array.newInstance(clazz, 1), 0)));

	@Before
	public void setUpOutput() {
		testOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOut));
	}

	private void provideInput(String data) {
		testIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(testIn);
	}

	private ArrayList<String> getOutputToArrayList() {
		ArrayList<String> result = new ArrayList<String>(Arrays.asList(testOut.toString().split("\n")));
		return result;
	}

	private boolean checkOutputForStrings(String... in) {
		boolean[] result = { true };
		Arrays.asList(in).forEach(s -> {
			result[0] &= getOutputToArrayList().stream().anyMatch(e -> ((String) e).matches(s + "[\\r\\n]*$"));
		});
		return result[0];
	}
	
	@SuppressWarnings("unchecked")
    public static <T> T forClass(Class<T> clazz) {
        return (T) DEFAULT_VALUES.get(clazz);
    }

	@After
	public void restoreSystemInputOutput() {
		System.setIn(systemIn);
		System.setOut(systemOut);

		Field[] fields = TAChecker.class.getDeclaredFields();
		for (Field f : fields) {
			if (Modifier.isStatic(f.getModifiers())) {
				f.setAccessible(true);
				try {
					if (Collection.class.isAssignableFrom(f.getType())) {
						Collection<?> c = (Collection<?>) f.get(f);
						c.clear();
						f.set(f, c);
					} else if (Map.class.isAssignableFrom(f.getType())) {
						Map<?, ?> m = (Map<?, ?>) f.get(f);
						m.clear();
						f.set(f, m);
					} else if (f.getType().isPrimitive()) {
						f.set(f, Test1.forClass(f.getType()));
					} else {
						f.set(f, null);
					}
				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testCaseA() throws FileNotFoundException {
		provideInput("testCase1.txt");
		TAChecker.main(null);
		assertTrue(checkOutputForStrings());
		assertTrue(getOutputToArrayList().size() == 1);
	}

	@Test
	public void testCaseB() throws FileNotFoundException {
		provideInput("testCase2.txt");
		TAChecker.main(null);
		assertTrue(checkOutputForStrings("5;Den;UNSTARTED_JOB"));
		assertTrue(getOutputToArrayList().size() == 2);
	}

	@Test
	public void testCaseC() throws FileNotFoundException {
		provideInput("testCase3.txt");
		TAChecker.main(null);
		assertTrue(checkOutputForStrings("3;Evil;SHORTENED_JOB"));
		assertTrue(getOutputToArrayList().size() == 2);
	}

	@Test
	public void testCaseD() throws FileNotFoundException {
		provideInput("testCase4.txt");
		TAChecker.main(null);
		assertTrue(checkOutputForStrings("3;Jen;SHORTENED_JOB", "4;Jen;SHORTENED_JOB"));
		assertTrue(getOutputToArrayList().size() == 3);
	}

}