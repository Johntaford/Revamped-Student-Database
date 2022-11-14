import java.util.*;

public class Student {

	public static void main(String[] args) {
		
		String [] studentNames = {"Jim", "Tim", "Tom", "Sam", "Larry", "Harry", "Barry", "Kyle", "Victor", "Chloe"};
		
		String [] hometownCity = { "Royal Oak", "Oak Park", "Rochester", "Troy", "Berkley", "West Bloomfield", "Novi", "Farmington", "Detroit"};
		
		String [] favoriteFood = { "Strawberries", "Blue Berries", "Bananas", "Watermelon", "Kiwi", "Mango", "Grapes", "Oranges", "Apples", "Pineapple"};
		
		Scanner scan = new Scanner(System.in);
		
		Scanner scan1 = new Scanner(System.in);
		
		Scanner scan2 = new Scanner(System.in);
		
		boolean askingUser = true;
		while (askingUser) {
			System.out.println("Welcome to our Java class.  Which student would you like to learn more about? (enter a number 1-10):");
			
			int requestNum = 0;
			String foundStudent = "";
			int numIndex = -1;
			
			try {
				requestNum = scan.nextInt();
				numIndex = requestNum -1;
				foundStudent = studentNames[numIndex];
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("That student does not exist.  Please try again. (enter a number 1-10): ");
			}
			
			while(foundStudent != "") {
				System.out.println("Student " + requestNum + " is " + foundStudent + ".");
				System.out.println("What would you like to know about " + foundStudent + " Hometown or Favorite food");
				String userChoice = scan1.nextLine();
				
				if(userChoice.equalsIgnoreCase("hometown")) {
					System.out.println(findStudentHometown(hometownCity, numIndex, foundStudent));
					foundStudent = "";
				}
				else if (userChoice.equalsIgnoreCase("favorite Food")) {
					System.out.println(findStudentFavFood(favoriteFood, numIndex, foundStudent));
					foundStudent = "";
				}
				else {
					System.out.println("Invalid Option please try again");
				}
				
				boolean promptingToContinue = true;
				while (promptingToContinue) {
					System.out.println("Would you like to know more about another Student? (Enter yes or no)");
					String userContinues = scan2.nextLine();
					
					if (userContinues.equalsIgnoreCase("yes")) {
						promptingToContinue = false;
					}
					else if (userContinues.equalsIgnoreCase("no")) {
						askingUser = false;
						promptingToContinue = false;
				}
					else {
						System.out.println("Sorry, I didn't understand that response. Please try agian.");
					}
			}
		}
		System.out.println("Thanks!");
	}
	
	}

	public static String findStudentFavFood(String[] favoriteFood, int numIndex, String foundStudent) {
		String foundStudentFavFood = favoriteFood[numIndex];
		String result = foundStudent + "'s favorite food is " + foundStudentFavFood + ".";
		return result;
	}

	public static String findStudentHometown(String[] hometownCity, int numIndex, String foundStudent) {
		String findStudentHometown = hometownCity[numIndex];
		String result = foundStudent + "'s hometown is " + findStudentHometown + ".";
		return result;
	}
}