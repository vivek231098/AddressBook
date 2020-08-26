package addressBook;
/*Main class for the Address Book, where all the methods are called from this class*/
public class Main {
	public static void main(String[] args) throws Exception {
		InputScanner use = new InputScanner();
		AddressBookManagerImplementation addressBookManagerImp = new AddressBookManagerImplementation();
		String existingAddressBook = "" ;
		int loop = 0;

		while (loop == 0) {
			AddressBookImplementation addressBookImp = new AddressBookImplementation();
			System.out.println("\t\t\t________________________________________________\n"
					+ "\t\t\t\t\t Address Book \t\t\t\n"
					+ "\t\t\t\t\t--------------\t\t\t\n"
					+ "\t\t\t\t1. Create\t\t\n"
					+ "\t\t\t\t2. Open\t\t\t\n"
					+ "\t\t\t\t3. Save\t\t\t\n"
					+ "\t\t\t\t4. Save As \t\t\t\n"
					+ "\t\t\t\t5. Close\n"  
					+ "\t\t\t\t6. Quit \t\t\t\n"
					+ "\t\t\t_______________________________________________\n");
			int choice = use.inputInteger();
			switch (choice) {
			case 1:
				addressBookManagerImp.closeAddressBook(existingAddressBook);
				addressBookManagerImp.newAddressBook();
				break;
			case 2:
				addressBookManagerImp.closeAddressBook(existingAddressBook);
				addressBookManagerImp.readAddress();
				System.out.println("\n\t\t\tName your address book\n");
				existingAddressBook = use.inputString();
				if (addressBookManagerImp.checkAddress(existingAddressBook)) {
					System.out.println("\t\t\tThis file already exists\n");
