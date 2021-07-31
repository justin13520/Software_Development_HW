import java.util.Comparator;

public class CompareByWinsLossesChamps implements Comparator<BasketBallTeam> {
	
	public int compare(BasketBallTeam a, BasketBallTeam b){
		int retVal = -(a.getNumberOfWins()-b.getNumberOfWins());
		if(retVal != 0) {
			return retVal;
		}
		int retVal1 = a.getNumberOfLosses()-b.getNumberOfLosses();
		if(retVal1 != 0) {
			return retVal1;
		}
		int retVal2 = -(a.getNumberOfChampionships()-b.getNumberOfChampionships());
		return retVal2;
	}
}
