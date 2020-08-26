package addressBook;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/*Class contains methods implemented by addressBookInterface methods*/
public class AddressBookImplementation implements AddressBookInterface{

	InputScanner use = new InputScanner();
	public static List<Person> list = new ArrayList<Person>();
	ObjectMapper mapper = new ObjectMapper();

	/*add person to the  person list*/
	public  List<Person> addPerson() {
		list.add(addUser());
		for (Person P : list) {
			System.out.println(P.toString());
		}
		return list;
	}
	
	/*Adding information of person and add it in an object
	 * return object of person will give with added information in it
	 */
		private Person addUser() {
		Person person = new Person();
		System.out.println("\n\t\t\tEnter the First Name of the Person");
		person.setFirstName(use.inputString());
		System.out.println(person.getFirstName());
		System.out.println("\n\t\t\tEnter Last Name of the Person");
		person.setLastName(use.inputString());
		System.out.println("\n\t\t\tEnter the name of city");
		person.setCity(use.inputString());
		System.out.println("\n\t\t\tEnter name of the State State");
		person.setState(use.inputString());
		System.out.println("\n\t\t\tEnter the ZipCode");
		person.setZip(use.inputInteger());
		System.out.println("\n\t\t\tEnter the  Phone Number");
		person.setPhoneNumber(use.inputString());
		return person;
	}
	
	/*Editing information of existing Person from list */
	static int count = 0;
	public void editPerson() {
		System.out.println("\n\t\t\tEnter the phone Number");
		String phoneNumber = use.inputString();
		for (Person P : list) {
			if (phoneNumber.equals(P.getPhoneNumber())) {
				count++;
				System.out.println("\n\t\t\tData found\n");
				System.out.println("\t\t\t1.Edit Firstname and lastname\n\t\t\t2.Edit city,State and zip\n" +"\t\t\t3.Edit Phone Number\n");
				int editChoice = use.inputInteger();
				switch (editChoice) {
				case 1:
					editAddressBookPerson(P, 1);
					break;
				case 2:
					editAddressBookPerson(P, 2);
					break;
				case 3:
					editAddressBookPerson(P, 3);
					break;
				default:
					System.out.println("\t\t\tError !!\n");
				}
			} 
		} 
		if(count==0)
			System.out.println("\n\t\t\tDoes not exist");	
	}
