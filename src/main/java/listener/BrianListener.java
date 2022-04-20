package listener;

import gov.nasa.jpf.JPFListener;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.bytecode.FieldInstruction;
import gov.nasa.jpf.jvm.bytecode.IRETURN;

public class BrianListener extends ListenerAdapter implements JPFListener {
	public int totalMoves;
	public int totalGames;
	public int flag;

	public BrianListener() {
		totalMoves=0;
		totalGames=0;
		flag = 0;
	}

	@Override
	public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction, Instruction executedInstruction) {
		//System.out.println(executedInstruction.toString());
		//mark instruction has been reached, the two put fields instructions afterwards will be position updates
//		if (executedInstruction.toString().contains("ireturn ttsu.game.tictactoe.GameBoard.mark")) {
//			flag = 2;
//			IRETURN ins = (IRETURN) executedInstruction;
//			//System.out.println(ins.getReturnValue(currentThread));
//			if (ins.getReturnValue() == 1) {
//				totalMoves += 1;
//			}
//		
//		}
		
		if (executedInstruction.toString().contains("putfield ttsu.game.tictactoe.TicTacToeGameState.lastMove") && flag == 0) {
			flag = 1;
		}
		
		if(executedInstruction.toString().contains("ireturn ttsu.game.tictactoe.TicTacToeGameState.play(") && flag == 1) {
			totalMoves +=1;
			flag = 0;
		}
		
//		if (executedInstruction instanceof FieldInstruction) {
//			//System.out.println(executedInstruction.getClass());
//			FieldInstruction ins = (FieldInstruction) executedInstruction;
//			String instr = executedInstruction.toString();
//			FieldInfo field = ins.getFieldInfo();
//			String type = field.getType();
//			String name = field.getName();
//			if (type.equals("int") && instr.contains("putfield") && flag > 0) {
//				flag = flag - 1;
//				long val = ins.getLastValue();
//				//wanted to do some position related calculations but no time
//				if (name.equals("row")) {
//					//System.out.println(instr + " row: " + val);
//				} else if (name.equals("col")) {
//					//System.out.println(instr + " col: " + val);
//				}
//			}
//		}
	}
	
	@Override
	public void methodEntered(VM vm, ThreadInfo currentThread, MethodInfo enteredMethod) {
		String methodName = enteredMethod.getName();
		if (methodName.equals("printWinX") || methodName.equals("printWinO") || methodName.equals("printDraw")) {
			totalGames += 1;
		}
	}

	@Override
	public void searchFinished(Search search) {
		System.out.println("Average amount of turns per game: " + totalMoves/totalGames);
	}

}
