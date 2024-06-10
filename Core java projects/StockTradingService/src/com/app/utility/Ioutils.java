package com.app.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.stocks.Stock;

public interface Ioutils {
	
		
		// add a static method for storing student details , in a bin file using ser.
		static void writeDetails( String fileName,Map<String, Stock> stock) throws IOException {
			// Java App --> OOS --> FOS (bin file)
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
				out.writeObject(stock);// serialization
			} // out.close --fos.close --close the file handle
		}
		static Map<String, Stock> readDetails( String fileName) throws IOException, ClassNotFoundException {
			// Java App --> OOS --> FOS (bin file)
			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
				return (Map<String, Stock>)in.readObject();// serialization
			} // out.close --fos.close --close the file handle
		}
	}
