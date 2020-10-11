package controller;

public abstract class DataProcessing {

	public void processingDataRequest() {
		visitingUserItemObject();
		returningUserItemObject();
		savingUserItemObjectAgain();
	}

	public abstract void visitingUserItemObject();

	public abstract void savingUserItemObjectAgain();

	public abstract void returningUserItemObject();

}
