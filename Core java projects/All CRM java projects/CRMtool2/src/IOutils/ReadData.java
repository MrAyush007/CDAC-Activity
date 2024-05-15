package IOutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.app.Customer.Customer;

public interface ReadData {
	static Map<String,Customer> readdata(String name) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))){
			return (Map<String,Customer>)in.readObject();
		}
	}
}
