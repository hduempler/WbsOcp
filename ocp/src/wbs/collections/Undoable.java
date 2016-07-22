package wbs.collections;

import java.util.Stack;

public class Undoable {

	// der zustand eines Undoable- Dinges
	private int state;
	private Stack<Integer> states = new Stack<>();

	public Undoable(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int newState) {
		if (newState != state) {
			states.push(state);
			this.state = newState;
		}
	}

	// macht die letzte zustandsänderung rückgängig
	public boolean undo() {
		boolean result = false;
		if (!states.empty()) {
			this.state = states.pop();
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		return String.valueOf(state);
	}

}
