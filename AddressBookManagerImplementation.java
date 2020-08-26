package addressBook;
import java.io.IOException;
import java.io.File;

/*Class contains methods implemented by addressBookManagerInterface methods*/
public  class AddressBookManagerImplementation implements AddressBookManagerInterface{

	 /*Creates a new file in the address book*/
	public void newAddressBook() throws IOException {
		InputScanner use = new InputScanner();
		System.out.println("\n\t\t\tEnter the name of address book");
		String NewAddressBookName = use.inputString();
		File file = new File("AddressBook//" + NewAddressBookName + ".json");
		if (file.createNewFile()) {
			System.out.println("\n\t\t\tCreated new file");
		} else {
			System.out.println("\n\t\t\tThis file already exists.");
		}
		
	}	
	
	/* calls read method in the AddressBookImplementationto to open the addressbook 
	 * in the file*/
	@Override
	public void openAddressBook(String existingAddressBook)throws Exception {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.read(existingAddressBook);
	}
