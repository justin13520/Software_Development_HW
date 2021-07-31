import java.util.Comparator;

public class CompareByPlayoffsAndSalary implements Comparator<BasketBallTeam> {
	public static void main(String[] args) {
		CompareByPlayoffsAndSalary a = new CompareByPlayoffsAndSalary();
		if(a instanceof Comparator) {
			System.out.println("apple");
		}
	}
	public CompareByPlayoffsAndSalary() {
		
	}
	public int compare(BasketBallTeam a, BasketBallTeam b){
		if(a.isPlayoffTeam() && !b.isPlayoffTeam()) {
			return -1;
		}
		else if(!a.isPlayoffTeam() && b.isPlayoffTeam()){
			return 1;
			}
		else {
			return (int) (a.getSalaryInMillions()-b.getSalaryInMillions());
			}
		}
	}

