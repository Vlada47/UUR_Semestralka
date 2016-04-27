package view.recordObjects;

public class HelpRec {
	
	private String label;
	private String htmlText;
	
	public HelpRec(String label, String htmlText) {
		this.label = label;
		this.htmlText = htmlText;
	}

	public String getLabel() {
		return label;
	}

	public String getHtmlText() {
		return htmlText;
	}
	
	@Override
	public String toString() {
		return label;
	}
}
