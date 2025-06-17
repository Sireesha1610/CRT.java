import java.io.*;
import java.util.*;
public class StudentManagementSystem{
	static HashMap<Integer,String>studentMap=new HashMap<>();
	static final String FILE_NAME="students.txt";
	public static void main(String[] args){
		Scanner sin=new Scanner(System.in);
		int choice;
		do{
			System.out.println("\n--StudentManagement---");
			System.out.println("1.Add student");
			System.out.println("2.save to file");
			System.out.println("3.load from file");
			System.out.println("4.search by ID");
			System.out.println("5.Remove student");
			System.out.println("6.display all students");
			System.out.println("0.Exit");
            System.out.println("enter choice:");
			choice=sin.nextInt();
			switch(choice){
				case 1:addStudent(sin);
				case 2 :saveToFile();
				case 3:loadFromFile();
				case 4:searchStudents(sin);
				case 5:removeStudents(sin);
				case 6:displayall();
				case 0:System.out.println("Exiting program:");
				default:System.out.println("Invalid choice try again:");
			}
		}
		while(choice!=0);
		sin.close();
	}
	static void addStudent(Scanner sin){
		System.out.println("enter student ID:");
		int id=sin.nextInt();
		sin.nextLine();
		System.out.println("enter student name:");
		String name=sin.nextLine();
		if(studentMap.containsKey(id)){
			System.out.println("id already exists!");
		}
		else{
			studentMap.put(id,name);
			System.out.println("Student added");
		}
	}
	static void saveToFile(){
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_NAME))){
			for(Map.Entry<Integer,String>entry:studentMap.entrySet()){
				bw.write(entry.getKey()+','+entry.getValue());
				bw.newLine();
			}
			System.out.println("data saved to file:");
		}
		catch(IOException e){
			System.out.println("error saving to file"+e.getMessage());
		}
	}
	static void loadFromFile(){
		studentMap.clear();
		try(BufferedReader br=new BufferedReader(new FileReader(FILE_NAME))){
			String line;
			while((line=br.readLine())!=null){
				String[]parts=line.split(",");
				int id=Integer.parseInt(parts[0]);
				String name=parts[1];
				studentMap.put(id,name);
			}
			System.out.println("data loaded from file:");
		}
		catch(IOException e){
			System.out.println("error saving to file"+e.getMessage());
		}
	}
	
	static void searchStudents(Scanner sin){
		System.out.println("enter id to search:");
		int id=sin.nextInt();
		if(studentMap.containsKey(id)){
			System.out.println("name:"+studentMap.get(id));
		}
		else{
			System.out.println("student id not found:");
		}
	}
	static void removeStudents(Scanner sin){
		System.out.println("enter id to remove:");
		int id=sin.nextInt();
		if(studentMap.remove(id)!=null){
			System.out.println("student removed:");
		}
		else{
			System.out.println("student id not found:");
		}
	}
	static void displayall(){
		if(studentMap.isEmpty()){
			System.out.println("no of students to display:");
		}
		else{
			System.out.println("\n student list:");
			for(Map.Entry<Integer,String>entry:studentMap.entrySet()){
				System.out.println("id:"+entry.getKey()+",Name:"+entry.getValue());
			}
		}
	}
}
		
		
	
				
			
