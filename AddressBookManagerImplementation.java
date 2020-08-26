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
/*Calls saveAddressBook method in AddressBookImplementation class with the name of file
	  in which data is to be saved*/
	public void saveAddressBook(String file) {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.saveAddressBook(file);
	}

	/*Calls saveAsAddressBook method in AddressBookImplementation class with the name of 
	 * file in which data is to be saved*/
	public void saveAsAddressBook() {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.saveAsAddressBook();
	}

	/*Calls closeAddressBook method in AddressBookImplementation class with the
	 *  name of file whose list is to be cleared if new address book is being opened*/
	public void closeAddressBook(String existingAddressBook) {
		AddressBookImplementation ab = new AddressBookImplementation();
		ab.closeAddressBook(existingAddressBook);
	}

	/* Close the entire address book*/
	@Override
	public void quit() {
		System.exit(0);
	}
