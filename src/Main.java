import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Employee> workers = new ArrayList<Employee>();
		Firm firm = new Firm();
		Manager manager = new Manager(firm);
		manager.start();
		for (int team = 1; team < 4; team++) {
			TeamLeader lead = new TeamLeader(team, manager, firm);
			workers.add(lead);
			lead.start();
			for (int employ = 2; employ < 5; employ++) {
				Developer dev = new Developer(team, employ, lead, firm);
				workers.add(dev);
				dev.start();
			}
		}

		/*
		 * Un-comment these lines to run program with questions. Currently
		 * Program works according to specifications without running questions.
		 * With questions, threads deadlock each other and halt the program
		 * before lunch. Explanation as to why in documentation.
		 * 
		 * QuestionFairy princessSparkleDust = new QuestionFairy(workers, 150, 200, firm);
		 * princessSparkleDust.start();
		 */

		firm.startDay();
	}

}
