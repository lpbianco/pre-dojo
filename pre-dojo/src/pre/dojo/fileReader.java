package pre.dojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileReader {

	/**
	 * M�todo respons�vel por acessar o arquivo e retornar seu conte�do
	 * @param file
	 * @return List<String>
	 */
	public static List<String> readFile(String file) {
		String content = null;
		List<String> lines = new ArrayList<String>();
		try {							
			File arq = new File(file);
			FileReader fileReader = new FileReader(arq);
			BufferedReader reader = new BufferedReader(fileReader);
			while ((content = reader.readLine()) != null) {
				lines.add(content);
			}
			fileReader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}

