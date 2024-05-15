package IOutils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.Customer.Customer;

public class WriteData {
	static void writedata(Map<String,Customer> list,String name) throws IOException {
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(name))){
			out.writeObject(list);
		}
	}
}
