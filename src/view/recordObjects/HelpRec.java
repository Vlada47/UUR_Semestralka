package view.recordObjects;

/**
 * Instances of this class represents records (individual topics) for help guide navigation tree.
 * @author Vlada47
 *
 */
public class HelpRec {
	
	/**
	 * Label of the topic.
	 */
	private final String label;
	
	/**
	 * Content of the topic.
	 */
	private final String htmlText;
	
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
