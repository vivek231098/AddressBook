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
					addressBookManagerImp.openAddressBook(existingAddressBook);
					int i = 0;
					while (i == 0) {
						System.out.println("\t\t\t___________________\n"
								+ "\t\t\t|       Menu\n"
								+ "\t\t\t|\n"
								+ "\t\t\t| 1. Add Contact  \n"
								+ "\t\t\t| 2. Edit Contact   \n"
								+ "\t\t\t| 3. Delete  Contact\n"
								+ "\t\t\t| 4. Search Contact\n"
								+ "\t\t\t| 5. Sort By Name\n"
								+ "\t\t\t| 6. Sort By Zip\n"
								+ "\t\t\t| 7. Display\n"
								+ "\t\t\t| 8. Back to main menu\n"
								+ "\t\t\t|________________________");
						int choose = use.inputInteger();
						switch (choose) {
						case 1:
							addressBookImp.addPerson();
							break;
						case 2:
							addressBookImp.editPerson();
							break;
						case 3:
							addressBookImp.deletePerson();
							break;
						case 4:
							addressBookImp.searchPerson();
							break;
						case 5:
							addressBookImp.sortByName();
							break;
						case 6:
							addressBookImp.sortByZip();
							break;
						case 7:
							addressBookImp.display();
							break;
						case 8:
							System.out.println("\t\t\tGo Back to Main Menu");
							i = 1;
							break;
						default:
							System.out.println("\t\t\tNo such data\n" + "\t\t\tAddress Book named '" + existingAddressBook
									+ "' closed\n");
							addressBookImp.closeAddressBook(existingAddressBook);
							i = 1;
							break;
						}
					}
				} 
				else {
					System.out.println("\t\t\tThis file does not exist");
				}
				break;
