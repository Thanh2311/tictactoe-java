package listener;

import gov.nasa.jpf.JPFListener;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

public class WinLossCounter extends ListenerAdapter implements JPFListener {

	private int winCounter;
	private int lossCounter;
	private int drawCounter;
	
	public WinLossCounter() {
		winCounter = lossCounter = drawCounter = 0;
		
	}
	
	@Override
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		String methodName = enteredMethod.getName();
		if (methodName.equals("printWinX")) {
			winCounter++;
		}
		else if (methodName.equals("printWinO")) {
			lossCounter++;
		}
		else if (methodName.equals("printDraw")) {
			drawCounter++;
		}
		
	}
	
	@Override
	public void searchFinished(Search search) {
		System.out.println("Wins : " + winCounter);
		System.out.println("Losses : " + lossCounter);
		System.out.println("Draws : " + drawCounter);
	}

}
