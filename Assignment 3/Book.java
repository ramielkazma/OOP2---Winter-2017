// ---------------------------------------------
// Assignment 3
// Part 1
// COMP 249-U
// Written by: Rami El-Kazma - ID: 40035141
// March 14, 2017
// ---------------------------------------------
public class Book {

	long isbn;
	int issueYear;
	String author;
	String title;
	double price;
	int numberPages;
	
	public Book(){
		
	}
	
	public Book(long isbn, int issueYear, String author, String title, double price, int numberPages){
		this.isbn=isbn;
		this.issueYear=issueYear;
		this.author=author;
		this.title=title;
		this.price=price;
		this.numberPages=numberPages;
	}
	
	public Book(Book b1){
		isbn=b1.isbn;
		issueYear=b1.issueYear;
		author=b1.author;
		title=b1.title;
		price=b1.price;
		numberPages=b1.numberPages;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}
	
	public String toString(){
		return(isbn+" "+title+" "+issueYear+" "+author+" "+price+" "+numberPages);
	}
	
	public boolean equals(Object obj){
		if(this==null||obj==null||getClass()!=obj.getClass())
			return false;
		else
		{
			Book b1 = (Book) obj;
			return(isbn==b1.isbn&&issueYear==b1.issueYear&&author==b1.author&&title==b1.title&&
					price==b1.price&&numberPages==b1.numberPages);
		}
	}
	
}
