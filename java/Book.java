public class Book {
	private String title;
	private String author;
	private int numOfPage;
	private String coverImageUrl;

	public static void main(String[] arguments) {
		Book myBook = new Book("Mortal Instruments", 
			"Cassandra Clair");
		System.out.println(myBook.toString() );
	} 
	public Book(String sTitle, String sAuthor) {
		title = sTitle;
		author = sAuthor;
	} 

	// Accessor
	public String getTitle() {
		return title;
	}

	public String toString() {
		return "Title is " + title + ", by: " + author;
	}
}